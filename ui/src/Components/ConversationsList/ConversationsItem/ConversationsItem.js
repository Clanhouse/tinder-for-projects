import React from 'react'
import { PopupButton } from '../../Popup/Popup'
import './ConversationsItem.css'

const ConversationsItem = ({ conversation }) => {
  return (
    <li className="conversation">
      <div className="conversation__image">
        <img src={conversation.picture} alt={conversation.name} />
      </div>
      <div className="conversation__body">
        <h3 className="conversation__name">{conversation.name}</h3>
        <p className="conversation__message">{`${conversation.message.slice(
          0,
          25
        )}...`}</p>
      </div>
      <div className="conversation__menu">
        <PopupButton />
      </div>
    </li>
  )
}

export default ConversationsItem
