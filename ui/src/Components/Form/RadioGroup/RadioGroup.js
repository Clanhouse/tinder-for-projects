import React from 'react'
import './RadioGroup.css'

const RadioGroup = ({ name, options, onChange }) => {
  return (
    <div className="radio-group">
      {options.map((option) => (
        <label className="radio" key={option.value}>
          {option.name}
          <input
            type="radio"
            name={name}
            value={option.value}
            onChange={onChange}
          />
          <span className="radio__button"></span>
        </label>
      ))}
    </div>
  )
}

export default RadioGroup
