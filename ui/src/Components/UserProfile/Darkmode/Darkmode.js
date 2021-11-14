import React, { useContext } from 'react'
import { ThemeContext } from '../../../Contexts/ThemeContext'
import { ReactComponent as SwitchButton } from '../../../Data/Images/switch-button.svg'

const Darkmode = () => {
  
  const {theme, setTheme} = useContext(ThemeContext)

  const handleThemeToggle = (e) => {
    console.log(theme);
    e.preventDefault()
    setTheme(theme === 'light' ? 'dark' : 'light')
}
  return (
    <div className="profile--item">
      Dark-mode
      <div className="profile--item--right" onClick={handleThemeToggle}>
        <SwitchButton />
      </div>
    </div>
  )
}

export default Darkmode