import React from 'react'
import './CheckboxField.css'

const CheckboxField = ({ name, label }) => {
  return (
    <div className="checkbox-group">
      <label className="checkbox">
        <span className="checkbox__label">{label}</span>
        <input type="checkbox" name={name} />
        <span className="checkbox__button"></span>
      </label>
    </div>
  )
}

export default CheckboxField
