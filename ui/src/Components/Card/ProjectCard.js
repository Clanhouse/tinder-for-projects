import React, { useState } from "react";
import LoaderSpinner from "../LoaderSpinner/LoaderSpinner";
import { useActiveCard } from "../../Contexts/ActiveCard";
import "./Card.css";
import axios from "axios";
import MatchModal from "../../Modals/Match/MatchModal";
import { useUser } from "../../Hooks/useUser";
import { useCardData } from "../../Hooks/useCardData";

const ProjectCard = ({ updateConnectionsList, setUpdateConnectionsList }) => {
  const { activeCard } = useActiveCard();
  const [matchModalOpen, setMatchModalOpen] = useState(false);
  const { generalInfo, skills, benefits, error, loading, getCardData } =
    useCardData(activeCard, "projects");
  const { user } = useUser();
  const [matchModalContent, setMatchModalContent] = useState({
    user: Object,
    generalInfo: Object,
  });

  const handleClick = (e) => {
    if (e.target.name === "thumbUp") {
      axios
        .post(`${process.env.REACT_APP_API}/match/like`, {
          idDeveloper: user.id,
          idProject: generalInfo.id,
        })
        .then(function (response) {
          setMatchModalContent({ user, generalInfo });
          setMatchModalOpen(response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    }
    if (e.target.name === "thumbDown") {
      axios
        .post(`${process.env.REACT_APP_API}/match/unlike`, {
          idDeveloper: user.id,
          idProject: generalInfo.id,
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
          {skills.length > 0 ? (
            <div className="features">
              <h3 className="features__heading">Qualifications</h3>
              <ul className="features__list">
                {skills.map((skill) => (
                  <li key={skill.name} className="features__item">
                    {skill.name}
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
                  <li key={benefit.name} className="features__item">
                    {benefit.name}
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
    </div>
  );
};

export default ProjectCard;
