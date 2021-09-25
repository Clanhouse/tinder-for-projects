import React, { useState, useEffect } from 'react'
import axios from 'axios'
import LoaderSpinner from '../LoaderSpinner/LoaderSpinner'
import Card from './Card'

const DeveloperCard = () => {
  const [cardData, setCardData] = useState(null)
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(true)

  const fetchCardData = async () => {
    try {
      const result = await axios.get(
        `https://desolate-chamber-92880.herokuapp.com/getRandomDeveloper`
      )
      setCardData(result.data)
    } catch (err) {
      setError(err)
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchCardData()
  }, [])

  const handleClick = () => {
    setLoading(true)
    fetchCardData()
  }

  if (loading) return <LoaderSpinner />
  if (error) return <p>{error}</p>
  return (
    <Card
      title={`${cardData.firstName} ${cardData.lastName}`}
      subtitle={cardData.role || ''}
      description={cardData.description}
      skills={cardData.skills}
      achievements={cardData.achievements}
      handleClick={handleClick}
    />
  )
}

export default DeveloperCard
