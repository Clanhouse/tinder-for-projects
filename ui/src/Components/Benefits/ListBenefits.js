import React from "react";
import "./Benefits.css";

const benefits = [
  "dummy data 1",
  "dummy data 2",
  "dummy data 3",
  "dummy data 4",
];
const ListBenefits = () => {
  return (
    <>
      <h3 className="benefits__heading">Benefits</h3>
      <ul className="benefits__list">
        {benefits.map((benefit) => (
          <li className="benefits__item">{benefit}</li>
        ))}
      </ul>
    </>
  );
};

export default ListBenefits;
