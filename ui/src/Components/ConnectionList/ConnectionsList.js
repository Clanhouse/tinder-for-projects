import React from 'react'
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
    id: '4',
    name: 'Joseph Perez',
    picture: 'https://randomuser.me/api/portraits/men/77.jpg',
  },
  {
    id: '5',
    name: 'Christina Dam',
    picture: 'https://randomuser.me/api/portraits/women/58.jpg',
  },
  {
    id: '6',
    name: 'Julia Williams',
    picture: 'https://randomuser.me/api/portraits/women/67.jpg',
  },
  {
    id: '7',
    name: 'Keith Robertson',
    picture: 'https://randomuser.me/api/portraits/men/41.jpg',
  },
  {
    id: '8',
    name: 'Nadia Mcclean',
    picture: 'https://randomuser.me/api/portraits/women/24.jpg',
  },
  {
    id: '9',
    name: 'Joseph Perez',
    picture: 'https://randomuser.me/api/portraits/men/77.jpg',
  },
  {
    id: '10',
    name: 'Christina Dam',
    picture: 'https://randomuser.me/api/portraits/women/58.jpg',
  },
]

const ConnectionsList = ({ setPopupMenuState }) => {
  return (
    <ul className="connections">
      {data.length > 0 ? (
        <div className="connections__list">
          {data.map((connection) => (
            <ConnectionsItem
              key={connection.id}
              connection={connection}
              setPopupMenuState={setPopupMenuState}
            />
          ))}
        </div>
      ) : (
        <div className="connection__empty">
          <p>
            You don't have any connections yet. Add new connection you are
            interested in by clicking the thumb-up.
          </p>
        </div>
      )}
    </ul>
  )
}

export default ConnectionsList
