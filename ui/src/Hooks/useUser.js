import React, { useState, createContext, useContext } from "react";

// @ts-ignore
export const UserContext = createContext();
export const useUser = () => {
  return useContext(UserContext);
};
export const UserProvider = ({ children }) => {
  const [user, setUser] = useState();
  const value = {
    user,
    setUser,
  };
  return <UserContext.Provider value={value}>{children}</UserContext.Provider>;
};
