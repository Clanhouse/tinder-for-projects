import React from "react";
import ListQualifications from "../Qualifications/Qualifications";
import './QualificationsWrapper.css'

const QualificationsWrapper = () => {
  return (
    <div className="QualificationsWrapper__div">
      <p>Qualifications</p>
      <div className="ListQualificationsWrapper__div">{ListQualifications}</div>
    </div>
  );
};

export default QualificationsWrapper;
