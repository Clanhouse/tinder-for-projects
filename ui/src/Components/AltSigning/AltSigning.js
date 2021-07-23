import React from 'react'
import {ReactComponent as GitHubLogo} from '../../Data/Images/github-brands.svg'
import {ReactComponent as GoogleLogo} from '../../Data/Images/google-brands.svg'
import {ReactComponent as FacebookLogo} from '../../Data/Images/facebook-brands.svg'
import './AltSigning.css'

const AltSigning = () => {
  return (
    <div className="alt-signing">
      <a href="/">
        <GitHubLogo />
      </a>
      <a href="/">
        <GoogleLogo />
      </a>
      <a href="/">
        <FacebookLogo />
      </a>
    </div>
  )
}

export default AltSigning;