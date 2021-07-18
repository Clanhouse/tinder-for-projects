import React from 'react'
import Quote from './Quote/Quote'
import './Quotes.css'

const quotesData = [
  {
    text: 'I have been struggling to find a patron who would allow me to express my extraordinary talent. If not for the app, I could be forgotten forever.',
    author: 'Vincent van Gogh, post-impressionist designer',
  },
  {
    text: 'Thanks to the app, I have found the right people to fulfill my dreams. Now my startup conquers the world.',
    author: 'Genghis Khan, CEO of the Mongol Empire',
  },
]

const Quotes = () => {
  return (
    <div className="quotes">
      <Quote quote={quotesData[0]} />
      <Quote quote={quotesData[1]} />
    </div>
  )
}

export default Quotes
