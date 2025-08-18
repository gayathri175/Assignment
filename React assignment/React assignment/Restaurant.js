import React, { Component } from "react";

class MenuItem extends Component {
  render() {
    const { name, price, category, available } = this.props;
    return (
      <li>
        {name} – ₹ {price} ({category}),{" "}
        {available === "Yes" ? "Available" : "Not Available"}
      </li>
    );
  }
}

class Restaurant extends Component {
  render() {
    return (
      <div>
        <h2>Restaurant Name: Spice Hub</h2>
        <p>Location: Block B, First Floor</p>
        <p>Open Hours: 10:00 AM - 10:00 PM</p>

        <h3>Restaurant Menu:</h3>
        <ul>
          <MenuItem
            name="Paneer Butter Masala"
            price={150}
            category="Main Course"
            available="Yes"
          />
          <MenuItem
            name="Chicken Biryani"
            price={200}
            category="Main Course"
            available="Yes"
          />
          <MenuItem
            name="Masala Dosa"
            price={80}
            category="Breakfast"
            available="Yes"
          />
          <MenuItem
            name="Gulab Jamun"
            price={40}
            category="Dessert"
            available="No"
          />
          <MenuItem
            name="Veg Thali"
            price={120}
            category="Combo"
            available="Yes"
          />
        </ul>
      </div>
    );
  }
}

export default Restaurant;
