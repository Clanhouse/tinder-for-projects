import React from 'react'
import './LoaderSpinner.css'

const LoaderSpinner = () => {
  return (
    <div className="lds-ring">
      <div></div>
      <div></div>
      <div></div>
      <div></div>
    </div>
  )
}

export default LoaderSpinner
