import React from "react";

// we use chair Component (to show chair details)
const Chair = ({ details }) => (
  // A box to display chair details
  <div
    style={{ border: "1px solid gray", padding: "10px", borderRadius: "5px" }}
  >
    <h3>🪑 Chair</h3>
    {/* Show chair name */}
    <p>
      <b>Name:</b> {details.name}
    </p>
    {/* Show chair price */}
    <p>
      <b>Price:</b> ₹{details.price}
    </p>
    {/* Show chair material */}
    <p>
      <b>Material:</b> {details.material}
    </p>
    {/* Show chair brand */}
    <p>
      <b>Brand:</b> {details.brand}
    </p>
  </div>
);

// Table Component (to show table details)
const Table = ({ details }) => (
  // A box to display table details
  <div
    style={{ border: "1px solid gray", padding: "10px", borderRadius: "5px" }}
  >
    <h3>🛋️ Table</h3>
    <p>
      <b>Name:</b> {details.name}
    </p>
    <p>
      <b>Price:</b> ₹{details.price}
    </p>
    <p>
      <b>Material:</b> {details.material}
    </p>
    {/* Table also has size */}
    <p>
      <b>Size:</b> {details.size}
    </p>
    <p>
      <b>Brand:</b> {details.brand}
    </p>
  </div>
);

// Sofa Component (to show sofa details)
const Sofa = ({ details }) => (
  // A box to display sofa details
  <div
    style={{ border: "1px solid gray", padding: "10px", borderRadius: "5px" }}
  >
    <h3>🛋️ Sofa</h3>
    <p>
      <b>Name:</b> {details.name}
    </p>
    <p>
      <b>Price:</b> ₹{details.price}
    </p>
    <p>
      <b>Material:</b> {details.material}
    </p>
    <p>
      <b>Size:</b> {details.size}
    </p>
    <p>
      <b>Brand:</b> {details.brand}
    </p>
  </div>
);

// Bed Component (to show bed details)
const Bed = ({ details }) => (
  // A box to display bed details
  <div
    style={{ border: "1px solid gray", padding: "10px", borderRadius: "5px" }}
  >
    <h3>🛏️ Bed</h3>
    <p>
      <b>Name:</b> {details.name}
    </p>
    <p>
      <b>Price:</b> ₹{details.price}
    </p>
    <p>
      <b>Material:</b> {details.material}
    </p>
    <p>
      <b>Size:</b> {details.size}
    </p>
    <p>
      <b>Brand:</b> {details.brand}
    </p>
  </div>
);

// Furniture data (details of each furniture stored here)
export const furnitureData = {
  // Chair details
  Chair: {
    name: "Office Chair",
    price: 2500,
    material: "Plastic",
    brand: "Nilkamal",
  },
  // Table details
  Table: {
    name: "Dining Table",
    price: 8000,
    material: "Wood",
    size: "6x4 ft",
    brand: "Godrej",
  },
  // Sofa details
  Sofa: {
    name: "Leather Sofa",
    price: 15000,
    material: "Leather",
    size: "3-Seater",
    brand: "IKEA",
  },
  // Bed details
  Bed: {
    name: "King Size Bed",
    price: 20000,
    material: "Wood",
    size: "King",
    brand: "Durian",
  },
};

// Function to decide which furniture component to show
export const renderFurniture = (type, details) => {
  switch (type) {
    case "Chair": // If selected type is "Chair"
      return <Chair details={details} />;
    case "Table": // If selected type is "Table"
      return <Table details={details} />;
    case "Sofa": // If selected type is "Sofa"
      return <Sofa details={details} />;
    case "Bed": // If selected type is "Bed"
      return <Bed details={details} />;
    default: // If nothing matches
      return <p>Please select a furniture item.</p>;
  }
};
