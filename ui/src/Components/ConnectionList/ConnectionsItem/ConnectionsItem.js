import React from 'react'
import menuIcon from '../../../Data/Images/menu-icon.svg'
import './ConnectionsItem.css'

const ConnectionsItem = ({ connection, setPopupMenuState }) => {
  
  const handleMenuBtnClick = (e) => {
    const { top, left } = e.target
      .closest('.connection__menu-btn')
      .getBoundingClientRect()
    setPopupMenuState({ position: { top, left }, visibility: 'visible' })
  }

  return (
    <div className="connection">
      <div className="connection__menu">
        <div className="connection__menu-btn" onClick={handleMenuBtnClick}>
          <img src={menuIcon} alt="" />
        </div>
      </div>

      <div className="connection__image">
        <img src={connection.picture} alt={connection.name} />
      </div>
      <div className="connection__name">
        <h3 className="connection__name--name">{connection.name}</h3>
      </div>
    </div>  
  )
}

export default ConnectionsItem
