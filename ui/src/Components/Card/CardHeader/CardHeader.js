import React from 'react'
import './CardHeader.css'

const CardHeader = ({ name, subtitle, description, image }) => {
  return (
    <div className="header">
      <div className="header__image">
        <img src={image} alt={`${name}`} />
      </div>
      <div className="header__content">
        <h1 className="header__heading header__heading--primary">{name}</h1>
        <h2 className="header__heading header__heading--secondary">
          {subtitle}
        </h2>
        <p className="header__description">{description}</p>
      </div>
    </div>
  )
}

export default CardHeader
