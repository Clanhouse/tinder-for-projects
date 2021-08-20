import React from 'react'

import './Button.css'

const Button = ({
  children,
  size,
  ghost,
  mobile,
  fullWidth,
  style,
  onClick,
}) => {
  const classes = `button ${size} ${ghost ? 'ghost' : ''} ${
    mobile ? 'mobile' : ''
  } ${fullWidth ? 'full-width' : ''}`
  return (
    <button className={classes} style={style} onClick={onClick}>
      {children}
    </button>
  )
}

export default Button
