import React from 'react'

import './Button.css'

const Button = ({ children, size, ghost }) => {
  const style = `button ${size} ${ghost ? 'ghost' : ''}`
  return <button className={style}>{children}</button>
}

export default Button
