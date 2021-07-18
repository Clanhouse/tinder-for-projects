import React from 'react'
import './RadioGroup.css'

const RadioGroup = ({ name, options }) => {
  return (
    <div className="radio-group">
      {options.map((option) => (
        <label className="radio" key={option}>
          {option}
          <input type="radio" name={name} />
          <span className="radio__button"></span>
        </label>
      ))}
    </div>
  )
}

export default RadioGroup
