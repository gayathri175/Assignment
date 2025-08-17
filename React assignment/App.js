import React, { Component } from "react";
import Phone from "./Phone";
import SweetsList from "./SweetsList";
import Electronics from "./Electronics";
import CanteenMenu from "./CanteenMenu";
import Juice from "./Juice";
import Restaurant from "./Restaurant";
import TempleList from "./TempleList";
import TailorShop from "./TailorShop";

class Car extends Component {
  render() {
    const { brand, model, color, year } = this.props;
    return (
      <div>
        <h2>Car Details:</h2>
        <p>Brand: {brand}</p>
        <p>Model: {model}</p>
        <p>Color: {color}</p>
        <p>Year: {year}</p>
      </div>
    );
  }
}

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

export default function App() {
  const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];
  const juices = [
    { id: 1, name: "Orange Juice", price: 80 },
    { id: 2, name: "Apple Juice", price: 100 },
    { id: 3, name: "Mango Juice", price: 120 },
  ];

  return (
    <div>
      <GroceryList items={groceries} />
      <hr />
      <Car brand="Toyota" model="Fortuner" color="Black" year="2022" />
      <hr />
      <Phone />
      <hr />
      <SweetsList />
      <hr />
      <Electronics />
      <hr />
      <CanteenMenu />
      <hr />
      <h2>Juice Menu</h2>
      <table border="1" cellPadding="10" cellSpacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {juices.map((juice) => (
            <Juice key={juice.id} {...juice} />
          ))}
        </tbody>
      </table>
      <hr />
      <Restaurant />
      <hr />
      <TempleList />
      <hr />
      <TailorShop />
    </div>
  );
}
