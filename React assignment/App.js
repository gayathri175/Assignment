// Root component of our React project
import React, { Component } from "react";
// Import all components
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

//  Import MovieForm component
import MovieForm from "./MovieForm";

class App extends Component {
  render() {
    // Data for juice items
    const juiceItems = [
      { id: 1, name: "Orange Juice", price: 50 },
      { id: 2, name: "Mango Juice", price: 60 },
      { id: 3, name: "Apple Juice", price: 70 },
    ];

    return (
      <div className="container">
        <h1 className="text-center my-4">My React Components Showcase</h1>

        {/* Grocery List */}
        <section className="mb-5">
          <GroceryList items={["Milk", "Bread", "Eggs", "Butter"]} />
        </section>

        {/* Car */}
        <section className="mb-5">
          <Car brand="Toyota" model="Corolla" color="Blue" year="2022" />
        </section>

        {/* Phone */}
        <section className="mb-5">
          <Phone brand="Apple" model="iPhone 14" price="90000" />
        </section>

        {/* Sweets */}
        <section className="mb-5">
          <SweetsList sweets={["Laddu", "Jalebi", "Kaju Katli", "Rasgulla"]} />
        </section>

        {/* Electronics */}
        <section className="mb-5">
          <Electronics />
        </section>

        {/* Canteen */}
        <section className="mb-5">
          <CanteenMenu />
        </section>

        {/* Juice */}
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

        {/* Restaurant */}
        <section className="mb-5">
          <Restaurant />
        </section>

        {/* Temple */}
        <section className="mb-5">
          <TempleList />
        </section>

        {/* Tailor */}
        <section className="mb-5">
          <TailorShop />
        </section>

        {/* Fruits */}
        <section className="mb-5">
          <Fruits />
        </section>

        {/* TV */}
        <section className="mb-5">
          <TelevisionManager />
        </section>

        {/* Marriage Form */}
        <section className="mb-5">
          <MarriageForm />
        </section>

        {/* Accessories Form */}
        <section className="mb-5">
          <AccessoriesForm />
        </section>

        {/* Baking Items Form */}
        <section className="mb-5">
          <BakingItemsForm />
        </section>

        {/* Flight Booking Controlled & Uncontrolled Forms */}
        <section className="mb-5 row">
          <div className="col-md-6">
            {/* Controlled Form */}
            <FlightBookingControlled />
          </div>
          <div className="col-md-6">
            {/* Uncontrolled Form */}
            <FlightBookingUncontrolled />
          </div>
        </section>

        {/*  Movie Form Section */}
        <section className="mb-5">
          <h2 className="mb-4"> Movie Collection Form</h2>
          <MovieForm />
        </section>
      </div>
    );
  }
}

export default App;
