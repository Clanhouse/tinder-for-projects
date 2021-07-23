import React from "react";
import './Qualifications.css'

const qualifications = [
  "dummy data q1",
  "dummy data q2",
  "dummy data q3",
  "dummy data q4",
  "dummy data q5",
  "dummy data q6",
];
const ListQualifications = qualifications.map((data) => 
  <div className="ListQualifications__div">
    <p>{data}</p>
  </div>
)


export default ListQualifications;
