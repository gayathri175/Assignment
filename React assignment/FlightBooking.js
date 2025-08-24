import React, { Component, createRef } from "react";

//controlled form
class FlightBookingControlled extends Component {
  constructor(props) {
    //we use this because in a class component the constructor initializes state and binds methods, and super(props) calls the parent React.Component constructor so that this.props is available inside the component
    super(props);
    // stores input values inside state
    this.state = {
      passengerName: "",
      email: "",
      gender: "Male",
      meal: "Veg",
      request: "",
      submittedData: null, // store submitted details
    };
  }

  // when we types in input, update state
  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  //here below it does when the form is submitted
  handleSubmit = (e) => {
    e.preventDefault(); // stop page refresh
    this.setState({
      //here i can also write in destructing like const{passengerName, email, gender, meal, request} = this.state; and we sould use  spread
      submittedData: {
        passengerName: this.state.passengerName,
        email: this.state.email,
        gender: this.state.gender,
        meal: this.state.meal,
        request: this.state.request,
      },
    });
  };

  render() {
    return (
      <div className="col-md-6">
        <h3>Controlled Flight Booking Form</h3>

        {/* Controlled Form */}
        <form onSubmit={this.handleSubmit}>
          {/* Name */}
          <div className="mb-2">
            <label>Passenger Name</label>
            <input
              type="text"
              name="passengerName"
              className="form-control"
              value={this.state.passengerName} // its a comtrolled class coz the value of input is managed by react state
              onChange={this.handleChange}
              required
            />
          </div>

          {/* Email */}
          <div className="mb-2">
            <label>Email</label>
            <input
              type="email"
              name="email"
              className="form-control"
              value={this.state.email}
              onChange={this.handleChange}
              required
            />
          </div>

          {/* Gender */}
          <div className="mb-2">
            <label>Gender</label>
            <div>
              <input
                type="radio"
                name="gender"
                value="Male"
                checked={this.state.gender === "Male"} //controlled input and if gender =male then male radio button is checked
                onChange={this.handleChange}
              />{" "}
              Male
              <input
                type="radio"
                name="gender"
                value="Female"
                checked={this.state.gender === "Female"} //controlled input and if gender =female then female button is checked
                onChange={this.handleChange}
                className="ms-3"
              />{" "}
              Female
            </div>
          </div>

          {/* Meal */}
          <div className="mb-2">
            <label>Meal Preference</label>
            <select
              name="meal"
              className="form-select"
              value={this.state.meal}
              onChange={this.handleChange}
            >
              <option value="Veg">Veg</option>
              <option value="Non-Veg">Non-Veg</option>
            </select>
          </div>

          {/* Special Request */}
          <div className="mb-2">
            <label>Special Request</label>
            <textarea
              name="request"
              className="form-control"
              value={this.state.request} //controlled input it will take input from react state
              onChange={this.handleChange}
            />
          </div>

          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>

        {/* Show data in table after submit */}
        {this.state.submittedData && (
          <table className="table table-bordered mt-3">
            <thead className="table-light">
              <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Gender</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{this.state.submittedData.passengerName}</td>
                <td>{this.state.submittedData.email}</td>
                <td>{this.state.submittedData.gender}</td>
              </tr>
            </tbody>
          </table>
        )}
      </div>
    );
  }
}
//above this.state.submitteddata we store all submitted form values. and picks out passenger name from obj
// Uncontrolled Form
class FlightBookingUncontrolled extends Component {
  constructor(props) {
    super(props);
    // refs to get values directly
    this.flightNumberRef = createRef(); //it makes a ref object
    this.sourceRef = createRef();
    this.destinationRef = createRef();
    this.dateRef = createRef();
    this.termsRef = createRef();
    //here in this state we store dynamic data
    this.state = { submittedData: null }; //here at 1st submitted data is null empty no form is submitted
  }

  handleSubmit = (e) => {
    //its always referes to class comp
    e.preventDefault(); //prevents from refresh
    this.setState({
      //its creating new obj and asigning properties
      submittedData: {
        flightNumber: this.flightNumberRef.current.value,
        source: this.sourceRef.current.value,
        destination: this.destinationRef.current.value,
        date: this.dateRef.current.value,
        terms: this.termsRef.current.checked,
      },
    });
  };

  render() {
    return (
      <div className="col-md-6">
        <h3>Uncontrolled Flight Booking Form</h3>

        {/* Uncontrolled Form */}
        <form onSubmit={this.handleSubmit}>
          <div className="mb-2">
            <label>Flight Number</label>
            <input
              type="text"
              ref={this.flightNumberRef}
              className="form-control"
              required
            />
          </div>

          <div className="mb-2">
            <label>Source</label>
            <input
              type="text"
              ref={this.sourceRef}
              className="form-control"
              required
            />
          </div>

          <div className="mb-2">
            <label>Destination</label>
            <input
              type="text"
              ref={this.destinationRef}
              className="form-control"
              required
            />
          </div>

          <div className="mb-2">
            <label>Travel Date</label>
            <input
              type="date"
              ref={this.dateRef}
              className="form-control"
              required
            />
          </div>

          <div className="mb-2">
            <input type="checkbox" ref={this.termsRef} /> Terms Accepted
          </div>

          <button type="submit" className="btn btn-success">
            Submit
          </button>
        </form>

        {/* Show data in card after submit */}
        {this.state.submittedData && (
          <div className="card p-3 mt-3">
            <h5>Flight Details</h5>
            <p>
              <b>Flight No:</b> {this.state.submittedData.flightNumber}
            </p>
            <p>
              <b>Source:</b> {this.state.submittedData.source}
            </p>
            <p>
              <b>Destination:</b> {this.state.submittedData.destination}
            </p>
            <p>
              <b>Date:</b> {this.state.submittedData.date}
            </p>
            <p>
              <b>Terms Accepted:</b>{" "}
              {this.state.submittedData.terms ? "Yes" : "No"}
            </p>
          </div>
        )}
      </div>
    );
  }
}
//here above the lines explains it reads values from the submitted form data stored in state and displays them on the ui
// export both forms
export { FlightBookingControlled, FlightBookingUncontrolled };
