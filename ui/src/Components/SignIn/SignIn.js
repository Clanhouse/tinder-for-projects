import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import InputField from '../Form/InputField/InputField'
import CheckboxField from '../Form/CheckboxField/CheckboxField'
import Button from '../Button/Button'
import AltSigning from '../AltSigning/AltSigning'
import './SignIn.css'

const SignIn = () => {
  const [userData, setUserData] = useState({
    email: '',
    password: '',
  })

  const handleSubmit = (e) => {
    e.preventDefault()
    console.log(userData)
  }
  return (
    <div className="signin">
      <div className="signin__container">
        <form className="signin__form" onSubmit={handleSubmit}>
          <InputField
            name="email"
            label="Email"
            type="email"
            value={userData.email}
            onChange={(e) =>
              setUserData({ ...userData, email: e.target.value })
            }
          />
          <InputField
            name="password"
            label="Password"
            type="password"
            value={userData.password}
            onChange={(e) =>
              setUserData({ ...userData, password: e.target.value })
            }
          />
          <div className="signin__group">
            <CheckboxField name="terms" label="Remember me" />
            <a href="/">Forgot Password?</a>
          </div>
          <Button size="small" fullWidth>
            Sign In
          </Button>
        </form>
        <p>or use</p>
        <AltSigning />
        <p>
          Don’t have an account? <Link to="/signup">Create new one</Link>
        </p>
      </div>
    </div>
  )
}

export default SignIn
