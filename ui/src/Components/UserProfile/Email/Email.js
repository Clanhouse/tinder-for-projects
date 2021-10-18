import React from 'react'
import './Email.css'
import { ReactComponent as Chevron } from '../../../Data/Images/chevron_right_black_24dp.svg'

const Email = (props) => {
    
  return (
    <div className="email">
      Email:
      <div className="email__right" onClick={() => props.setIsEmail(true)}>
        {props.email} <Chevron />
      </div>
    </div>
  )
}

export default Email
