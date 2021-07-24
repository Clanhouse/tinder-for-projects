import React from "react";
import ListBenefits from "../Benefits/ListBenefits";
import ProjectData from "../ProjectData/ProjectData";
import ListQualifications from "../Qualifications/ListQualifications";
import "./DeveloperCard.css";

//dummy function
function handleClick() {
  console.log("Kliknięto");
}

const DeveloperCard = () => {
  return (
    <div className="developerCard">
      <ProjectData />
      <ListQualifications />
      <ListBenefits />
      <button className="thumbUp" onClick={handleClick}></button>
      <button className="thumbDown" onClick={handleClick}></button>
    </div>
  );
};

export default DeveloperCard;
