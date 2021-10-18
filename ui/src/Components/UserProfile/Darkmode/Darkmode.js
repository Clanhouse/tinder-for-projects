import React from 'react'
import { ReactComponent as SwitchButton } from '../../../Data/Images/switch-button.svg'

const Darkmode = () => {
  return (
    <div className="profile--item">
      Dark-mode
      <div className="profile--item--right">
        <SwitchButton />
      </div>
    </div>
  )
}

export default Darkmode