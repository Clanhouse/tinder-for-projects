import React from 'react'
import { PopupButton } from '../../Popup/Popup'
import './ConnectionsItem.css'

const ConnectionsItem = ({ connection }) => {
  return (
    <li className="connection">
      <div className="connection__image">
        <img src={connection.picture} alt={connection.name} />
      </div>
      <div className="connection__name">
        <h3 className="connection__name--name">{connection.name}</h3>
      </div>
      <div className="connection__menu">
        <PopupButton />
      </div>
    </li>
  )
}

export default ConnectionsItem
