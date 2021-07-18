import React from 'react'

import './Button.css'

const Button = ({ children, size, ghost, fullWidth }) => {
  const style = `button ${size} ${ghost ? 'ghost' : ''} ${fullWidth ? 'full-width' : ''}`
  return <button className={style}>{children}</button>
}

export default Button
