import React, { useState } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import LandingPage from "./Components/LandingPage/LandingPage";
import SignUp from "./Components/SignUp/SignUp";
import SignIn from "./Components/SignIn/SignIn";
import UserWindow from "./Components/UserWindow/UserWindow";
import { ActiveCardProvider } from "./Contexts/ActiveCard";
import { ThemeContext } from "./Contexts/ThemeContext";
import { useUser } from "./Hooks/useUser";
import "./App.css";

const App = () => {
  const [theme, setTheme] = useState("light");
  const { user } = useUser();
  return (
    <ThemeContext.Provider value={{ theme, setTheme }}>
      <div data-theme={theme}>
        <Router>
          <Switch>
            <Route path="/signin">
              <SignIn />
            </Route>
            <Route path="/signup">
              <SignUp />
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
