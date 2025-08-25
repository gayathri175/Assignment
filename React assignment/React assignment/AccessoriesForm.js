// Import React and Component class from react
import React, { Component } from "react";
// Create a Class Component called AccessoriesForm
class AccessoriesForm extends Component {
  constructor(props) {
    //constructor in react is used to intilize the state
    super(props); //it calls parent cls constructor without it we cant use this.stae inside thi

    // Initialize state with empty values
    this.state = {
      accessoryName: "", // Text input
      description: "", // Textarea
      category: "Mobile", // Dropdown default
      brand: "", // Radio button
      inStock: false, // Checkbox
      warranty: "", // Number input
      submittedData: [], // Store all submitted entries
    };
  }

  // Function to handle changes in inputs (for text, textarea, select, radio, checkbox, number)
  handleChange = (e) => {
    const { name, value, type, checked } = e.target; // Get values from the event
    this.setState({
      [name]: type === "checkbox" ? checked : value, // For checkbox use checked, for others use value
    });
  };

  // Function to handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // prevents page refresh

    // destructure values from state
    const { accessoryName, description, category, brand, inStock, warranty } =
      this.state;

    // Create a new entry object
    const newEntry = {
      accessoryName,
      description,
      category,
      brand,
      inStock,
      warranty,
    };

    // Update submittedData array and reset the form
    this.setState((prevState) => ({
      submittedData: [...prevState.submittedData, newEntry],
      // add new entry and we used spread operatorinstead of modifying the old array we create a new updated array.
      accessoryName: "", // Reset text
      description: "", // Reset textarea
      category: "Mobile", // Reset dropdown
      brand: "", // Reset radio
      inStock: false, // Reset checkbox
      warranty: "", // Reset number
    }));
  };

  // Render method → Displays UI
  render() {
    return (
      <div className="container mt-5">
        {/* Title */}
        <h2 className="text-center mb-4 text-primary">Accessories Form</h2>

        {/* Form */}
        <form
          className="card p-4 shadow-lg border-0"
          onSubmit={this.handleSubmit} // Call handleSubmit when form is submitted
        >
          {/* Text Input */}
          <div className="form-group mb-3">
            <label>Accessory Name</label>
            <input
              type="text"
              name="accessoryName"
              className="form-control"
              value={this.state.accessoryName} // Controlled input the input value always comes from react state like it controlled so we use this.state like that
              onChange={this.handleChange} // Updates state on typing
              required
            />
          </div>

          {/* Textarea */}
          <div className="form-group mb-3">
            <label>Description</label>
            <textarea
              name="description"
              className="form-control"
              value={this.state.description} //the value of the textarea is controlled by React state.
              onChange={this.handleChange}
            />
          </div>

          {/* Select Dropdown */}
          <div className="form-group mb-3">
            <label>Category</label>
            <select
              name="category"
              className="form-control"
              value={this.state.category}
              onChange={this.handleChange}
            >
              <option>Mobile</option>
              <option>Laptop</option>
              <option>Tablet</option>
              <option>Smartwatch</option>
            </select>
          </div>

          {/* Radio Buttons */}
          <div className="form-group mb-3">
            <label>Brand</label>
            <div>
              <input
                type="radio"
                name="brand"
                value="Apple"
                checked={this.state.brand === "Apple"}
                onChange={this.handleChange}
              />{" "}
              Apple
              <br />
              <input
                type="radio"
                name="brand"
                value="Samsung"
                checked={this.state.brand === "Samsung"}
                onChange={this.handleChange}
              />{" "}
              Samsung
              <br />
              <input
                type="radio"
                name="brand"
                value="Dell"
                checked={this.state.brand === "Dell"}
                onChange={this.handleChange}
              />{" "}
              Dell
            </div>
          </div>

          {/* Checkbox */}
          <div className="form-check mb-3">
            <input
              type="checkbox"
              name="inStock"
              className="form-check-input"
              checked={this.state.inStock}
              onChange={this.handleChange}
            />
            <label className="form-check-label">Available in stock</label>
          </div>

          {/* Number Input */}
          <div className="form-group mb-3">
            <label>Warranty (years)</label>
            <input
              type="number"
              name="warranty"
              className="form-control"
              value={this.state.warranty}
              onChange={this.handleChange}
              min="0"
            />
          </div>

          {/* Submit Button */}
          <button type="submit" className="btn btn-primary w-100">
            Submit
          </button>
        </form>

        {/* Table to display submitted data */}
        {this.state.submittedData.length > 0 && (
          <div className="mt-5">
            <h3 className="text-center text-success mb-3">
              Submitted Accessories
            </h3>
            <table className="table table-bordered table-striped text-center shadow-sm">
              <thead className="table-primary">
                <tr>
                  <th>Name</th>
                  <th>Description</th>
                  <th>Category</th>
                  <th>Brand</th>
                  <th>In Stock</th>
                  <th>Warranty</th>
                </tr>
              </thead>
              <tbody>
                {/* loop through submitted data and display in table */}
                {this.state.submittedData.map((item, index) => (
                  <tr key={index}>
                    <td>{item.accessoryName}</td>
                    <td>{item.description}</td>
                    <td>{item.category}</td>
                    <td>{item.brand}</td>
                    <td>{item.inStock ? "Yes" : "No"}</td>
                    <td>{item.warranty} year(s)</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}
//above arrow function is there right for that
//this.state.submittedData this is an array in component state and it stores all accessories submitted using form
//the .map() function loops through the array.
// export component so it can be used in App.js
export default AccessoriesForm;
