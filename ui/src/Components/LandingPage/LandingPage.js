import React from 'react'
import Navbar from '../Navbar/Navbar'
import Footer from '../Footer/Footer'
import Hero from './Hero/Hero'
import Section from './Section/Section'
import Quotes from './Quotes/Quotes'
import './LandingPage.css'

const LandingPage = () => {
  return (
    <div className="landing">
      <Navbar />
      <Hero />
      <Section>
        <h2>Testimonials</h2>
        <Quotes />
      </Section>
      <Footer />
    </div>
  )
}

export default LandingPage
