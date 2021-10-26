import React from 'react'
import './Phone.css'
import { ReactComponent as Chevron } from '../../../Data/Images/chevron_right_black_24dp.svg'

const Phone = (props) => {

  return (
      <div className="phone">
        Phone:
        <div className="phone__right" onClick={() => props.setIsPhone(true)}>
          {props.phone} <Chevron />
        </div>
      </div>
  )
}

export default Phone
