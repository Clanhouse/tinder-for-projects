import React from 'react'
import { PopupButton } from '../../Popup/Popup'
import { useActiveCard } from '../../../Contexts/ActiveCard'
import './ConnectionsItem.css'

const ConnectionsItem = ({ connection }) => {
  const { selectCard, activeCard } = useActiveCard()

  const handleConnectionClick = (e) => {
    const cardId = e.target.closest('.connection').id.replace('connection-', '')
    selectCard(cardId)
  }
  return (
    <li
      className={`connection ${
        connection.id === activeCard ? 'connection--active' : ''
      }`}
      id={`connection-${connection.id}`}
      onClick={handleConnectionClick}
    >
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
