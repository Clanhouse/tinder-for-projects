import React, { useState, useEffect } from 'react'
import axios from 'axios'
import LoaderSpinner from '../LoaderSpinner/LoaderSpinner'
import Card from './Card'

const ProjectCard = () => {
  const [cardData, setCardData] = useState(null)
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(true)

  const fetchCardData = async () => {
    try {
      const result = await axios.get(
        `https://desolate-chamber-92880.herokuapp.com/getRandomProject`
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
  if (error) return <p>{error.message}</p>
  return (
    <Card
      title={`${cardData.projectName}`}
      subtitle={cardData.companyName || ''}
      description={cardData.description}
      qualifications={cardData.qualifications}
      benefits={cardData.benefits}
      handleClick={handleClick}
    />
  )
}

export default ProjectCard
