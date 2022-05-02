import React, { useState } from "react";
import { useProjectCard } from "../../Hooks/useProjectCard";
import LoaderSpinner from "../LoaderSpinner/LoaderSpinner";
import { useActiveCard } from "../../Contexts/ActiveCard";
import "./Card.css";
import axios from "axios";
import MatchModal from "../../Modals/Match/MatchModal";
import { useUser } from "../../Hooks/useUser";

const ProjectCard = () => {
  const { user } = useUser();
  console.log("user: ", user);
  const [open, setOpen] = useState(false);
  const { activeCard } = useActiveCard();
  const { generalInfo, qualifications, benefits, error, loading, getCardData } =
    useProjectCard(activeCard);
    console.log("ActiveCard: ", generalInfo);


  const handleClick = (e) => {
    if (e.target.name === "thumbUp") {
      axios
        .post(`${process.env.REACT_APP_API}/match/like`, {
          //TODO: change id's
          idDeveloper: user.id,
          idProject: generalInfo.id
        })
        .then(function (response) {
          console.log("Project card2: ", response.data);
          setOpen(response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    }
    if (e.target.name === "thumbDown") {
      axios
        .post(`${process.env.REACT_APP_API}/match/unlike`, {
          //TODO: change id's
          idDeveloper: user.id,
          idProject: generalInfo.id
        })
        .then(function (response) {
          console.log("thumbDown ", response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    }
    getCardData();
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
      <MatchModal open={open} setOpen={setOpen} user={undefined} card={undefined} />
    </div>
  );
};

export default ProjectCard;
