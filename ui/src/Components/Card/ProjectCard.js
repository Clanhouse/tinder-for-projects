import React, { useState, useEffect } from 'react'
import axios from 'axios'
import LoaderSpinner from '../LoaderSpinner/LoaderSpinner'
import Card from './Card'
import { useActiveCard } from '../../Contexts/ActiveCard'

const ProjectCard = () => {
  const [cardData, setCardData] = useState(null)
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(true)

  const { selectCard, activeCard } = useActiveCard()

  const fetchRandomCardData = async () => {
    try {
      const result = await axios.get(
        `${process.env.REACT_APP_API}/project`
      )
      setCardData(result.data)
    } catch (err) {
      setError(err)
    } finally {
      setLoading(false)
    }
  }

  const fetchCardData = async (id) => {
    try {
      const result = await axios.get(
        `${process.env.REACT_APP_API}/project/${id}`
      )
      setCardData(result.data)
    } catch (err) {
      setError(err)
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchRandomCardData()
  }, [])

  useEffect(() => {
    if (activeCard) {
      setLoading(true)
      fetchCardData(activeCard)
    }
  }, [activeCard])

  const handleClick = () => {
    selectCard('')
    setLoading(true)
    fetchRandomCardData()
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
