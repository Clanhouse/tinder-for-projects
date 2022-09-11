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
import keycloak from "./keycloak";
import { ReactKeycloakProvider } from "@react-keycloak/web";
import Protected from "./Keycloak/Protected";

const App = () => {
  const [theme, setTheme] = useState("light");
  const { user } = useUser();
  return (
    <ReactKeycloakProvider
      authClient={keycloak}
      initOptions={{ onload: "check-sso" }}
      onTokens={() => {
        //@ts-ignore
        localStorage.setItem("token", keycloak.token);
      }}
    >
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
                  <Protected>
                    <ActiveCardProvider>
                      <UserWindow user={user} />
                    </ActiveCardProvider>
                  </Protected>
                ) : (
                  <LandingPage />
                )}
              </Route>
            </Switch>
          </Router>
        </div>
      </ThemeContext.Provider>
    </ReactKeycloakProvider>
  );
};

export default App;
