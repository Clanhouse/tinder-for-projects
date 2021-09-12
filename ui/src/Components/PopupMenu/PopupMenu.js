import React from 'react'
import './PopupMenu.css'

const Menu = ({ popupMenuState, dashboardState }) => {
  let style = {}
  if (popupMenuState.position) {
    style = {
      ...style,
      top: popupMenuState.position.top,
      left: popupMenuState.position.left,
      visibility: popupMenuState.visibility,
    }
  }
  return (
    <div className="menu" style={style}>
      <ul className="menu__list">
        <li className="menu__item">Mark as unread</li>
        <li className="menu__item">Show card</li>
        <li className="menu__item">Delete chat</li>
      </ul>
    </div>
  )
}

export default Menu
