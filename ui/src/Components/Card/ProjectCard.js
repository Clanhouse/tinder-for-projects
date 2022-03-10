import React from "react";
import { useProjectCard } from "../../Hooks/useProjectCard";
import LoaderSpinner from "../LoaderSpinner/LoaderSpinner";
import { useActiveCard } from "../../Contexts/ActiveCard";
import "./Card.css";

const ProjectCard = () => {
  const { activeCard } = useActiveCard();
  const { generalInfo, qualifications, benefits, error, loading, getCardData } =
    useProjectCard(activeCard);

  const handleClick = () => {
    getCardData();
  };

  if (loading) return <LoaderSpinner />;
  if (error) return <p>{error.message}</p>;
  return (
    <div className="card">
      <div className="card__container">
        <div className="card__inner">
          <div className="header">
            <div className="header__image">
              <img
                src={
                  (generalInfo.photos && generalInfo.photos.length > 0 &&
                    generalInfo.photos[0].url) ||
                  null
                }
                alt={`${generalInfo.name}`}
              />
            </div>
            <div className="header__content">
              <h1 className="header__heading header__heading--primary">
                {`${generalInfo.name}`}
              </h1>
              <h2 className="header__heading header__heading--secondary">
                {generalInfo.company.name}
              </h2>
              <p className="header__description">{generalInfo.description}</p>
            </div>
          </div>
          {qualifications.length > 0 ? (
            <div className="features">
              <h3 className="features__heading">Qualifications</h3>
              <ul className="features__list">
                {qualifications.map((qualification) => (
                  <li key={qualification.id} className="features__item">
                    {qualification.name}
                  </li>
                ))}
              </ul>
            </div>
          ) : null}
          {benefits.length > 0 ? (
            <div className="features">
              <h3 className="features__heading">Benefits</h3>
              <ul className="features__list">
                {benefits.map((benefit) => (
                  <li key={benefit.id} className="features__item">
                    {benefit.name}
                  </li>
                ))}
              </ul>
            </div>
          ) : null}
        </div>
      </div>
      <div className="card__buttons">
        <button className="thumbUp" onClick={handleClick}></button>
        <button className="thumbDown" onClick={handleClick}></button>
      </div>
    </div>
  );
};

export default ProjectCard;
