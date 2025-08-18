import React, { Component } from "react";
// Functional Component (Child)
// This component only receives the television models as props
// and displays them inside a list
function TelevisionList({ models }) {
  return (
    <div>
      <h3>Television Models</h3>
      <ul>
        {/* Loop through models array and display each model */}
        {models.map((model, index) => (
          <li key={index}>{model}</li> //we use key to identify items
        ))}
      </ul>
    </div>
  );
}
// Class Component (Parent)
// This component manages the state and allows adding new TV models
class TelevisionManager extends Component {
  constructor(props) {
    super(props);
    //above super()calls the constructor of the parent class that is component
    //before this.props only we should use super(props) becoz it wont wrk if we use aftrthat
    //by passing props into super(props), we can ensure that this.props is correctly set up inside your class
    // Initial state and this.state is used to store the models
    this.state = {
      models: ["Samsung QLED", "Sony Bravia", "LG OLED"], // initial television models
      newModel: "", // it is the input field value
    };
  }

  // Function to update state when user types in input box
  handleChange = (event) => {
    this.setState({ newModel: event.target.value }); //we are updating
  };

  // Function to add new television model and we use arrow fun to automatically bind
  //this fun is called when we want to add a new model
  addModel = () => {
    const { newModel, models } = this.state;
    // we know already here it is object destructering
    //we use trim to remove spaces before and ending of string
    if (newModel.trim() !== "") {
      // Used spread operator (...) to add new model into array
      this.setState({
        models: [...models, newModel],
        newModel: "", // clear input after adding
      });
    }
  };

  render() {
    return (
      <div>
        <h2>Television Manager</h2>

        {/* Input box to type new model */}
        <input
          type="text"
          value={this.state.newModel}
          //controlled input the text shown inside the input box always comes from the React component’s state
          onChange={this.handleChange}
        />

        {/* Button to add model */}
        <button onClick={this.addModel}>Add</button>

        {/* Pass models array as props to TelevisionList */}
        <TelevisionList models={this.state.models} />
      </div>
    );
  }
}

//here we export Class Component
export default TelevisionManager;
