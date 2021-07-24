import React from "react";
import "./Qualifications.css";

const qualifications = [
  "dummy data q1",
  "dummy data q2",
  "dummy data q3",
  "dummy data q4",
  "dummy data q5",
  "dummy data q6",
];
const ListQualifications = () => {
  return (
    <div className="listQualifications">
          <h3 className="qualifications__heading">Qualifications</h3>
    <ul className="qualifications__list">
      {qualifications.map((qualification) => (
        <li className="qualifications__item">{qualification}</li>
      ))}
    </ul>
    </div>
  );
};

export default ListQualifications;
