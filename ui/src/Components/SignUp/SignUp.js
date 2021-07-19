import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import InputField from '../Form/InputField/InputField'
import RadioGroup from '../Form/RadioGroup/RadioGroup'
import CheckboxField from '../Form/CheckboxField/CheckboxField'
import Button from '../Button/Button'
import AltSigning from '../AltSigning/AltSigning'
import './SignUp.css'

const SignUp = () => {
  const [userData, setUserData] = useState({
    fullName: '',
    email: '',
    password: '',
    passwordConfirm: '',
  })

  const handleSubmit = (e) => {
    e.preventDefault()
    console.log(userData)
  }
  return (
    <div className="signup">
      <div className="signup__container">
        <form className="signup__form" onSubmit={handleSubmit}>
          <InputField
            name="name"
            label="Full Name"
            type="text"
            value={userData.fullName}
            onChange={(e) =>
              setUserData({ ...userData, fullName: e.target.value })
            }
          />
          <RadioGroup name="role" options={['Developer', 'Project Leader']} />
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
          <InputField
            name="passwordConfirm"
            label="Confirm Password"
            type="password"
            value={userData.passwordConfirm}
            onChange={(e) =>
              setUserData({ ...userData, passwordConfirm: e.target.value })
            }
          />
          <div className="signup__group">
            <CheckboxField
              name="terms"
              label={
                <>
                  By signing up you accept the <a href="/">Term of service</a>{' '}
                  and <a href="/">Privacy Policy</a>
                </>
              }
            />
          </div>
          <Button size="small" fullWidth>
            Sign Up
          </Button>
        </form>
        <p>or use</p>
        <AltSigning />
        <p>
          Already have an account? <Link to="/signin">Sign In</Link>
        </p>
      </div>
    </div>
  )
}

export default SignUp
