import React from 'react'
import './Language.css'
import { ReactComponent as Chevron } from '../../../Data/Images/chevron_right_black_24dp.svg'
import { Link } from 'react-router-dom'

const Language = (props) => {
    
  return (
    <div className="language">
      Language:
      <Link to="/language">
      <div className="language__right" >
        {props.language} <Chevron />
      </div>
      </Link>
    </div>
  )
}

export default Language