import React, { useState, createContext, useContext } from 'react'
import menuIcon from '../../Data/Images/menu-icon.svg'
import './Popup.css'

const popupContext = createContext()

export const PopupProvider = ({ children }) => {
  const [popupMenuState, setPopupMenuState] = useState({})
  const val = { popupMenuState, setPopupMenuState }
  return <popupContext.Provider value={val}>{children}</popupContext.Provider>
}

export const PopupWrapper = ({ children }) => {
  const { setPopupMenuState } = useContext(popupContext)
  const closePopupMenu = (e) => {
    if (!e.target.closest('.popup-menu-btn')) {
      setPopupMenuState({ visibility: 'hidden' })
    }
  }
  return (
    <div className="popup-wrapper" onClick={closePopupMenu}>
      {children}
    </div>
  )
}

export const PopupMenu = ({ children }) => {
  const { popupMenuState } = useContext(popupContext)
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
    <div className="popup-menu" style={style}>
      <ul className="popup-menu__list">
        <li className="popup-menu__item">Mark as unread</li>
        <li className="popup-menu__item">Show card</li>
        <li className="popup-menu__item">Delete chat</li>
        {children}
      </ul>
    </div>
  )
}

export const PopupButton = () => {
  const { setPopupMenuState } = useContext(popupContext)
  const handleMenuBtnClick = (e) => {
    const { top, left } = e.target
      .closest('.popup-menu-btn')
      .getBoundingClientRect()
    setPopupMenuState({ position: { top, left }, visibility: 'visible' })
  }
  return (
    <div className="popup-menu-btn" onClick={handleMenuBtnClick}>
      <img src={menuIcon} alt="" />
    </div>
  )
}
