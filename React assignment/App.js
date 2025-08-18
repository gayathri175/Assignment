// Import React
import React from "react";

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

// App component =entry point of our react project
function App() {
  // Data for juice items
  const juiceItems = [
    { id: 1, name: "Orange Juice", price: 50 },
    { id: 2, name: "Mango Juice", price: 60 },
    { id: 3, name: "Apple Juice", price: 70 },
  ];

  return (
    <div className="container">
      {/* Heading */}
      <h1 className="text-center my-4">My React Components Showcase</h1>

      {/* Grocery List */}
      <section className="mb-5">
        <GroceryList items={["Milk", "Bread", "Eggs", "Butter"]} />
      </section>

      {/* Car Component */}
      <section className="mb-5">
        <Car brand="Toyota" model="Corolla" color="Blue" year="2022" />
      </section>

      {/* Phone Component */}
      <section className="mb-5">
        <Phone brand="Apple" model="iPhone 14" price="90000" />
      </section>

      {/* Sweets List */}
      <section className="mb-5">
        <SweetsList sweets={["Laddu", "Jalebi", "Kaju Katli", "Rasgulla"]} />
      </section>

      {/* Electronics Component */}
      <section className="mb-5">
        <Electronics />
      </section>

      {/* Canteen Menu */}
      <section className="mb-5">
        <CanteenMenu />
      </section>

      {/* Juice Table */}
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

      {/* Restaurant Menu */}
      <section className="mb-5">
        <Restaurant />
      </section>

      {/* Temple List */}
      <section className="mb-5">
        <TempleList />
      </section>

      {/* Tailor Shop */}
      <section className="mb-5">
        <TailorShop />
      </section>

      {/* Fruits Component */}
      <section className="mb-5">
        <Fruits />
      </section>

      {/* Television Manager */}
      <section className="mb-5">
        <TelevisionManager />
      </section>

      {/* Marriage Form */}
      <section className="mb-5">
        <MarriageForm />
      </section>

      {/* Accessories Form (NEWLY ADDED) */}
      <section className="mb-5">
        <h2 className="text-center text-primary"></h2>
        <AccessoriesForm />
      </section>
    </div>
  );
}

// Export App so index.js can render it
export default App;