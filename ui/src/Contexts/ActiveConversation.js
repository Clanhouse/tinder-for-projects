import React, { createContext, useContext, useState } from "react";

export const ActiveConversationContext = createContext();
export const useActiveConversation = () => {
  return useContext(ActiveConversationContext);
};
export const ActiveConversationProvider = ({ children }) => {
  const [activeConversation, setActiveConversation] = useState(null);
  const value = {
    activeConversation,
    selectConversation: setActiveConversation,
  };
  return (
    <ActiveConversationContext.Provider value={value}>
      {children}
    </ActiveConversationContext.Provider>
  );
};
