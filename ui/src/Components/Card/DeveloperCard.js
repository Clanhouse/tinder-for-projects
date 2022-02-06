import React, { useState, useEffect } from 'react'
import axios from 'axios'
import LoaderSpinner from '../LoaderSpinner/LoaderSpinner'
import Card from './Card'
import { useActiveCard } from '../../Contexts/ActiveCard'

const DeveloperCard = () => {
  const [cardData, setCardData] = useState(null)
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(true)

  const { selectCard, activeCard } = useActiveCard()

  const fetchRandomCardData = async () => {
    try {
      const result = await axios.get(
        `${process.env.REACT_APP_API}/developer/random`
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
        `${process.env.REACT_APP_API}/developer/${id}`
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
