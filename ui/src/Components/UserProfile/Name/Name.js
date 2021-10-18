import React, { useContext } from 'react'
import './Name.css'
import { ReactComponent as Chevron } from '../../../Data/Images/chevron_right_black_24dp.svg'

const Name = (props) => {

  return (
    <div className="name">
      Name:
      <div className="name__right" onClick={() => props.setIsName(true)}>
        {props.name} <Chevron />
      </div>
    </div>
  )
}

export default Name
