import React, { useState } from 'react'
import Dashboard from '../Dashboard/Dashboard'
import UserWindowMenu from './UserWindowMenu/UserWindowMenu'
import { PopupProvider, PopupWrapper } from '../Popup/Popup'
import './UserWindow.css'

const UserWindow = ({ cardComponent }) => {
  const [dashboardState, setdashboardState] = useState('connections')
  const Card = cardComponent
  return (
    <PopupProvider>
      <PopupWrapper>
        <div className="user-window">
          <div className="user-window__aside">
            <UserWindowMenu
              dashboardState={dashboardState}
              setdashboardState={setdashboardState}
            />
            <Dashboard dashboardState={dashboardState} />
          </div>
          <div className="user-window__main">
            <Card />
          </div>
        </div>
      </PopupWrapper>
    </PopupProvider>
  )
}

export default UserWindow
