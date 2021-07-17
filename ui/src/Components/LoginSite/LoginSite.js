import React from 'react'
import LogoImage from '../../Data/Images/logo.png'
import './LoginSite.css'

const LoginSite = () => (
    <div className="LoginSite__wrapper">
        <img className='LoginSite__logo' src={LogoImage} alt='Logo Tinder for Projects' />
        <div className='LoginSite__label'>
            <label className='LoginSite__label'>User</label>
            <input placeholder='username'></input>
        </div>
        <div className='LoginSite__input'>
            <label className='LoginSite__label'>Login</label>
            <input placeholder='password'></input>
        </div>
        <div>
            <input type='radio' name='Projects' value='Projects'></input>
            <label for='Projects'>Project</label>
            <input type='radio' name='Developer' value='Developer'></input>
            <label for='Developer'>Developer</label>
        </div>
        <button className='LoginSite__button'>Submit</button>
    </div>
)

export default LoginSite;