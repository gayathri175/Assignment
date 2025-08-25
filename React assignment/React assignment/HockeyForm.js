// import React and useState (to store submitted players list)
import React, { useState } from "react";

// import Formik tools to build the form and handle fields easily
import { Formik, Form, Field, ErrorMessage, FieldArray } from "formik";

// Import Yup to write validation rules
import * as Yup from "yup";

// a small helper to calculate age correctly from a date string
const getAgeFromDOB = (dob) => {
  // here below if no date given, return 0 to be safe
  if (!dob) return 0;
  // make Date objects for birth date and today's date
  const birth = new Date(dob);
  const today = new Date();
  // Start with year difference
  let age = today.getFullYear() - birth.getFullYear();
  // adjust age if birthday hasn’t happened yet this year
  const hasNotHadBirthdayThisYear =
    today.getMonth() < birth.getMonth() ||
    (today.getMonth() === birth.getMonth() &&
      today.getDate() < birth.getDate());
  // if birthday is still coming, reduce age by 1
  if (hasNotHadBirthdayThisYear) age--;
  // now return the final age
  return age;
};

// Build validation rules using Yup (matches the question requirements)
const validationSchema = Yup.object({
  // Player name: only letters/spaces, 3–40 characters, required
  playerName: Yup.string()
    .matches(/^[A-Za-z ]+$/, "Only letters and spaces allowed")
    .min(3, "Minimum 3 characters")
    .max(40, "Maximum 40 characters")
    .required("Player Name is required"),

  // Jersey number: integer 1–99, required
  jerseyNumber: Yup.number()
    .typeError("Jersey number must be a number")
    .integer("Jersey number must be an integer")
    .min(1, "Must be between 1 and 99")
    .max(99, "Must be between 1 and 99")
    .required("Jersey number is required"),

  // Position: choose one, required
  position: Yup.string().required("Position is required"),

  // Stick hand: choose Left or Right, required
  stickHand: Yup.string().required("Stick hand is required"),

  // Date of birth: required + age between 10 and 55
  dateOfBirth: Yup.string()
    .required("Date of Birth is required")
    .test("age-range", "Age must be between 10 and 55", (value) => {
      // Use helper to compute age and check the range
      const age = getAgeFromDOB(value);
      return age >= 10 && age <= 55;
    }),

  // Nationality: required
  nationality: Yup.string().required("Nationality is required"),

  // Email: must be valid and required
  email: Yup.string().email("Invalid email").required("Email is required"),

  // Phone: Indian format, 10 digits, starts with 6–9, required
  phone: Yup.string()
    .matches(/^[6-9]\d{9}$/, "Must be 10 digits starting with 6–9")
    .required("Phone number is required"),

  // Player ID: required format HOCK-XXXX (X are digits)
  playerId: Yup.string()
    .matches(/^HOCK-\d{4}$/, "Format must be HOCK-XXXX (e.g., HOCK-1234)")
    .required("Player ID is required"),

  // Guardian name: required only if age < 18
  guardianName: Yup.string().when("dateOfBirth", (dob, schema) => {
    // If DOB exists and age < 18, make it required
    if (dob && getAgeFromDOB(dob) < 18) {
      return schema.required("Guardian name is required for under 18");
    }
    // Otherwise, optional
    return schema;
  }),

  // Team name: required
  teamName: Yup.string().required("Team name is required"),

  // League level: required (Amateur/College/Pro)
  leagueLevel: Yup.string().required("League level is required"),

  // Tournament name: required
  tournamentName: Yup.string().required("Tournament name is required"),

  // Start date: required
  startDate: Yup.date()
    .typeError("Invalid date")
    .required("Start date is required"),

  // End date: required and must be same or after start date
  endDate: Yup.date()
    .typeError("Invalid date")
    .required("End date is required")
    .min(Yup.ref("startDate"), "End date must be on or after start date"),

  // Jersey size: required if position is NOT Goalie
  jerseySize: Yup.string().when("position", {
    // If position is anything other than Goalie
    is: (pos) => pos && pos !== "Goalie",
    // Then jerseySize is required
    then: (schema) => schema.required("Jersey size is required"),
    // Else not required
    otherwise: (schema) => schema.notRequired(),
  }),

  // Pad size: required if position is Goalie
  padSize: Yup.string().when("position", {
    // If position is exactly Goalie
    is: "Goalie",
    // Then padSize is required
    then: (schema) => schema.required("Pad size is required"),
    // Else not required
    otherwise: (schema) => schema.notRequired(),
  }),

  // Medical condition checkbox: boolean
  hasMedicalCondition: Yup.boolean(),

  // Medical cert number: required if hasMedicalCondition is true, format MED-XXXX
  medicalCertNumber: Yup.string().when("hasMedicalCondition", {
    is: true,
    then: (schema) =>
      schema
        .matches(/^MED-\d{4}$/, "Format must be MED-XXXX (e.g., MED-1234)")
        .required("Medical certificate number is required"),
    otherwise: (schema) => schema.notRequired(),
  }),

  // Consent checkbox: must be checked to submit
  consent: Yup.boolean().oneOf([true], "You must give consent to submit"),

  // Past teams: up to 3 items, each with clubName and years
  pastTeams: Yup.array().of(
    // Each past team object must follow these rules
    Yup.object({
      // Club name: 2–30 characters, required
      clubName: Yup.string()
        .min(2, "Minimum 2 characters")
        .max(30, "Maximum 30 characters")
        .required("Club name is required"),
      // Years: integer 1–20, required
      years: Yup.number()
        .typeError("Years must be a number")
        .integer("Years must be an integer")
        .min(1, "Minimum 1 year")
        .max(20, "Maximum 20 years")
        .required("Years is required"),
    })
  ),
});

// Create the main HockeyForm component that holds the form and the table
function HockeyForm() {
  // Keep an array of submitted players so we can show them in a table
  const [players, setPlayers] = useState([]);

  // Set the initial values for all form fields (empty/default)
  const initialValues = {
    // Player fields
    playerName: "",
    jerseyNumber: "",
    position: "",
    stickHand: "",
    dateOfBirth: "",
    nationality: "",
    email: "",
    phone: "",
    playerId: "",
    guardianName: "",
    // Team/event fields
    teamName: "",
    leagueLevel: "",
    tournamentName: "",
    startDate: "",
    endDate: "",
    jerseySize: "",
    padSize: "",
    // Medical fields
    hasMedicalCondition: false,
    medicalCertNumber: "",
    // Consent field
    consent: false,
    // Past teams list (starts empty)
    pastTeams: [],
  };

  // Handle form submission (runs when user presses Submit)
  const onSubmit = (values, { resetForm }) => {
    // Log the values to the browser console as requested
    console.log("Form Submitted:", values);
    // Add the new player to our array so it appears in the table
    setPlayers((prev) => [...prev, values]);
    // Clear the form back to the initial values
    resetForm();
  };

  // Return the form UI and the table below it
  return (
    // Margin on top to separate from the page title
    <div className="mt-4">
      {/* Formik wraps our form and gives us helpers + validation */}
      <Formik
        // Give initial field values
        initialValues={initialValues}
        // Give the Yup validation rules
        validationSchema={validationSchema}
        // Function to call on submit
        onSubmit={onSubmit}
        // Validate immediately so Submit starts disabled if invalid
        validateOnMount
      >
        {/* Formik gives us useful props inside this function */}
        {({ values, isValid }) => (
          // Use Formik's <Form> instead of normal <form>
          <Form>
            {/* ===== Player Details Card ===== */}
            <div className="card p-3 mb-3">
              {/* Card title */}
              <h4 className="mb-3">Player Details</h4>

              {/* Player Name field */}
              <div className="mb-3">
                <label className="form-label">Player Name</label>
                <Field name="playerName" className="form-control" />
                <ErrorMessage
                  name="playerName"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Jersey Number field */}
              <div className="mb-3">
                <label className="form-label">Jersey Number (1–99)</label>
                <Field
                  name="jerseyNumber"
                  type="number"
                  className="form-control"
                />
                <ErrorMessage
                  name="jerseyNumber"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Position select */}
              <div className="mb-3">
                <label className="form-label">Position</label>
                <Field as="select" name="position" className="form-select">
                  <option value="">Select Position</option>
                  <option value="Forward">Forward</option>
                  <option value="Defense">Defense</option>
                  <option value="Goalie">Goalie</option>
                </Field>
                <ErrorMessage
                  name="position"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Stick Hand select */}
              <div className="mb-3">
                <label className="form-label">Stick Hand</label>
                <Field as="select" name="stickHand" className="form-select">
                  <option value="">Select Hand</option>
                  <option value="Left">Left</option>
                  <option value="Right">Right</option>
                </Field>
                <ErrorMessage
                  name="stickHand"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Date of Birth field */}
              <div className="mb-3">
                <label className="form-label">Date of Birth</label>
                <Field
                  name="dateOfBirth"
                  type="date"
                  className="form-control"
                />
                <ErrorMessage
                  name="dateOfBirth"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Nationality field */}
              <div className="mb-3">
                <label className="form-label">Nationality</label>
                <Field name="nationality" className="form-control" />
                <ErrorMessage
                  name="nationality"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Email field */}
              <div className="mb-3">
                <label className="form-label">Email</label>
                <Field name="email" type="email" className="form-control" />
                <ErrorMessage
                  name="email"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Phone field */}
              <div className="mb-3">
                <label className="form-label">Phone (India)</label>
                <Field
                  name="phone"
                  className="form-control"
                  placeholder="10 digits, starts with 6–9"
                />
                <ErrorMessage
                  name="phone"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Player ID field */}
              <div className="mb-3">
                <label className="form-label">Player ID (HOCK-XXXX)</label>
                <Field
                  name="playerId"
                  className="form-control"
                  placeholder="e.g., HOCK-1234"
                />
                <ErrorMessage
                  name="playerId"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Guardian Name (only required if age < 18) */}
              <div className="mb-3">
                <label className="form-label">
                  Guardian Name (required if under 18)
                </label>
                <Field name="guardianName" className="form-control" />
                <ErrorMessage
                  name="guardianName"
                  component="div"
                  className="text-danger"
                />
              </div>
            </div>

            {/* ===== Team & Event Information Card ===== */}
            <div className="card p-3 mb-3">
              {/* Card title */}
              <h4 className="mb-3">Team & Event Information</h4>

              {/* Team Name */}
              <div className="mb-3">
                <label className="form-label">Team Name</label>
                <Field name="teamName" className="form-control" />
                <ErrorMessage
                  name="teamName"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* League Level */}
              <div className="mb-3">
                <label className="form-label">League Level</label>
                <Field as="select" name="leagueLevel" className="form-select">
                  <option value="">Select Level</option>
                  <option value="Amateur">Amateur</option>
                  <option value="College">College</option>
                  <option value="Pro">Pro</option>
                </Field>
                <ErrorMessage
                  name="leagueLevel"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Tournament Name */}
              <div className="mb-3">
                <label className="form-label">Tournament Name</label>
                <Field name="tournamentName" className="form-control" />
                <ErrorMessage
                  name="tournamentName"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Start Date */}
              <div className="mb-3">
                <label className="form-label">Start Date</label>
                <Field name="startDate" type="date" className="form-control" />
                <ErrorMessage
                  name="startDate"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* End Date */}
              <div className="mb-3">
                <label className="form-label">End Date</label>
                <Field name="endDate" type="date" className="form-control" />
                <ErrorMessage
                  name="endDate"
                  component="div"
                  className="text-danger"
                />
              </div>

              {/* Jersey Size (only if NOT Goalie) */}
              {values.position !== "Goalie" && (
                <div className="mb-3">
                  <label className="form-label">
                    Jersey Size (if not Goalie)
                  </label>
                  <Field as="select" name="jerseySize" className="form-select">
                    <option value="">Select Jersey Size</option>
                    <option value="XS">XS</option>
                    <option value="S">S</option>
                    <option value="M">M</option>
                    <option value="L">L</option>
                    <option value="XL">XL</option>
                  </Field>
                  <ErrorMessage
                    name="jerseySize"
                    component="div"
                    className="text-danger"
                  />
                </div>
              )}

              {/* Pad Size (only if Goalie) */}
              {values.position === "Goalie" && (
                <div className="mb-3">
                  <label className="form-label">Pad Size (Goalie only)</label>
                  <Field as="select" name="padSize" className="form-select">
                    <option value="">Select Pad Size</option>
                    <option value="Small">Small</option>
                    <option value="Medium">Medium</option>
                    <option value="Large">Large</option>
                  </Field>
                  <ErrorMessage
                    name="padSize"
                    component="div"
                    className="text-danger"
                  />
                </div>
              )}
            </div>

            {/* Medical & Consent Card */}
            <div className="card p-3 mb-3">
              {/* Card title */}
              <h4 className="mb-3">Medical & Consent</h4>

              {/* Has Medical Condition checkbox */}
              <div className="form-check mb-2">
                <Field
                  type="checkbox"
                  name="hasMedicalCondition"
                  className="form-check-input"
                  id="hasMedicalCondition"
                />
                <label
                  className="form-check-label"
                  htmlFor="hasMedicalCondition"
                >
                  I have a medical condition
                </label>
              </div>

              {/* Medical Certificate Number (only if hasMedicalCondition is true) */}
              {values.hasMedicalCondition && (
                <div className="mb-3">
                  <label className="form-label">
                    Medical Certificate Number (MED-XXXX)
                  </label>
                  <Field
                    name="medicalCertNumber"
                    className="form-control"
                    placeholder="e.g., MED-1234"
                  />
                  <ErrorMessage
                    name="medicalCertNumber"
                    component="div"
                    className="text-danger"
                  />
                </div>
              )}

              {/* Consent checkbox (must be checked) */}
              <div className="form-check">
                <Field
                  type="checkbox"
                  name="consent"
                  className="form-check-input"
                  id="consent"
                />
                <label className="form-check-label" htmlFor="consent">
                  I agree to the terms & conditions
                </label>
                <ErrorMessage
                  name="consent"
                  component="div"
                  className="text-danger"
                />
              </div>
            </div>

            {/* ===== Past Teams (Dynamic FieldArray) ===== */}
            <div className="card p-3 mb-3">
              {/* Card title */}
              <h4 className="mb-3">Past Teams (up to 3)</h4>

              {/* FieldArray lets us add/remove groups of fields */}
              <FieldArray name="pastTeams">
                {({ push, remove }) => (
                  // Wrapper for the dynamic list
                  <div>
                    {/* Loop over each past team the user added */}
                    {values.pastTeams.map((_, index) => (
                      // One block per past team
                      <div key={index} className="border rounded p-3 mb-3">
                        {/* Club Name field for this team */}
                        <div className="mb-2">
                          <label className="form-label">Club Name</label>
                          <Field
                            name={`pastTeams.${index}.clubName`}
                            className="form-control"
                          />
                          <ErrorMessage
                            name={`pastTeams.${index}.clubName`}
                            component="div"
                            className="text-danger"
                          />
                        </div>

                        {/* Years field for this team */}
                        <div className="mb-2">
                          <label className="form-label">Years</label>
                          <Field
                            name={`pastTeams.${index}.years`}
                            type="number"
                            className="form-control"
                          />
                          <ErrorMessage
                            name={`pastTeams.${index}.years`}
                            component="div"
                            className="text-danger"
                          />
                        </div>

                        {/* Remove button to delete this past team */}
                        <button
                          type="button"
                          className="btn btn-sm btn-danger"
                          onClick={() => remove(index)}
                        >
                          Remove
                        </button>
                      </div>
                    ))}

                    {/* Add button (only show if we have less than 3 past teams) */}
                    {values.pastTeams.length < 3 && (
                      <button
                        type="button"
                        className="btn btn-sm btn-secondary"
                        onClick={() => push({ clubName: "", years: "" })}
                      >
                        Add Past Team
                      </button>
                    )}
                  </div>
                )}
              </FieldArray>
            </div>

            {/* ===== Submit Button ===== */}
            <div className="d-flex gap-2">
              {/* Disable submit until all fields are valid */}
              <button
                type="submit"
                className="btn btn-primary"
                disabled={!isValid}
              >
                Submit Registration
              </button>
              {/* Small helper text so users know why it can be disabled */}
              {!isValid && (
                <span className="text-muted align-self-center">
                  (Fill required fields to enable Submit)
                </span>
              )}
            </div>
          </Form>
        )}
      </Formik>

      {/* ===== Table of Submitted Players ===== */}
      {/* table-responsive makes a horizontal scroll if table is wide */}
      <div className="mt-4 table-responsive">
        {/* Section title */}
        <h4>Registered Players</h4>

        {/* A Bootstrap table with borders and zebra stripes */}
        <table className="table table-bordered table-striped">
          {/* Table header */}
          <thead className="table-light">
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Jersey</th>
              <th>Position</th>
              <th>Stick</th>
              <th>DOB (Age)</th>
              <th>Nationality</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Player ID</th>
              <th>Team</th>
              <th>League</th>
              <th>Tournament</th>
              <th>Start</th>
              <th>End</th>
              <th>Jersey Size</th>
              <th>Pad Size</th>
              <th>Medical?</th>
              <th>Med Cert</th>
              <th>Guardian</th>
              <th>Past Teams</th>
            </tr>
          </thead>

          {/* Table body with one row per submitted player */}
          <tbody>
            {/* Map over the players array and output each row */}
            {players.map((p, i) => (
              // Use index as key since these are short-lived rows
              <tr key={i}>
                {/* Serial number */}
                <td>{i + 1}</td>
                {/* Basic info */}
                <td>{p.playerName}</td>
                <td>{p.jerseyNumber}</td>
                <td>{p.position}</td>
                <td>{p.stickHand}</td>
                {/* Show DOB and computed age */}
                <td>
                  {p.dateOfBirth} ({getAgeFromDOB(p.dateOfBirth)})
                </td>
                <td>{p.nationality}</td>
                <td>{p.email}</td>
                <td>{p.phone}</td>
                <td>{p.playerId}</td>
                {/* Team/event info */}
                <td>{p.teamName}</td>
                <td>{p.leagueLevel}</td>
                <td>{p.tournamentName}</td>
                <td>{p.startDate}</td>
                <td>{p.endDate}</td>
                {/* Size fields (may be empty depending on position) */}
                <td>{p.jerseySize || "-"}</td>
                <td>{p.padSize || "-"}</td>
                {/* Medical info */}
                <td>{p.hasMedicalCondition ? "Yes" : "No"}</td>
                <td>{p.medicalCertNumber || "-"}</td>
                {/* Guardian shown if provided */}
                <td>{p.guardianName || "-"}</td>
                {/* Past teams summarized as "Club (Years)" joined by commas */}
                <td>
                  {p.pastTeams && p.pastTeams.length > 0
                    ? p.pastTeams
                        .map((t) => `${t.clubName} (${t.years})`)
                        .join(", ")
                    : "-"}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

// Export the HockeyForm component so App.js can import and show it
export default HockeyForm;
