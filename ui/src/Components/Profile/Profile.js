import React, { useState, useRef } from 'react'
import Button from '../Button/Button'
import { Modal } from 'react-responsive-modal'
import './Profile.css'
import 'react-responsive-modal/styles.css'
import { ReactComponent as EditIcon } from '../../Data/Images/edit-solid.svg'
import { ReactComponent as SwitchButton } from '../../Data/Images/switch-button.svg'
import DevProfileCard from './DevProfileCard/DevProfileCard'

export const ProfileCard = {
  image:
    'https://s.ciekawostkihistoryczne.pl/uploads/2019/03/Albert_Einstein_Head.jpg',
  name: 'Albert Einstein',
  subtitle: 'Aspiring full-stack developer',
  description:
    'I know nothing about web development. I have developed the theory of relativity, though, so developing minor web apps won’t be a problem for me!',
  features: [
    {
      name: 'Skills',
      values: ['Physics', 'Philosophy', 'Quantum Theory', 'Mathematics'],
    },
    {
      name: 'Achievments',
      values: ['E=mc2', 'Nobel Prize in Physics', 'Proper Genius'],
    },
  ],
}
const Profile = () => {
  const initProfileState = {
    name: 'John Dow',
    email: 'user@user.us',
    phone: '+ 0 500 2 900',
    language: 'English',
    darkMode: false,
  }
  const [profileState, setProfileState] = useState(initProfileState)
  const [editMyCardModalState, setEditMyCardModalState] = useState(false)
  const [logOutModalState, setlogoutOutModalState] = useState(false)
  const [deleteAccountState, setDeleteAccountState] = useState(false)
  const name = useRef(null)
  const email = useRef(null)
  const phone = useRef(null)

  const onOpenCardModal = () => setEditMyCardModalState(true)
  const onCloseCardModal = () => setEditMyCardModalState(false)
  const onOpenLogoutOutModal = () => setlogoutOutModalState(true)
  const onCloseLogoutOutModal = () => setlogoutOutModalState(false)
  const onOpenDeleteAccountModal = () => setDeleteAccountState(true)
  const onCloseDeleteAccountModal = () => setDeleteAccountState(false)

  function handleClick() {
    console.log('Kliknięto')
  }

  return (
    <div className="profile">
      <div className="profile__accounts">
        <p className="profile__accounts--header">Account</p>
        <div className="profile--item">
          <p>Name: </p>
          <input
            className="profile__input"
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
        <Button fullWidth>Save</Button>
        <Button fullWidth onClick={onOpenCardModal}>
          Edit my card
        </Button>
        <Button fullWidth onClick={onOpenLogoutOutModal}>
          Logout
        </Button>
        <Button fullWidth ghost onClick={onOpenDeleteAccountModal}>
          Delete account
        </Button>
      </div>

      {/*Modal to handle User Profile Card for edit - Edit My Card button clicked*/}
      <Modal open={editMyCardModalState} onClose={onCloseCardModal} center>
        <div>
          <DevProfileCard card={ProfileCard} />
        </div>
      </Modal>

      {/*Modal to handle Logout button */}
      <Modal open={logOutModalState} onClose={onCloseLogoutOutModal} center>
        <div className="profile__modal">
          <span>Do you really want to log out?</span>
          <div className="profile__modal--buttons">
            <Button ghost>Cancel</Button>
            <Button>Log me out</Button>
          </div>
        </div>
      </Modal>

      {/*Modal to handle Delete Account button */}
      <Modal
        open={deleteAccountState}
        onClose={onCloseDeleteAccountModal}
        center
      >
        <div className="profile__modal">
          <span>Are you sure you want to delete your account?</span>
          <div className="profile__modal--buttons">
            <Button ghost>Cancel</Button>
            <Button>Delete my account</Button>
          </div>
        </div>
      </Modal>
    </div>
  )
}

export default Profile
