import React from 'react'
import profilePicture from '../../../Data/Images/profile.jpeg'
import { ReactComponent as MatchIcon } from '../../../Data/Images/handshake-solid.svg'
import { ReactComponent as ConnectionsIcon } from '../../../Data/Images/network-wired-solid.svg'
import { ReactComponent as MessagesIcon } from '../../../Data/Images/comments-solid.svg'
import { ReactComponent as ProfileIcon } from '../../../Data/Images/user-solid.svg'
import './UserWindowMenu.css'

const UserWindowMenu = ({ dashboardState, setdashboardState, setUserEditMode }) => {
  const handleMenuClick = (e) => {
    setdashboardState(e.target.closest('.user-window-menu__item').id)
    if (e.target.closest('.user-window-menu__item').id === 'profile') {
      setUserEditMode(true)
    } else {
      setUserEditMode(false)
    }
  }

  return (
    <ul className="user-window-menu">
      <li
        className={`user-window-menu__item ${
          dashboardState === 'match' ? 'user-window-menu__item--active' : ''
        }`}
        id="match"
        onClick={handleMenuClick}
      >
        <span className="user-window-menu__icon">
          <MatchIcon />
        </span>
      </li>
      <li
        className={`user-window-menu__item ${
          dashboardState === 'profile' ? 'user-window-menu__item--active' : ''
        }`}
        id="profile"
        onClick={handleMenuClick}
      >
        <div className="user-window-menu__profile-image user-window-menu__text">
          <img src={profilePicture} alt="" />
        </div>
        <span className="user-window-menu__icon">
          <ProfileIcon />
        </span>
      </li>
      <li
        className={`user-window-menu__item ${
          dashboardState === 'connections' ? 'user-window-menu__item--active' : ''
        }`}
        id="connections"
        onClick={handleMenuClick}
      >
        <span className="user-window-menu__text">Connections</span>
        <span className="user-window-menu__icon">
          <ConnectionsIcon />
        </span>
      </li>
      <li
        className={`user-window-menu__item ${
          dashboardState === 'conversations'
            ? 'user-window-menu__item--active'
            : ''
        }`}
        id="conversations"
        onClick={handleMenuClick}
      >
        <span className="user-window-menu__text">Conversations</span>
        <span className="user-window-menu__icon">
          <MessagesIcon />
        </span>
      </li>
    </ul>
  )
}

export default UserWindowMenu
