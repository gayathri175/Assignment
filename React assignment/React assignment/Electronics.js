import React, { useState } from "react";

function Electronics() {
  const [name] = useState("Laptop");
  const [brand, setBrand] = useState("Dell");
  const [price, setPrice] = useState(5500);

  const changeBrand = () => {
    setBrand("HP");
  };

  const increasePrice = () => {
    setPrice(price + 500);
  };

  return (
    <div>
      <h2>Electronic Item Details</h2>
      <p>Name: {name}</p>
      <p>Brand: {brand}</p>
      <p>Price: ₹{price}</p>
      <button onClick={changeBrand}>Change Brand</button>
      <button onClick={increasePrice}>Increase Price</button>
    </div>
  );
}

export default Electronics;
