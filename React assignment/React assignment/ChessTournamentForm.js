//here we are importing React and useState
import React, { useState } from "react";
// import Formik and Yup for forms and validation
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";

// Our Form Component
const ChessTournamentForm = () => {
  // Store submitted player entries in state
  const [players, setPlayers] = useState([]);

  // Validation rules using Yup
  const validationSchema = Yup.object({
    playerName: Yup.string()
      .min(3, "At least 3 characters")
      .required("Required"),
    dob: Yup.date()
      .required("Required")
      .test("age", "Age must be between 5 and 90", (value) => {
        if (!value) return false;
        const today = new Date();
        const birthDate = new Date(value);
        const age = today.getFullYear() - birthDate.getFullYear();
        return age >= 5 && age <= 90;
      }),
    gender: Yup.string().required("Required"),
    fideId: Yup.string()
      .matches(/^\d{8}$/, "Must be exactly 8 digits")
      .required("Required"),
    rating: Yup.number()
      .min(100, "Min rating 100")
      .max(3000, "Max rating 3000")
      .required("Required"),
    email: Yup.string().email("Invalid email").required("Required"),
    mobile: Yup.string()
      .matches(/^[6-9]\d{9}$/, "Must be 10 digits starting with 6-9")
      .required("Required"),
    country: Yup.string().required("Required"),
    category: Yup.string().required("Required"),
    parentContact: Yup.string().when("category", {
      is: "Under 12",
      then: (schema) =>
        schema
          .matches(/^[6-9]\d{9}$/, "Must be valid 10-digit number")
          .required("Parent contact required for U12"),
      otherwise: (schema) => schema.notRequired(),
    }),
    paymentConfirmed: Yup.boolean().oneOf([true], "Payment must be confirmed"),
    terms: Yup.boolean().oneOf([true], "You must accept terms"),
  });

  // Initial form values
  const initialValues = {
    playerName: "",
    dob: "",
    gender: "",
    fideId: "",
    rating: "",
    email: "",
    mobile: "",
    country: "",
    category: "",
    parentContact: "",
    paymentConfirmed: false,
    terms: false,
  };

  // On form submit
  const handleSubmit = (values, { resetForm }) => {
    console.log("Registration Data:", values); // Log to console
    setPlayers([...players, values]); // Add to table
    resetForm(); // Reset form after submit
  };

  return (
    <div>
      {/* Formik wrapper */}
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
      >
        {/* Formik gives us "Form" wrapper */}
        <Form className="border p-4 rounded shadow">
          {/* Player Name */}
          <div className="mb-3">
            <label>Player Name</label>
            <Field name="playerName" className="form-control" />
            <ErrorMessage
              name="playerName"
              component="div"
              className="text-danger"
            />
          </div>

          {/* DOB */}
          <div className="mb-3">
            <label>Date of Birth</label>
            <Field type="date" name="dob" className="form-control" />
            <ErrorMessage name="dob" component="div" className="text-danger" />
          </div>

          {/* Gender */}
          <div className="mb-3">
            <label>Gender</label>
            <Field as="select" name="gender" className="form-control">
              <option value="">Select</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Other">Other</option>
            </Field>
            <ErrorMessage
              name="gender"
              component="div"
              className="text-danger"
            />
          </div>

          {/* FIDE ID */}
          <div className="mb-3">
            <label>FIDE ID</label>
            <Field name="fideId" className="form-control" />
            <ErrorMessage
              name="fideId"
              component="div"
              className="text-danger"
            />
          </div>

          {/* Rating */}
          <div className="mb-3">
            <label>Rating</label>
            <Field type="number" name="rating" className="form-control" />
            <ErrorMessage
              name="rating"
              component="div"
              className="text-danger"
            />
          </div>

          {/* Email */}
          <div className="mb-3">
            <label>Email</label>
            <Field type="email" name="email" className="form-control" />
            <ErrorMessage
              name="email"
              component="div"
              className="text-danger"
            />
          </div>

          {/* Mobile */}
          <div className="mb-3">
            <label>Mobile</label>
            <Field name="mobile" className="form-control" />
            <ErrorMessage
              name="mobile"
              component="div"
              className="text-danger"
            />
          </div>

          {/* Country */}
          <div className="mb-3">
            <label>Country</label>
            <Field name="country" className="form-control" />
            <ErrorMessage
              name="country"
              component="div"
              className="text-danger"
            />
          </div>

          {/* Category */}
          <div className="mb-3">
            <label>Category</label>
            <Field as="select" name="category" className="form-control">
              <option value="">Select</option>
              <option value="Under 12">Under 12</option>
              <option value="Under 18">Under 18</option>
              <option value="Open">Open</option>
            </Field>
            <ErrorMessage
              name="category"
              component="div"
              className="text-danger"
            />
          </div>

          {/* Parent Contact */}
          <div className="mb-3">
            <label>Parent Contact</label>
            <Field name="parentContact" className="form-control" />
            <ErrorMessage
              name="parentContact"
              component="div"
              className="text-danger"
            />
          </div>

          {/* Payment Confirmed */}
          <div className="form-check mb-3">
            <Field
              type="checkbox"
              name="paymentConfirmed"
              className="form-check-input"
            />
            <label className="form-check-label">Payment Confirmed</label>
            <ErrorMessage
              name="paymentConfirmed"
              component="div"
              className="text-danger"
            />
          </div>

          {/* Terms */}
          <div className="form-check mb-3">
            <Field type="checkbox" name="terms" className="form-check-input" />
            <label className="form-check-label">
              Accept Terms & Conditions
            </label>
            <ErrorMessage
              name="terms"
              component="div"
              className="text-danger"
            />
          </div>

          {/* Submit button */}
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </Form>
      </Formik>

      {/* Table to show submitted data */}
      <h4 className="mt-4">Registered Players</h4>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Name</th>
            <th>DOB</th>
            <th>Gender</th>
            <th>FIDE ID</th>
            <th>Rating</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Country</th>
            <th>Category</th>
            <th>Parent Contact</th>
            <th>Payment</th>
            <th>Terms</th>
          </tr>
        </thead>
        <tbody>
          {players.map((p, index) => (
            <tr key={index}>
              <td>{p.playerName}</td>
              <td>{p.dob}</td>
              <td>{p.gender}</td>
              <td>{p.fideId}</td>
              <td>{p.rating}</td>
              <td>{p.email}</td>
              <td>{p.mobile}</td>
              <td>{p.country}</td>
              <td>{p.category}</td>
              <td>{p.parentContact}</td>
              <td>{p.paymentConfirmed ? "Yes" : "No"}</td>
              <td>{p.terms ? "Yes" : "No"}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ChessTournamentForm;
