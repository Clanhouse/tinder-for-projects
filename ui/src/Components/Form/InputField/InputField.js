import React from 'react'
import './InputField.css'

const InputField = ({ name, label, type, value, onChange, size="normal" }) => {
  return (
    <label className={`input ${size}`}>
      <span className={`input__label ${size}`}>{label}</span>
      <input
        className={`input__field ${size}`} 
        type={type}
        name={name}
        value={value}
        onChange={onChange}
      />
    </label>
  )
}

export default InputField
