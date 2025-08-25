import React, { Component, useState } from "react";

import GroceryList from "./GroceryList";
import Car from "./Car";
import Phone from "./Phone";
import SweetsList from "./SweetsList";
import Electronics from "./Electronics";
import CanteenMenu from "./CanteenMenu";
import Juice from "./Juice";
import Restaurant from "./Restaurant";
import TempleList from "./TempleList";
import TailorShop from "./TailorShop";
import Fruits from "./Fruits";
import TelevisionManager from "./Television";
import MarriageForm from "./MarriageForm";
import AccessoriesForm from "./AccessoriesForm";
import BakingItemsForm from "./Baking";
import {
  FlightBookingControlled,
  FlightBookingUncontrolled,
} from "./FlightBooking";
import MovieForm from "./MovieForm";
import ConditionalApp from "./ConditionalApp";

import { renderFurniture, furnitureData } from "./FurnitureComponents";

// Import FestivalApp
import FestivalApp from "./FestivalApp";

// Import RestaurantForm
import RestaurantForm from "./RestaurantForm";

// Import FruitComponents (NEW)
import FruitComponents from "./FruitComponents";

// Import HockeyForm (NEW)
import HockeyForm from "./HockeyForm";

//  Functional component for Furniture Store
const FurnitureStore = () => {
  const [selectedFurniture, setSelectedFurniture] = useState("Chair");

  const handleChange = (event) => {
    setSelectedFurniture(event.target.value);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Furniture Store</h2>
      <select value={selectedFurniture} onChange={handleChange}>
        <option value="Chair">Chair</option>
        <option value="Table">Table</option>
        <option value="Sofa">Sofa</option>
        <option value="Bed">Bed</option>
      </select>

      <div style={{ marginTop: "20px" }}>
        {renderFurniture(selectedFurniture, furnitureData[selectedFurniture])}
      </div>
    </div>
  );
};

//  Main Parent component (Class based)
class Parent extends Component {
  render() {
    const juiceItems = [
      { id: 1, name: "Orange Juice", price: 50 },
      { id: 2, name: "Mango Juice", price: 60 },
      { id: 3, name: "Apple Juice", price: 70 },
    ];

    return (
      <div className="container">
        {/*  Hockey Tournament Form at the Top */}
        <section className="mb-5">
          <h1 className="text-center text-primary mt-4">
            Hockey Tournament Registration
          </h1>
          <HockeyForm />
        </section>

        <h1 className="text-center my-4">My React Components Showcase</h1>

        {/* Grocery List Example */}
        <section className="mb-5">
          <GroceryList items={["Milk", "Bread", "Eggs", "Butter"]} />
        </section>

        {/* Car Example */}
        <section className="mb-5">
          <Car brand="Toyota" model="Corolla" color="Blue" year="2022" />
        </section>

        {/* Phone Example */}
        <section className="mb-5">
          <Phone brand="Apple" model="iPhone 14" price="90000" />
        </section>

        {/* Sweets Example */}
        <section className="mb-5">
          <SweetsList sweets={["Laddu", "Jalebi", "Kaju Katli", "Rasgulla"]} />
        </section>

        {/* Electronics Example */}
        <section className="mb-5">
          <Electronics />
        </section>

        {/* Canteen Example */}
        <section className="mb-5">
          <CanteenMenu />
        </section>

        {/* Juice Example */}
        <section className="mb-5">
          <h2>Juice Menu</h2>
          <table className="table table-bordered table-striped">
            <thead className="table-primary">
              <tr>
                <th>ID</th>
                <th>Juice Name</th>
                <th>Price</th>
              </tr>
            </thead>
            <tbody>
              {juiceItems.map((juice) => (
                <Juice
                  key={juice.id}
                  id={juice.id}
                  name={juice.name}
                  price={juice.price}
                />
              ))}
            </tbody>
          </table>
        </section>

        {/* Restaurant Example */}
        <section className="mb-5">
          <Restaurant />
        </section>

        {/* Temple Example */}
        <section className="mb-5">
          <TempleList />
        </section>

        {/* Tailor Example */}
        <section className="mb-5">
          <TailorShop />
        </section>

        {/* Fruits Example */}
        <section className="mb-5">
          <Fruits />
        </section>

        {/* Television Example */}
        <section className="mb-5">
          <TelevisionManager />
        </section>

        {/* Marriage Form Example */}
        <section className="mb-5">
          <MarriageForm />
        </section>

        {/* Accessories Form Example */}
        <section className="mb-5">
          <AccessoriesForm />
        </section>

        {/* Baking Form Example */}
        <section className="mb-5">
          <BakingItemsForm />
        </section>

        {/* Flight Booking Controlled & Uncontrolled Example */}
        <section className="mb-5 row">
          <div className="col-md-6">
            <FlightBookingControlled />
          </div>
          <div className="col-md-6">
            <FlightBookingUncontrolled />
          </div>
        </section>

        {/* Movie Form Example */}
        <section className="mb-5">
          <h2 className="mb-4">Movie Collection Form</h2>
          <MovieForm />
        </section>

        {/* Conditional Rendering Example */}
        <section className="mb-5">
          <ConditionalApp />
        </section>

        {/* Furniture Store Example */}
        <section className="mb-5">
          <FurnitureStore />
        </section>

        {/* Festival App Example */}
        <section className="mb-5">
          <FestivalApp />
        </section>

        {/* Restaurant Form Example */}
        <section className="mb-5">
          <h2>Restaurant Form</h2>
          <RestaurantForm />
        </section>

        {/*  FruitComponents Example */}
        <section className="mb-5">
          <h2>React – Parent / Child / Sibling Communication</h2>
          <FruitComponents />
        </section>
      </div>
    );
  }
}

// App component (this just returns Parent)
export default function App() {
  return <Parent />;
}
