import React, { useState, useEffect } from 'react'
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
  {
    text: "When I first heard about the app, I couldn't believe it is so simple. Before I signed up, no one had known who I am. Things have changed, and now, I owe my dream job to the app.",
    author: 'John Doe, formerly unknown web developer',
  },
  {
    text: 'People had held my idea was dumb. I had lacked human resources to prove they had been wrong. Then I found out about the app, and I have been able to move to action my devilish plan.',
    author: 'Lue Cypher, founder of Hellmate App',
  },
]

const Quotes = () => {
  const [quotesIndex, setQuotesIndex] = useState(0)

  useEffect(() => {
    let timer = setTimeout(() => {
      const newIndex = quotesIndex + 2 < quotesData.length ? quotesIndex + 2 : 0
      setQuotesIndex(newIndex)
    }, 10000)
    return () => {
      clearTimeout(timer)
    }
  }, [quotesIndex])

  return (
    <div className="quotes">
      <div className="quotes__container">
        <Quote key={quotesIndex} quote={quotesData[quotesIndex]} />
        <Quote key={quotesIndex + 1} quote={quotesData[quotesIndex + 1]} />
      </div>
    </div>
  )
}

export default Quotes
