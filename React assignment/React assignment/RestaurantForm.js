import React, { useState, useEffect } from "react";

const RestaurantForm = () => {
  // we use usestate to store all input field values
  const [formData, setFormData] = useState({
    restaurantName: "",
    ownerName: "",
    email: "",
    contact: "",
    address: "",
    cuisine: "",
    hours: "",
  });

  // State to store submitted data (after clicking submit)
  const [submittedData, setSubmittedData] = useState(null);

  // useEffect - Runs once when page loads → shows welcome message
  useEffect(() => {
    console.log("Welcome to Restaurant Registration Form!");
    alert("Welcome to Restaurant Registration Form!");
  }, []);

  // Function to update state whenever input box changes
  const handleChange = (e) => {
    // spread operator (...) keeps old values and only updates the new one
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Function to handle submit button click
  const handleSubmit = (e) => {
    e.preventDefault(); // stops page refresh
    setSubmittedData(formData); // saves entered data into submittedData
  };

  return (
    // Outer box with some padding and center alignment
    <div style={{ padding: "20px", maxWidth: "500px", margin: "auto" }}>
      {/* Title */}
      <h1 style={{ textAlign: "center", color: "black" }}>
        🍴 Restaurant Registration Form
      </h1>

      {/* Subtitle */}
      <p style={{ textAlign: "center" }}>
        Welcome to Restaurant Registration 🏨
      </p>

      {/* Form starts */}
      <form
        onSubmit={handleSubmit}
        style={{ display: "flex", flexDirection: "column" }}
      >
        {/* Restaurant Name */}
        <label>Restaurant Name</label>
        <input
          type="text"
          name="restaurantName"
          value={formData.restaurantName}
          onChange={handleChange}
          style={{ marginBottom: "10px" }}
        />

        {/* Owner Name */}
        <label>Owner Name</label>
        <input
          type="text"
          name="ownerName"
          value={formData.ownerName}
          onChange={handleChange}
          style={{ marginBottom: "10px" }}
        />

        {/* Email */}
        <label>Email</label>
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
          style={{ marginBottom: "10px" }}
        />

        {/* Contact */}
        <label>Contact Number</label>
        <input
          type="text"
          name="contact"
          value={formData.contact}
          onChange={handleChange}
          style={{ marginBottom: "10px" }}
        />

        {/* Address */}
        <label>Address</label>
        <input
          type="text"
          name="address"
          value={formData.address}
          onChange={handleChange}
          style={{ marginBottom: "10px" }}
        />

        {/* Cuisine */}
        <label>Cuisine Type</label>
        <input
          type="text"
          name="cuisine"
          value={formData.cuisine}
          onChange={handleChange}
          style={{ marginBottom: "10px" }}
        />

        {/* Hours */}
        <label>Opening Hours</label>
        <input
          type="text"
          name="hours"
          value={formData.hours}
          onChange={handleChange}
          style={{ marginBottom: "10px" }}
        />

        {/* Submit button */}
        <button type="submit" style={{ marginTop: "10px" }}>
          Submit
        </button>
      </form>
      {/* Form ends */}

      {/* Show submitted JSON if available */}
      {submittedData && (
        <div style={{ marginTop: "20px" }}>
          <h3>📂 Submitted Data (JSON)</h3>
          <pre>{JSON.stringify(submittedData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
};

export default RestaurantForm;