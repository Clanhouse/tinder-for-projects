import React from 'react'
import ProjectCard from '../Card/ProjectCard'
import UserWindow from './UserWindow'

const DeveloperWindow = () => {
  return <UserWindow cardComponent={ProjectCard} />
}

export default DeveloperWindow
