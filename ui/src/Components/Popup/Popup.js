import React, {
  useState,
  createContext,
  useContext,
  useEffect,
  useRef,
  useCallback,
} from 'react'
import menuIcon from '../../Data/Images/menu-icon.svg'
import './Popup.css'

export const popupContext = createContext()

export const PopupProvider = ({ children }) => {
  const [popupMenuState, setPopupMenuState] = useState({})
  const updatePopupMenuState = useCallback((stateChanges) => {
    setPopupMenuState((prevPopupMenuState) => {
      return { ...prevPopupMenuState, ...stateChanges }
    })
  }, [])
  const getPopupMenuStyle = () => {
    if (popupMenuState.isDisplayed) {
      return {
        top: popupMenuState.top,
        left: popupMenuState.left,
        transform: `translate(${
          popupMenuState.left + popupMenuState.width > window.innerWidth
            ? 'calc(-100% + 40px)'
            : '0'
        }, ${
          popupMenuState.top + popupMenuState.height >
          popupMenuState.limitBottom
            ? 'calc(-100% + 40px)'
            : '0'
        })`,
      }
    }
    return null
  }

  const value = {
    popupMenuState,
    updatePopupMenuState,
    getPopupMenuStyle,
  }
  return <popupContext.Provider value={value}>{children}</popupContext.Provider>
}

export const PopupWrapper = ({ children }) => {
  const { updatePopupMenuState } = useContext(popupContext)
  const closePopupMenu = (e) => {
    if (!e.target.closest('.popup-menu-btn')) {
      updatePopupMenuState({ isDisplayed: false })
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
  const containerRef = useRef()
  const { popupMenuState, updatePopupMenuState } = useContext(popupContext)

  useEffect(() => {
    updatePopupMenuState({
      limitBottom:
        containerRef.current.offsetHeight +
        containerRef.current.getBoundingClientRect().top,
      limitTop: containerRef.current.getBoundingClientRect().top,
    })
  }, [updatePopupMenuState])

  const handleScrollEvent = () => {
    if (popupMenuState.isDisplayed) {
      updatePopupMenuState({
        top:
          popupMenuState.top - containerRef.current.scrollTop + scrollPosition,
        isDisplayed:
          popupMenuState.top + 40 < popupMenuState.limitBottom &&
          popupMenuState.top > popupMenuState.limitTop,
      })
    }
    setScrollPosition(containerRef.current.scrollTop)
  }

  return (
    <div
      className="popup-scroll-handler"
      ref={containerRef}
      onScroll={handleScrollEvent}
    >
      {children}
    </div>
  )
}

export const PopupMenu = ({ children }) => {
  const popupMenuRef = useRef()
  const { updatePopupMenuState, getPopupMenuStyle, popupMenuState } =
    useContext(popupContext)
  useEffect(() => {
    if (popupMenuRef.current) {
      updatePopupMenuState({
        width: popupMenuRef.current.offsetWidth,
        height: popupMenuRef.current.offsetHeight,
      })
    }
  }, [updatePopupMenuState, popupMenuState.isDisplayed])
  let style = getPopupMenuStyle()
  return popupMenuState.isDisplayed ? (
    <div className="popup-menu" style={style} ref={popupMenuRef}>
      <ul className="popup-menu__list">{children}</ul>
    </div>
  ) : null
}

export const PopupButton = () => {
  const { updatePopupMenuState } = useContext(popupContext)
  const handleMenuBtnClick = (e) => {
    const { top, left } = e.target
      .closest('.popup-menu-btn')
      .getBoundingClientRect()
    updatePopupMenuState({
      top,
      left,
      isDisplayed: true,
    })
  }
  return (
    <div className="popup-menu-btn" onClick={handleMenuBtnClick}>
      <img src={menuIcon} alt="" />
    </div>
  )
}
