import React from "react";

function ServiceCard({ serviceName, price, fabricsAvailable }) {
  return (
    <div className="card shadow-sm h-100">
      <div className="card-body">
        <h5 className="card-title">{serviceName}</h5>
        <p className="card-text">
          <strong>Price:</strong> ${price}
        </p>
        <p className="card-text">
          <strong>Fabrics:</strong>
        </p>
        <ul>
          {fabricsAvailable.map((fabric, idx) => (
            <li key={idx}>{fabric}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default function TailorShop() {
  const tailoringServices = [
    {
      serviceName: "Shirt",
      price: 20,
      fabricsAvailable: ["Cotton", "Linen", "Polyester"],
    },
    {
      serviceName: "Pants",
      price: 30,
      fabricsAvailable: ["Denim", "Wool", "Chino"],
    },
    {
      serviceName: "Lehenga",
      price: 150,
      fabricsAvailable: ["Silk", "Georgette", "Chiffon"],
    },
    {
      serviceName: "Blouse",
      price: 40,
      fabricsAvailable: ["Cotton", "Silk", "Satin"],
    },
  ];

  return (
    <div className="container mt-5">
      <h1 className="text-center mb-4">Tailoring Services</h1>
      <div className="row">
        {tailoringServices.map((service, index) => (
          <div className="col-md-3 mb-4" key={index}>
            <ServiceCard
              serviceName={service.serviceName}
              price={service.price}
              fabricsAvailable={service.fabricsAvailable}
            />
          </div>
        ))}
      </div>
    </div>
  );
}
