import React from 'react'
import { PopupMenu, PopupScrollHandler } from '../Popup/Popup'
import ConnectionsItem from './ConnectionsItem/ConnectionsItem'
import './ConnectionsList.css'

const data = [
  {
    id: '1',
    name: 'Julia Williams',
    picture: 'https://randomuser.me/api/portraits/women/67.jpg',
  },
  {
    id: '2',
    name: 'Keith Robertson',
    picture: 'https://randomuser.me/api/portraits/men/41.jpg',
  },
  {
    id: '3',
    name: 'Nadia Mcclean',
    picture: 'https://randomuser.me/api/portraits/women/24.jpg',
  },
  {
    id: '1',
    name: 'Joseph Perez',
    picture: 'https://randomuser.me/api/portraits/men/77.jpg',
  },
  {
    id: '2',
    name: 'Christina Dam',
    picture: 'https://randomuser.me/api/portraits/women/58.jpg',
  },
  {
    id: '3',
    name: 'Julia Williams',
    picture: 'https://randomuser.me/api/portraits/women/67.jpg',
  },
  {
    id: '1',
    name: 'Keith Robertson',
    picture: 'https://randomuser.me/api/portraits/men/41.jpg',
  },
  {
    id: '2',
    name: 'Nadia Mcclean',
    picture: 'https://randomuser.me/api/portraits/women/24.jpg',
  },
  {
    id: '3',
    name: 'Joseph Perez',
    picture: 'https://randomuser.me/api/portraits/men/77.jpg',
  },
  {
    id: '1',
    name: 'Christina Dam',
    picture: 'https://randomuser.me/api/portraits/women/58.jpg',
  },
]

const ConnectionsList = () => {
  return (
    <PopupScrollHandler>
      <PopupMenu>
        <li className="popup-menu__item">Start chat</li>
        <li className="popup-menu__item">Delete contact</li>
      </PopupMenu>
      <div className="connections">
        {data.length > 0 ? (
          <ul className="connections__list">
            {data.map((connection) => (
              <ConnectionsItem key={connection.id} connection={connection} />
            ))}
          </ul>
        ) : (
          <div className="connection__empty">
            <p>
              You don't have any connections yet. Add new connection you are
              interested in by clicking the thumb-up.
            </p>
          </div>
        )}
      </div>
    </PopupScrollHandler>
  )
}

export default ConnectionsList
