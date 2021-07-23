import React from 'react'
import './InputField.css'

const InputField = ({ name, label, type, value, onChange }) => {
  return (
    <label className="input">
      <span className="input__label">{label}</span>
      <input
        className="input__field"
        type={type}
        name={name}
        value={value}
        onChange={onChange}
      />
    </label>
  )
}

export default InputField
