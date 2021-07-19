import React from 'react'

import './Button.css'

const Button = ({ children, size, ghost, fullWidth, onClick }) => {
  const style = `button ${size} ${ghost ? 'ghost' : ''} ${
    fullWidth ? 'full-width' : ''
  }`
  return (
    <button className={style} onClick={onClick}>
      {children}
    </button>
  )
}

export default Button
