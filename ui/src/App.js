import React, { useState } from 'react'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import LandingPage from './Components/LandingPage/LandingPage'
import SignUp from './Components/SignUp/SignUp'
import SignIn from './Components/SignIn/SignIn'
import UserWindow from './Components/UserWindow/UserWindow'
import './App.css'
const App = () => {
  const [user, setUser] = useState(null)

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
          {user ? <UserWindow role={user.role} /> : <LandingPage />}
        </Route>
      </Switch>
    </Router>
  )
}

export default App