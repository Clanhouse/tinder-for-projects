import React from 'react'
import RouterButton from '../../RouterButton/RouterButton'
import './Hero.css'

const Hero = () => {
  return (
    <div className="hero">
      <div className="hero__content">
        <div className="hero__text">
          <h1 className="hero__heading hero__heading--primary">
            We help connect
          </h1>
          <h2 className="hero__heading hero__heading--secondary">
            Find your next business partner
          </h2>
        </div>
        <RouterButton size="big" to="/signup">
          Sign Up
        </RouterButton>
        <RouterButton
          ghost
          mobile
          size="big"
          to="/signin"
          style={{ marginTop: '20px' }}
        >
          Log In
        </RouterButton>
      </div>
    </div>
  )
}

export default Hero
