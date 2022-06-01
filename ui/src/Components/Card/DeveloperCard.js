import React, { useState } from "react";
import { useDeveloperCard } from "../../Hooks/useDeveloperCard";
import LoaderSpinner from "../LoaderSpinner/LoaderSpinner";
import { useActiveCard } from "../../Contexts/ActiveCard";
import "./Card.css";
import axios from "axios";
import MatchModal from "../../Modals/Match/MatchModal";
import { useUser } from "../../Hooks/useUser";

const DeveloperCard = ({ updateConnectionsList, setUpdateConnectionsList }) => {
  const { user } = useUser();
  const [matchModalOpen, setMatchModalOpen] = useState(false);
  const { activeCard } = useActiveCard();
  const { generalInfo, skills, achievements, error, loading, getCardData } =
    useDeveloperCard(activeCard);
  const [matchModalContent, setMatchModalContent] = useState({
    user,
    generalInfo,
  });

  const handleClick = (e) => {
    if (e.target.name === "thumbUp") {
      axios
        .post(`${process.env.REACT_APP_API}/match/like`, {
          idDeveloper: generalInfo.id,
          idProject: user.id,
        })
        .then(function (response) {
          if (response.data) {
            setMatchModalContent({ user, generalInfo });
            setMatchModalOpen(true);
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    }
    if (e.target.name === "thumbDown") {
      axios
        .post(`${process.env.REACT_APP_API}/match/unlike`, {
          idDeveloper: generalInfo.id,
          idProject: user.id,
        })
        .then(function (response) {
          console.log(response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    }
    if (!matchModalOpen) getCardData();
  };

  const addToConnections = () => {
    setUpdateConnectionsList(true);
    setMatchModalOpen(false);
  };

  if (loading) return <LoaderSpinner />;
  // @ts-ignore
  if (error) return <p>{error.message}</p>;
  return (
    <div className="card">
      <div className="card__container">
        <div className="card__inner">
          <div className="header">
            <div className="header__image">
              <img
                src={
                  (generalInfo.photos?.length > 0 &&
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
          {skills?.length > 0 ? (
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
          {achievements?.length > 0 ? (
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
        <button
          className="thumbUp"
          name="thumbUp"
          onClick={handleClick}
        ></button>
        <button
          className="thumbDown"
          name="thumbDown"
          onClick={handleClick}
        ></button>
      </div>
      <MatchModal
        open={matchModalOpen}
        setOpen={setMatchModalOpen}
        user={matchModalContent.user}
        generalInfo={matchModalContent.generalInfo}
        addToConnections={addToConnections}
      />
      ;
    </div>
  );
};

export default DeveloperCard;
