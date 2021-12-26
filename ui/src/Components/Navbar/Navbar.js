import React, { useRef } from "react";
import RouterButton from "../RouterButton/RouterButton";
import "./Navbar.css";
import logo from "../../Data/Images/logo.png";
import { ReactComponent as BurgerButton } from "../../Data/Images/bars-solid.svg";
import { ReactComponent as CloseButton } from "../../Data/Images/times-solid.svg";

const Navbar = () => {
  const menu = useRef(null);
  const toggleMenu = () => {
    menu.current.classList.toggle("navbar__nav--active");
  };
  return (
    <nav className="navbar">
      <div className="navbar__container">
        <img src={logo} alt="Apps logo" className="navbar__logo" />
        <div ref={menu} className="navbar__nav">
          <div className="navbar__close" onClick={toggleMenu}>
            <CloseButton />
          </div>
          <ul className="navbar__nav-list" data-testid="ul-navbar">
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
        <div className="navbar__burger" onClick={toggleMenu}>
          <BurgerButton />
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
