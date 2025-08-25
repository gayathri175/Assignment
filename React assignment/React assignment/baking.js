// BakingItemsForm Component
// This component handles the form + state + table display

import React, { useState } from "react";
//usestate is used in function component its a hook its used to add the state variables to functional comp
function BakingItemsForm() {
  // state to manage form fields its a single object for all inputs
  const [formData, setFormData] = useState({
    //in fromdata its already stores somethng setfromdata means update
    itemName: "",
    quantity: "",
    ingredients: "",
    bakingTime: "",
    category: "Cake", // default value
  });

  // state to store list of baking items and react gives array with 2 strings that is itesm setitems
  const [items, setItems] = useState([]);

  // handle input changes dynamically coz we are not using calss comp right
  const handleChange = (e) => {
    //event obj is passed automatically when the input changes
    const { name, value } = e.target; //e.target is nthng but element that triggered the event for ex input like we give name and value
    setFormData({ ...formData, [name]: value }); // update only the changed field and we used spread operator
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault(); //we cant restore or refresh

    // add the current form data into items array by using spread operator
    setItems([...items, formData]);
    //above we used 2 times spread coz for upadting like  first we are updating single field name next items
    // we can reset form fields
    setFormData({
      itemName: "",
      quantity: "",
      ingredients: "",
      bakingTime: "",
      category: "Cake", //already default
    });
  };

  return (
    //bootstrap class and we givenbootstrap card comp for style
    <div className="container mt-4">
      {/* card wrapper */}
      <div className="card p-4 shadow">
        <h2> Baking Items Form</h2>

        {/* Form starts here */}
        <form onSubmit={handleSubmit}>
          {/* Item Name */}
          <div className="mb-3">
            <label>Item Name</label>
            <input
              type="text"
              name="itemName"
              value={formData.itemName}
              onChange={handleChange}
              className="form-control"
              required
            />
          </div>

          {/* Quantity */}
          <div className="mb-3">
            <label>Quantity</label>
            <input
              type="number"
              name="quantity"
              value={formData.quantity}
              onChange={handleChange}
              className="form-control"
              required
            />
          </div>

          {/* Ingredients */}
          <div className="mb-3">
            <label>Ingredients</label>
            <input
              type="text"
              name="ingredients"
              value={formData.ingredients}
              onChange={handleChange}
              className="form-control"
              required
            />
          </div>

          {/* Baking Time */}
          <div className="mb-3">
            <label>Baking Time (minutes)</label>
            <input
              type="number"
              name="bakingTime"
              value={formData.bakingTime}
              onChange={handleChange}
              className="form-control"
              required
            />
          </div>

          {/* Category */}
          <div className="mb-3">
            <label>Category</label>
            <select
              name="category"
              value={formData.category}
              onChange={handleChange}
              className="form-select"
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          {/* Submit button */}
          <button type="submit" className="btn btn-success">
            Add Baking Item
          </button>
        </form>
      </div>

      {/* Table Section */}
      <div className="mt-4">
        <h3>Baking Items List</h3>
        <table className="table table-bordered table-striped">
          <thead className="table-dark">
            <tr>
              <th>#</th>
              <th>Item Name</th>
              <th>Quantity</th>
              <th>Ingredients</th>
              <th>Baking Time</th>
              <th>Category</th>
            </tr>
          </thead>
          <tbody>
            {items.map(
              (
                item,
                index //the arrow function is used inside .map() because we need a callback function that takes each item in the array
              ) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{item.itemName}</td>
                  <td>{item.quantity}</td>
                  <td>{item.ingredients}</td>
                  <td>{item.bakingTime} mins</td>
                  <td>{item.category}</td>
                </tr>
              )
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default BakingItemsForm;
