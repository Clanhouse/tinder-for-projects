import React from 'react'
import './DevProfileCardFeatures.css'
import { PopupMenu, PopupScrollHandler, PopupButton } from '../../../Popup/Popup'


const DevProfileCardFeatures = ({ name, features }) => {
  return (
    <PopupScrollHandler>
    <PopupMenu>
      <li className="popup-menu__item">Start chat</li>
      <li className="popup-menu__item">Delete contact</li>
    </PopupMenu>
    <div className="features">
      <h3 className="features__heading">{name}</h3>
      <ul className="features__list">
        {features.map((feature) => (
          <li key={feature} className="features__item">
            {feature}
          </li>
        ))}
        <li className="features__item" onClick={() => console.log("Kliknięto")}>+</li>
      </ul>
    </div>
    </PopupScrollHandler>
  )
}

export default DevProfileCardFeatures
