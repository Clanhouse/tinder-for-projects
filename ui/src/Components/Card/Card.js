import React from 'react'
import './Card.css'

const Card = ({
  image,
  title,
  subtitle,
  description,
  skills,
  achievements,
  qualifications,
  benefits,
  handleClick,
}) => {
  return (
    <div className="card">
      <div className="card__container">
        <div className="card__inner">
          <div className="header">
            <div className="header__image">
              <img src={image} alt={`${title}`} />
            </div>
            <div className="header__content">
              <h1 className="header__heading header__heading--primary">
                {title}
              </h1>
              <h2 className="header__heading header__heading--secondary">
                {subtitle}
              </h2>
              <p className="header__description">{description}</p>
            </div>
          </div>
          {skills ? (
            <div className="features">
              <h3 className="features__heading">Skills</h3>
              <ul className="features__list">
                {skills.map((skill) => (
                  <li key={skill.id} className="features__item">
                    {skill.name}
                  </li>
                ))}
              </ul>
            </div>
          ) : null}
          {achievements ? (
            <div className="features">
              <h3 className="features__heading">Achievements</h3>
              <ul className="features__list">
                <li className="features__item">{achievements}</li>
              </ul>
            </div>
          ) : null}
          {qualifications ? (
            <div className="features">
              <h3 className="features__heading">Qualifications</h3>
              <ul className="features__list">
                {qualifications.map((qualification) => (
                  <li key={qualification.id} className="features__item">
                    {qualification.name}
                  </li>
                ))}
              </ul>
            </div>
          ) : null}
          {benefits ? (
            <div className="features">
              <h3 className="features__heading">Benefits</h3>
              <ul className="features__list">
                {benefits.map((benefit) => (
                  <li key={benefit.id} className="features__item">
                    {benefit.name}
                  </li>
                ))}
              </ul>
            </div>
          ) : null}
        </div>
      </div>
      <div className="card__buttons">
        <button className="thumbUp" onClick={handleClick}></button>
        <button className="thumbDown" onClick={handleClick}></button>
      </div>
    </div>
  )
}

export default Card
