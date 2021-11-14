import React, { useState, useContext } from 'react'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import LandingPage from './Components/LandingPage/LandingPage'
import SignUp from './Components/SignUp/SignUp'
import SignIn from './Components/SignIn/SignIn'
import DeveloperWindow from './Components/UserWindow/DeveloperWindow'
import ProjectLeaderWindow from './Components/UserWindow/ProjectLeaderWindow'
import { ActiveCardProvider } from './Contexts/ActiveCard'
import { ThemeContext } from './Contexts/ThemeContext'

import './App.css'
const App = () => {
  const [user, setUser] = useState(null)
  const [theme, setTheme] = useState('light')
  const userWindow =
    user && user.role === 'developer' ? (
      <ActiveCardProvider>
        <DeveloperWindow />
      </ActiveCardProvider>
    ) : (
      <ActiveCardProvider>
        <ProjectLeaderWindow />
      </ActiveCardProvider>
    )
  return (
    <ThemeContext.Provider value={{theme, setTheme}}>
    <Router>
      <Switch>
        <Route path="/signin">
          <SignIn setUser={setUser} />
        </Route>
        <Route path="/signup">
          <SignUp setUser={setUser} />
        </Route>
        <Route exact path="/">
          {user ? userWindow : <LandingPage />}
        </Route>
      </Switch>
    </Router>
    </ThemeContext.Provider>
  )
}

export default App
