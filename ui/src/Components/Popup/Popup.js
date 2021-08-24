import React, {
  useState,
  createContext,
  useContext,
  useEffect,
  useRef,
} from 'react'
import menuIcon from '../../Data/Images/menu-icon.svg'
import './Popup.css'

export const popupContext = createContext()

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

export const PopupScrollHandler = ({ children }) => {
  const [scrollPosition, setScrollPosition] = useState(null)
  const list = useRef(null)
  const { popupMenuState, setPopupMenuState } = useContext(popupContext)
  useEffect(() => {
    const listRef = list.current
    listRef.addEventListener('scroll', updateMenuPosition)
    return () => {
      listRef.removeEventListener('scroll', updateMenuPosition)
    }
  })

  const updateMenuPosition = () => {
    if (popupMenuState.position) {
      setPopupMenuState({
        position: {
          top:
            popupMenuState.position.top -
            list.current.scrollTop +
            scrollPosition,
          left: popupMenuState.position.left,
        },
        visibility: 'visible',
      })
      setScrollPosition(list.current.scrollTop)
    }
  }

  return (
    <div className="popup-scroll-handler" ref={list}>
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
      <ul className="popup-menu__list">{children}</ul>
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
