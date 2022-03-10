import React from "react";
import { useProjectCard } from "../../Hooks/useProjectCard";
import LoaderSpinner from "../LoaderSpinner/LoaderSpinner";
import Button from "../Button/Button";
import InputField from "../Form/InputField/InputField";
import TextArea from "../Form/TextArea/TextArea";

const ProjectCardEditable = ({ user }) => {
  console.log(user)
  const {
    generalInfo,
    qualification,
    qualifications,
    qualificationSuggestions,
    benefit,
    benefits,
    benefitSuggestions,
    error,
    loading,
    setGeneralInfo,
    setQualification,
    setBenefit,
    updateGeneralInfo,
    addQualificationFromList,
    addNewQualification,
    addBenefitFromList,
    addNewBenefit,
  } = useProjectCard(user.id);

  const addQualificationOnKeyPress = (e) => {
    if (e.which === 13 && qualification) {
      if (
        !qualificationSuggestions
          .map((qualification) => qualification.name.toLowerCase())
          .includes(qualification.toLowerCase())
      ) {
        addNewQualification(qualification);
      } else {
        const _qualification = qualificationSuggestions.find(
          (currQualification) => {
            return (
              currQualification.name.toLowerCase() ===
              qualification.toLowerCase()
            );
          }
        );
        addQualificationFromList(_qualification.id);
      }
    }
  };

  const addQualificationOnClick = (e) => {
    const id = parseInt(e.target.id.split("::")[0]);
    addQualificationFromList(id);
  };

  const addBenefitOnKeyPress = (e) => {
    if (e.which === 13 && benefit) {
      if (
        !benefitSuggestions
          .map((benefit) => benefit.name.toLowerCase())
          .includes(benefit.toLowerCase())
      ) {
        addNewBenefit(benefit);
      } else {
        const _benefit = benefitSuggestions.find((currBenefit) => {
          return currBenefit.name.toLowerCase() === benefit.toLowerCase();
        });
        addBenefitFromList(_benefit.id);
      }
    }
  };

  const addBenefitOnClick = (e) => {
    const id = parseInt(e.target.id.split("::")[0]);
    addBenefitFromList(id);
  };

  if (loading) return <LoaderSpinner />;
  if (error) return <p>{error.message}</p>;
  return (
    <div className="card">
      <div className="card__container">
        <div className="card__inner">
          <div className="card__main">
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
                <InputField
                  type="text"
                  label="Name"
                  value={generalInfo.name}
                  size="small"
                  onChange={(e) =>
                    setGeneralInfo({
                      ...generalInfo,
                      name: e.target.value,
                    })
                  }
                />
                <InputField
                  type="text"
                  label="Company"
                  value={generalInfo.company.name}
                  size="small"
                  onChange={(e) =>
                    setGeneralInfo({
                      ...generalInfo,
                      company: {
                        ...generalInfo.company,
                        name: e.target.value,
                      },
                    })
                  }
                />
                <TextArea
                  label="Description"
                  value={generalInfo.description}
                  size="small"
                  onChange={(e) =>
                    setGeneralInfo({
                      ...generalInfo,
                      description: e.target.value,
                    })
                  }
                ></TextArea>
                <Button fullWidth onClick={updateGeneralInfo}>
                  Save
                </Button>
              </div>
            </div>
          </div>
          {qualifications && qualifications.length > 0 ? (
            <div className="features">
              <h3 className="features__heading">Qualifications</h3>
              <ul className="features__list">
                {qualifications.map((qualification) => (
                  <li key={qualification.id} className="features__item">
                    {qualification.name}
                  </li>
                ))}
                <li className="features__item">
                  <input
                    value={qualification}
                    onChange={(e) => setQualification(e.target.value)}
                    onKeyPress={(e) => addQualificationOnKeyPress(e)}
                    className="features__input"
                  />
                  {qualificationSuggestions.length > 0 ? (
                    <ul className="features__suggestions">
                      {qualificationSuggestions.map((suggestion) => (
                        <li key={suggestion.id}>
                          <button
                            id={`${suggestion.id}::${suggestion.name}`}
                            onClick={(e) => addQualificationOnClick(e)}
                          >
                            {suggestion.name}
                          </button>
                        </li>
                      ))}
                    </ul>
                  ) : null}
                </li>
              </ul>
            </div>
          ) : null}
          {benefits && benefits.length > 0 ? (
            <div className="features">
              <h3 className="features__heading">Benefits</h3>
              <ul className="features__list">
                {benefits.map((benefit) => (
                  <li key={benefit.id} className="features__item">
                    {benefit.name}
                  </li>
                ))}
                <li className="features__item">
                  <input
                    value={benefit}
                    onChange={(e) => setBenefit(e.target.value)}
                    onKeyPress={(e) => addBenefitOnKeyPress(e)}
                    className="features__input"
                  />
                  {benefitSuggestions.length > 0 ? (
                    <ul className="features__suggestions">
                      {benefitSuggestions.map((suggestion) => (
                        <li key={suggestion.id}>
                          <button
                            id={`${suggestion.id}::${suggestion.name}`}
                            onClick={(e) => addBenefitOnClick(e)}
                          >
                            {suggestion.name}
                          </button>
                        </li>
                      ))}
                    </ul>
                  ) : null}
                </li>
              </ul>
            </div>
          ) : null}
        </div>
      </div>
    </div>
  );
};

export default ProjectCardEditable;
