import React from 'react'
import menuIcon from '../../../Data/Images/menu-icon.svg'
import './ConversationsItem.css'

const ConversationsItem = ({ conversation, setPopupMenuState }) => {
  
  const handleMenuBtnClick = (e) => {
    const { top, left } = e.target
      .closest('.conversation__menu-btn')
      .getBoundingClientRect()
    console.log(left)
    setPopupMenuState({ position: { top, left }, visibility: 'visible' })
  }

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
        <div className="conversation__menu-btn" onClick={handleMenuBtnClick}>
          <img src={menuIcon} alt="" />
        </div>
      </div>
    </li>
  )
}

export default ConversationsItem
