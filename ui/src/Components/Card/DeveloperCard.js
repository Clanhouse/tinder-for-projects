import React from "react";
import { useCardData } from "../../Hooks/useCardData";
import LoaderSpinner from "../LoaderSpinner/LoaderSpinner";
import { useActiveCard } from "../../Contexts/ActiveCard";
import "./Card.css";

const DeveloperCard = () => {
  const { activeCard } = useActiveCard();
  const { generalInfo, skills, achievements, error, loading, getCardData } =
    useCardData(activeCard, "developers");

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
                  (generalInfo.photos &&
                    generalInfo.photos.length > 0 &&
                    generalInfo.photos[0].url) ||
                  null
                }
                alt={`${generalInfo.firstName} ${generalInfo.lastName}`}
              />
            </div>
            <div className="header__content">
              <h1 className="header__heading header__heading--primary">
                {`${generalInfo.firstName} ${generalInfo.lastName}`}
              </h1>
              <h2 className="header__heading header__heading--secondary">
                {generalInfo.profession}
              </h2>
              <p className="header__description">{generalInfo.description}</p>
            </div>
          </div>
          {skills.length > 0 ? (
            <div className="features">
              <h3 className="features__heading">Skills</h3>
              <ul className="features__list">
                {skills.map((skill) => (
                  <li key={skill.id} className="features__item">
                    {skill.name}
                  </li>
                ))}
              </ul>
            </div>
          ) : null}
          {achievements.length > 0 ? (
            <div className="features">
              <h3 className="features__heading">Achievements</h3>
              <ul className="features__list">
                {achievements.map((achievement) => (
                  <li key={achievement.id} className="features__item">
                    {achievement.name}
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

export default DeveloperCard;
