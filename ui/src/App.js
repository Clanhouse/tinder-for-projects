import React, { useState } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import LandingPage from "./Components/LandingPage/LandingPage";
import SignUp from "./Components/SignUp/SignUp";
import SignIn from "./Components/SignIn/SignIn";
import UserWindow from "./Components/UserWindow/UserWindow";
import { ActiveCardProvider } from "./Contexts/ActiveCard";
import { ThemeContext } from "./Contexts/ThemeContext";
import "./App.css";

const App = () => {
  const [user, setUser] = useState(null);
  const [theme, setTheme] = useState("light");
  return (
    <ThemeContext.Provider value={{ theme, setTheme }}>
      <div data-theme={theme}>
        <Router>
          <Switch>
            <Route path="/signin">
              <SignIn setUser={setUser} />
            </Route>
            <Route path="/signup">
              <SignUp setUser={setUser} />
            </Route>
            <Route exact path="/">
              {user ? (
                <ActiveCardProvider>
                  <UserWindow user={user} />
                </ActiveCardProvider>
              ) : (
                <LandingPage />
              )}
            </Route>
          </Switch>
        </Router>
      </div>
    </ThemeContext.Provider>
  );
};

export default App;
