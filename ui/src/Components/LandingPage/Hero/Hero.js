import React from 'react'
import Button from '../../Button/Button'
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
        <Button size="big">Sign Up</Button>
      </div>
    </div>
  )
}

export default Hero
