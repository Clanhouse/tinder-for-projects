import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import LandingPage from "./Components/LandingPage/LandingPage";
import SignUp from "./Components/SignUp/SignUp";
import SignIn from "./Components/SignIn/SignIn";
import "./App.css";
import ListBenefits from "./Components/Benefits/ListBenefits";
import ListQualifications from "./Components/Qualifications/ListQualifications";
const App = () => (
  <Router>
    <Switch>
      <Route path="/signin">
        <SignIn />
      </Route>
      <Route path="/signup">
        <SignUp />
      </Route>
      <Route exact path="/">
        <LandingPage />
      </Route>
    </Switch>
  </Router>
);

export default App;
