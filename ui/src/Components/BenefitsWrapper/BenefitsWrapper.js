import React from "react";
import ListBenefits from '../Benefits/Benefits'
import './BenefitsWrapper.css'

const BenefitsWrapper = () => {
  return (
    <div className="BenefitsWrapper__div">
      <p>Benefits</p>
      <div className="ListBenefitsWrapper__div">
      {ListBenefits}
      </div>
    </div>
  );
};

export default BenefitsWrapper;
