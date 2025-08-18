import React, { Component } from "react"; // import React and Component from react
// here iam creating a class component called MarriageForm
class MarriageForm extends Component {
  // Define initial state with empty fields
  state = {
    brideName: "", // Stores bride's name
    groomName: "", // Stores groom's name
    date: "", // Stores marriage date
    venue: "", // Stores venue
    submitted: false, // To check if form is submitted
  };

  // here below fun used to handles the input changes for all fields
  //e =eventobject it willl pass automatically like typing an input
  handleChange = (e) => {
    // Update state dynamically using input field's name attribute
    this.setState({ [e.target.name]: e.target.value });
  };
  //instead of wrting extra lines of code we used above
  // Handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // Prevents page reload on form submit like we cant reload if we want to reload means we can comment it.
    this.setState({ submitted: true }); // Mark form as submitted
  };

  // Render method is mandatory in class components and used to show this in ui
  render() {
    return (
      <div className="container my-5">
        {/* Bootstrap card for styling */}
        <div className="card p-4 shadow">
          <h2 className="text-center mb-4">Marriage Form</h2>

          {/* Form starts here */}
          <form onSubmit={this.handleSubmit}>
            {/* Bride Name */}
            <div className="form-group mb-3">
              <label>Bride Name</label>
              <input
                type="text"
                name="brideName" // Must match state property
                className="form-control" //its a bootstrap class for styling
                value={this.state.brideName} // Controlled input i.e.,the input value comes from state like it always in sync
                onChange={this.handleChange} // Update state when typing
                required
              />
            </div>

            {/* Groom Name */}
            <div className="form-group mb-3">
              <label>Groom Name</label>
              <input
                type="text"
                name="groomName" //must match state property
                className="form-control" //bootstrap class used for styling
                value={this.state.groomName} //controlled input it should be always in sync
                onChange={this.handleChange} //handles chnges and updates
                required
              />
            </div>

            {/* Marriage Date */}
            <div className="form-group mb-3">
              <label>Marriage Date</label>
              <input
                type="date"
                name="date"
                className="form-control"
                value={this.state.date}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Venue */}
            <div className="form-group mb-3">
              <label>Venue</label>
              <input
                type="text"
                name="venue"
                className="form-control"
                value={this.state.venue}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Submit button  and it will trigger to this.handlesubmit*/}
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Show Marriage Details only after submission  and below 96thline is conditional rendering tech*/}
        {this.state.submitted && ( //&&means it shows only this.state.submitted is true
          <div className="card p-4 shadow mt-4">
            <h2 className="text-center mb-4">Marriage Details</h2>
            <p>
              <strong>Bride Name:</strong> {this.state.brideName}
            </p>
            <p>
              <strong>Groom Name:</strong> {this.state.groomName}
            </p>
            <p>
              <strong>Date:</strong> {this.state.date}
            </p>
            <p>
              <strong>Venue:</strong> {this.state.venue}
            </p>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm; // Export component so we can use it in App.js
