import React, { useState } from 'react'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import LandingPage from './Components/LandingPage/LandingPage'
import SignUp from './Components/SignUp/SignUp'
import SignIn from './Components/SignIn/SignIn'
import DeveloperWindow from './Components/UserWindow/DeveloperWindow'
import ProjectLeaderWindow from './Components/UserWindow/ProjectLeaderWindow'

import './App.css'
const App = () => {
  const [user, setUser] = useState(null)
  const userWindow =
    user && user.role === 'developer' ? (
      <DeveloperWindow />
    ) : (
      <ProjectLeaderWindow />
    )
  return (
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
  )
}

export default App
