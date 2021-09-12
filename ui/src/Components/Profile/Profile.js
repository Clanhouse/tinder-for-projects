import React from 'react'
import { useState, useEffect, useRef } from 'react'
import Button from '../Button/Button'
import { ReactComponent as EditIcon } from '../../Data/Images/edit-solid.svg'
import { ReactComponent as SwitchButton } from '../../Data/Images/switch-button.svg'
import './Profile.css'

const Profile = () => {
  const initProfileState = {
    name: 'John Dow',
    email: 'user@user.us',
    phone: '+ 0 500 2 900',
    language: 'English',
    darkMode: false,
  }
  const [profileState, setProfileState] = useState(initProfileState)
  const name = useRef(null)
  const email = useRef(null)
  const phone = useRef(null)

  function handleClick() {
    console.log('Kliknięto')
  }
  const handleChange = (e) => {}

  return (
    <div className="profile">
      <div className="profile__accounts">
        <p className="profile__accounts--header">Account</p>
        <div className="profile--item">
          <p>Name: </p>
          <input
            ref={name}
            value={profileState.name}
            onChange={(e) =>
              setProfileState({ ...profileState, name: e.target.value })
            }
          ></input>
          <EditIcon
            onClick={() => {
              name.current.focus()
            }}
          />
        </div>
        <div className="profile--item">
          <p>E-mail: </p>
          <input
            ref={email}
            value={profileState.email}
            onChange={(e) =>
              setProfileState({ ...profileState, email: e.target.value })
            }
          ></input>
          <EditIcon
            onClick={() => {
              email.current.focus()
            }}
          />
        </div>
        <div className="profile--item">
          <p>Phone: </p>
          <input
            ref={phone}
            value={profileState.phone}
            onChange={(e) =>
              setProfileState({ ...profileState, phone: e.target.value })
            }
          ></input>
          <EditIcon
            onClick={() => {
              phone.current.focus()
            }}
          />
        </div>
      </div>

      <div className="profile--settings">
        <p className="profile__settings--header">Settings</p>
        <div className="profile--item">
          <p>Language: </p>
          <input value={profileState.language}></input>
          <EditIcon onClick={handleClick} />
        </div>
        <div className="profile--item">
          <p>Dark-mode</p>
          <SwitchButton />
        </div>
      </div>

      <div className="profile--buttons">
        <Button fullWidth>Logout</Button>
        <Button fullWidth ghost>
          Delete account
        </Button>
      </div>
    </div>
  )
}

export default Profile
