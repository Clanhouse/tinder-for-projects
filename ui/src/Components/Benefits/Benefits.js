import React from "react";
import "./Benefits.css";

const benefits = [
  "dummy data 1",
  "dummy data 2",
  "dummy data 3",
  "dummy data 4",
];
const ListBenefits = benefits.map((data) => (
  <div className="ListBenefits__div">
    <p>{data}</p>
  </div>
));

export default ListBenefits;
