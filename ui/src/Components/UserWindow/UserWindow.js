import React, { useState, useEffect } from 'react'
import Dashboard from '../Dashboard/Dashboard'
import Card from '../Card/Card'
import UserWindowMenu from './UserWindowMenu/UserWindowMenu'
import PopupMenu from '../PopupMenu/PopupMenu'
import './UserWindow.css'

const card1 = {
  image: 'http://shezannj.com/wp-content/uploads/2019/01/dummy-logo-png-7.png',
  name: 'Trauma APP',
  subtitle: 'Trauma Team International',
  description:
    "We are looking for an experienced full-stack web developer, who helps us improve our Trauma App. New functionalities will allow Trauma paramedics to respond even faster to our client's every sudden emergency.",
  features: [
    {
      name: 'qualifications',
      values: [
        'React.js',
        'Node.js',
        'Express',
        'Mongo DB',
        'Mongoose',
        '4+ Years of Experience',
      ],
    },
    {
      name: 'benefits',
      values: ['Fully Remote', 'Flat Structure', 'Competetive Salary'],
    },
  ],
}

const card2 = {
  image:
    'https://s.ciekawostkihistoryczne.pl/uploads/2019/03/Albert_Einstein_Head.jpg',
  name: 'Albert Einstein',
  subtitle: 'Aspiring full-stack developer',
  description:
    'I know nothing about web development. I have developed the theory of relativity, though, so developing minor web apps won’t be a problem for me!',
  features: [
    {
      name: 'Skills',
      values: ['Physics', 'Philosophy', 'Quantum Theory', 'Mathematics'],
    },
    {
      name: 'Achievments',
      values: ['E=mc2', 'Nobel Prize in Physics', 'Proper Genius'],
    },
  ],
}

const UserWindow = ({ role }) => {
  const [card, setCard] = useState(null)
  useEffect(() => {
    if (role === 'developer') {
      setCard(card1)
    } else if (role === 'project') {
      setCard(card2)
    }
  }, [role])

  const [popupMenuState, setPopupMenuState] = useState({})
  const [dashboardState, setdashboardState] = useState('connections')

  const closePopupMenu = (e) => {
    if (!e.target.closest('.conversation__menu-btn') && !e.target.closest('.connection__menu-btn')) {
      setPopupMenuState({ visibility: 'hidden' })
    }
  }

  return (
    <div className="user-window" onClick={closePopupMenu}>
      <div className="user-window__aside">
        <UserWindowMenu
          dashboardState={dashboardState}
          setdashboardState={setdashboardState}
        />
        <Dashboard
          setPopupMenuState={setPopupMenuState}
          dashboardState={dashboardState}
        />
      </div>
      <div className="user-window__main">
        <Card card={card} />
      </div>
      <PopupMenu popupMenuState={popupMenuState} />
    </div>
  )
}

export default UserWindow
