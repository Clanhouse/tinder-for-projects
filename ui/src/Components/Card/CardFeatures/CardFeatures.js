import React from 'react'
import './CardFeatures.css'

const CardFeatures = ({ name, features }) => {
  return (
    <div className="features">
      <h3 className="features__heading">{name}</h3>
      <ul className="features__list">
        {features.map((feature) => (
          <li key={feature} className="features__item">
            {feature}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default CardFeatures
