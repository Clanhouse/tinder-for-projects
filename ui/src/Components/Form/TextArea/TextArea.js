import React from 'react'
import './TextArea.css'

const InputField = ({ name, label, value, onChange, size="normal" }) => {
  return (
    <label className={`input ${size}`}>
      <span className={`input__label ${size}`}>{label}</span>
      <textarea
        className={`input__field ${size}`}
        name={name}
        value={value}
        onChange={onChange}
        rows="5"
      ></textarea>
    </label>
  )
}

export default InputField
