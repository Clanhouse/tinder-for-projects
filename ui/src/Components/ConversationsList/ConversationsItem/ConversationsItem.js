import React from 'react'
import menuIcon from '../../../Data/Images/menu-icon.svg'
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
      <div className="conversation__menu-btn">
        <img src={menuIcon} alt="" />
      </div>
    </li>
  )
}

export default ConversationsItem
