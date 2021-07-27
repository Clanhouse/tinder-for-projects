import React from 'react'
import CardHeader from './CardHeader/CardHeader'
import CardFeatures from './CardFeatures/CardFeatures'
import './Card.css'

//dummy function
function handleClick() {
  console.log('Kliknięto')
}

const Card = ({ card }) => {
  return card ? (
    <div className="card">
      <div className="card__container">
        <div className="card__inner">
          <CardHeader
            name={card.name}
            subtitle={card.subtitle}
            description={card.description}
            image={card.image}
          />
          {card.features.map((features) => (
            <CardFeatures
              key={features.name}
              name={features.name}
              features={features.values}
            />
          ))}
        </div>
      </div>
      <div className="card__buttons">
        <button className="thumbUp" onClick={handleClick}></button>
        <button className="thumbDown" onClick={handleClick}></button>
      </div>
    </div>
  ) : (
    <div>ERROR</div>
  )
}

export default Card
