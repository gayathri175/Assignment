import React, { Component } from "react";
// Functional Component (Child)
// here in this component only receives fruits as props and shows them in a list
function FruitList({ fruits }) {
  return (
    <div>
      <h3>Fruit List</h3>
      <ul>
        {fruits.map((fruit, index) => (
          // here each fruit is displayed as a list item
          <li key={index}>{fruit}</li>
        ))}
      </ul>
    </div>
  );
}
// Class Component (Parent)
// here this below component manages state and input
class Fruits extends Component {
  constructor(props) {
    super(props);

    //stores data inside the class component=this.state
    this.state = {
      fruits: ["Apple", "Banana", "Orange"], // we have given initial fruits
      newFruit: "", // input box value so that we can give
    };
  }

  //  here we are using function to handle typing in the input box
  handleChange = (event) => {
    this.setState({ newFruit: event.target.value });
  };
  //this.setstate=updates the state
  // Function to add a new fruit when button is clicked
  addFruit = () => {
    const { newFruit, fruits } = this.state;  //destructuring

    if (newFruit.trim() !== "") {
      // Add the new fruit into the fruits array and trim means removes extra spacees from input
      this.setState({
        fruits: [...fruits, newFruit], //here we are using spread means merge
        newFruit: "", //here  clear the input after adding
      });
    }
  };
  //below we use rendor it menas it tells to react wt to show on ui
  render() {
    return (
      <div>
        <h2>Fruits</h2>

        {/* Input box for entering fruit name */}
        <input
          type="text"
          value={this.state.newFruit}
          onChange={this.handleChange}
        />

        {/*  we use button to add fruit */}
        <button onClick={this.addFruit}>Add</button>

        {/*  we pass fruits array as props to FruitList */}
        <FruitList fruits={this.state.fruits} />
      </div>
    );
  }
}

// Export Fruits coz app.js can use it like there we can write import
export default Fruits;
