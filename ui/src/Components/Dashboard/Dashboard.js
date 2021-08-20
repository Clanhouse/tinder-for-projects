import React, { useRef } from 'react'
import Profile from '../Profile/Profile'
import ConversationsList from '../ConversationsList/ConversationsList'
import './Dashboard.css'
import profilePicture from '../../Data/Images/profile.jpeg'
import ConnectionsList from '../ConnectionList/ConnectionsList'

const Dashboard = ({ setPopupMenuState, dashboardState }) => {
  const dashboard = useRef(null)
  const renderSwitch = (param) => {
    switch (param) {
      case 'connections':
        return showDashboard(
        <ConnectionsList setPopupMenuState={setPopupMenuState} />
        )
      case 'conversations':
        return showDashboard(
          <ConversationsList setPopupMenuState={setPopupMenuState} />
        )
      case 'profile':
        return showDashboard(<Profile />)
      case 'match':
        return hideDashboard()
      default:
        return 'ERROR'
    }
  }

  const hideDashboard = () => {
    dashboard.current.style.display = 'none'
  }

  const showDashboard = (component) => {
    if (dashboard.current) {
      dashboard.current.style.display = 'block'
    }
    return component
  }

  return (
    <div ref={dashboard} className="dashboard">
      {renderSwitch(dashboardState)}
    </div>
  )
}

export default Dashboard
