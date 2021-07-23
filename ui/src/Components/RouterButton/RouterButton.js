import React from 'react'
import { useHistory } from 'react-router'
import Button from '../Button/Button'

const RouterButton = ({ children, size, ghost, fullWidth, to }) => {
  let history = useHistory()

  const handleClick = () => {
    history.push(to)
  }

  return (
    <Button
      size={size}
      ghost={ghost}
      fullWidth={fullWidth}
      onClick={handleClick}
    >
      {children}
    </Button>
  )
}

export default RouterButton
