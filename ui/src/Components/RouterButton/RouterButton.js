import React from 'react'
import { useHistory } from 'react-router'
import Button from '../Button/Button'

const RouterButton = ({
  children,
  size,
  ghost,
  mobile,
  fullWidth,
  to,
  style,
}) => {
  let history = useHistory()

  const handleClick = () => {
    history.push(to)
  }

  return (
    <Button
      size={size}
      ghost={ghost}
      mobile={mobile}
      fullWidth={fullWidth}
      style={style}
      onClick={handleClick}
    >
      {children}
    </Button>
  )
}

export default RouterButton
