import React, { createContext, useContext, useState } from 'react'

// @ts-ignore
export const ActiveCardContext = createContext()
export const useActiveCard = () => {
  return useContext(ActiveCardContext)
}
export const ActiveCardProvider = ({ children }) => {
  const [activeCard, setActiveCard] = useState('')
  const value = {
    activeCard,
    selectCard: setActiveCard,
  }
  return (
    <ActiveCardContext.Provider value={value}>
      {children}
    </ActiveCardContext.Provider>
  )
}
