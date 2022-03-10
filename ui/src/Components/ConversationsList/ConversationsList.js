import React from 'react'
import { PopupMenu, PopupScrollHandler } from '../Popup/Popup'
import ConversationsItem from './ConversationsItem/ConversationsItem'
import './ConversationsList.css'

const data = [
  {
    id: '1',
    name: 'Julia Williams',
    message: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    picture: 'https://randomuser.me/api/portraits/women/67.jpg',
  },
  {
    id: '2',
    name: 'Keith Robertson',
    message: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    picture: 'https://randomuser.me/api/portraits/men/41.jpg',
  },
  {
    id: '3',
    name: 'Nadia Mcclean',
    message: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    picture: 'https://randomuser.me/api/portraits/women/24.jpg',
  },
  {
    id: '4',
    name: 'Joseph Perez',
    message: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    picture: 'https://randomuser.me/api/portraits/men/77.jpg',
  },
  {
    id: '5',
    name: 'Christina Dam',
    message: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    picture: 'https://randomuser.me/api/portraits/women/58.jpg',
  },
]

const ConversationsList = () => {
  return (
    <PopupScrollHandler>
      <PopupMenu>
        <li className="popup-menu__item">Mark as unread</li>
        <li className="popup-menu__item">Show card</li>
        <li className="popup-menu__item">Delete chat</li>
      </PopupMenu>
      <div className="conversations">
        {data.length > 0 ? (
          <ul className="conversations__list">
            {data.map((conversation) => (
              <ConversationsItem
                key={conversation.id}
                conversation={conversation}
              />
            ))}
          </ul>
        ) : (
          <div className="conversations__empty">
            <p>
              You don't have any conversations. Send a message to one of your
              new contacts under the connections tab.
            </p>
          </div>
        )}
      </div>
    </PopupScrollHandler>
  )
}

export default ConversationsList
