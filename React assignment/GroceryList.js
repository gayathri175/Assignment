import React from "react";

function GroceryList({ items }) {
  return (
    <div>
      <h2>Groceries List:</h2>
      <ul>
        {items.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
      <button onClick={() => alert("Groceries Added to Cart!")}>
        Add to Cart
      </button>
    </div>
  );
}

export default GroceryList;