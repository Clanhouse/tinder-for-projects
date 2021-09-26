import React from 'react'
import './DevProfileCardHeader.css'
import blank from '../../../../Data/Images/camera-solid.svg'

const DevProfileCardHeader = ({ name, subtitle, description, image }) => {
  return (
    <div className="profile__header">
      <div className="header__image">
        {image ? (
          <img src={image} alt={`${name}`} />
        ) : (
          <img src={blank} alt={`${name}`} />
        )}
      </div>
      <div className="profile__header profile__content">
        <form className="profile__form">
        <input
          className="profile__header profile__name"
          defaultValue={name}
          onChange={undefined}
        ></input>
        <input
          className="profile__header profile__subtitle"
          defaultValue={subtitle}
          onChange={undefined}
        ></input>
        <textarea
          className="profile__header profile__description"
          defaultValue={description}
          rows={4}
          onChange={undefined}
        ></textarea>
        </form>
      </div>
    </div>
  )
}

export default DevProfileCardHeader
