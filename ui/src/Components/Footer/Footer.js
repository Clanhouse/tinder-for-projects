import React from 'react'
import './Footer.css'

const Footer = () => {
  return (
    <footer className="footer">
      <ul className="footer__nav-list">
        <li className="footer__nav-item">
          <a href="/">FAQ</a>
        </li>
        <li className="footer__nav-item">
          <a href="/">Safety Tips</a>
        </li>
        <li className="footer__nav-item">
          <a href="/">Terms</a>
        </li>
        <li className="footer__nav-item">
          <a href="/">Cookie Policy</a>
        </li>
        <li className="footer__nav-item">
          <a href="/">Privacy Settings</a>
        </li>
      </ul>
      <p className="footer__copy">© 2021 Clan House | Designed and developed by Unicorn Team</p>
    </footer>
  )
}

export default Footer
