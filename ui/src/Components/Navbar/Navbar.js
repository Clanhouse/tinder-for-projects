import React from 'react'
import RouterButton from '../RouterButton/RouterButton'
import './Navbar.css'
import logo from '../../Data/Images/logo.png'

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar__container">
        <img src={logo} alt="Apps logo" className="navbar__logo" />
        <ul className="navbar__nav-list">
          <li className="navbar__nav-item">
            <a href="/products">Products</a>
          </li>
          <li className="navbar__nav-item">
            <a href="/Learn">Learn</a>
          </li>
        </ul>
        <div className="navbar__cta">
          <RouterButton ghost size="small" to="/signin">
            Log In
          </RouterButton>
        </div>
      </div>
    </nav>
  )
}

export default Navbar
