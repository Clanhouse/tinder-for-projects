// @ts-nocheck
import React from 'react'
import './Quote.css'
import quoteIcon from '../../../../Data/Images/quote-icon.png'

const Quote = ({ quote }) => {
  return (
    <div className="quote">
      <img src={quoteIcon} alt="quote icon" className="quote__icon" />
      <div className="quote__body">
        <p className="quote__citation">{quote.text}</p>
        <p className="quote__author">{quote.author}</p>
      </div>
    </div>
  )
}

export default Quote
