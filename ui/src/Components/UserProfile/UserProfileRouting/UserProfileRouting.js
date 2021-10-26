import React from 'react'
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import LanguageList from '../LanguageList/LanguageList'
import UserProfile from '../UserProfile'

const UserProfileRouting = () => {
  return (
    <Router>

      <Switch>
        <Route exact path="/">
          <UserProfile />
        </Route>
        <Route exact path="/language">
          <LanguageList />
        </Route>
      </Switch>
    </Router>
  )
}

export default UserProfileRouting
