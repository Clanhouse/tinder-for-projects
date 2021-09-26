import React from 'react'
import DevProfileCardHeader from './DevProfileCardHeader/DevProfileCardHeader'
import DevProfileCardFeatures from './DevProfileCardFeatures/DevProfileCardFeatures'
import Button from '../../Button/Button'
import './DevProfileCard.css'

const DevProfileCard = ({ card }) => {
  const [profileState, setProfileState] = React.useState(card)
  return card ? (
    <div className="card">
      <div className="card__container">
        <div className="card__inner">
          <DevProfileCardHeader
            name={profileState.name}
            subtitle={profileState.subtitle}
            description={profileState.description}
            image={profileState.image}
          />
          {profileState.features.map((features) => (
            <DevProfileCardFeatures
              key={features.name}
              name={features.name}
              features={features.values}
            />
          ))}
          <div className="profileCard__buttons">
            <Button ghost size="small" onClick={undefined}>
              Cancel
            </Button>
            <Button size="small" onClick={undefined}>
              Save
            </Button>
          </div>
        </div>
      </div>
    </div>
  ) : (
    <div>ERROR</div>
  )
}

export default DevProfileCard
