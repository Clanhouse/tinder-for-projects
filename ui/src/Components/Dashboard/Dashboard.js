import React, { useState } from 'react'
import ConversationsList from '../ConversationsList/ConversationsList'
import './Dashboard.css'
import profilePicture from '../../Data/Images/profile.jpeg'

const Dashboard = () => {
  const [dashboardState, setdashboardState] = useState('connections')
  const renderSwitch = (param) => {
    switch (param) {
      case 'connections':
        return 'CONNECTIONS'
      case 'conversations':
        return <ConversationsList />
      case 'profile':
        return 'PROFILE'
      default:
        return 'ERROR'
    }
  }
  const handleMenuClick = (e) => {
    setdashboardState(e.target.id)
  }
  return (
    <aside className="dashboard">
      <div className="dashboard__menu">
        <div
          className="dashboard__profile-image"
          id="profile"
          onClick={handleMenuClick}
        >
          <img src={profilePicture} alt="" />
        </div>
        <ul className="dashboard__list">
          <li
            className={`dashboard__item ${
              dashboardState === 'connections' ? 'dashboard__item--active' : ''
            }`}
            id="connections"
            onClick={handleMenuClick}
          >
            Connections
          </li>
          <li
            className={`dashboard__item ${
              dashboardState === 'conversations'
                ? 'dashboard__item--active'
                : ''
            }`}
            id="conversations"
            onClick={handleMenuClick}
          >
            Conversations
          </li>
        </ul>
      </div>
      <div className="dashboard__dialog">{renderSwitch(dashboardState)}</div>
    </aside>
  )
}

export default Dashboard
