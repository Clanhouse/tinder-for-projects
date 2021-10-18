import React from 'react'
import { languages } from '../data'
import { Link } from 'react-router-dom'
import './LanguageList.css'

const LanguageList = () => {

  return (
    <div className="languageList">
      <ul>
        {languages.map((item) => {
          return (
            <Link to="/">
              <li>{item}</li>
            </Link>
          )
        })}
      </ul>
    </div>
  )
}

export default LanguageList
