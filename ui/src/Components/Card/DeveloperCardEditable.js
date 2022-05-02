import React from "react";
import { useDeveloperCard } from "../../Hooks/useDeveloperCard";
import LoaderSpinner from "../LoaderSpinner/LoaderSpinner";
import Button from "../Button/Button";
import InputField from "../Form/InputField/InputField";
import TextArea from "../Form/TextArea/TextArea";

const DeveloperCardEditable = ({ user }) => {
  const {
    generalInfo,
    skill,
    skills,
    skillSuggestions,
    achievement,
    achievements,
    achievementSuggestions,
    error,
    loading,
    setGeneralInfo,
    setSkill,
    setAchievement,
    updateGeneralInfo,
    addSkillFromList,
    addNewSkill,
    addAchievementFromList,
    addNewAchievement,
  } = useDeveloperCard(user.id);

  console.log(generalInfo);

  const addSkillOnKeyPress = (e) => {
    if (e.which === 13 && skill) {
      if (
        !skillSuggestions
          .map((skill) => skill.name.toLowerCase())
          .includes(skill.toLowerCase())
      ) {
        addNewSkill(skill);
      } else {
        const _skill = skillSuggestions.find((currSkill) => {
          return currSkill.name.toLowerCase() === skill.toLowerCase();
        });
        addSkillFromList(_skill.id);
      }
    }
  };

  const addSkillOnClick = (e) => {
    const id = parseInt(e.target.id.split("::")[0]);
    addSkillFromList(id);
  };

  const addAchievementOnKeyPress = (e) => {
    if (e.which === 13 && achievement) {
      if (
        !achievementSuggestions
          .map((achievement) => achievement.name.toLowerCase())
          .includes(achievement.toLowerCase())
      ) {
        addNewAchievement(achievement);
      } else {
        const _achievement = achievementSuggestions.find((currAchievement) => {
          return (
            currAchievement.name.toLowerCase() === achievement.toLowerCase()
          );
        });
        addAchievementFromList(_achievement.id);
      }
    }
  };

  const addAchievementOnClick = (e) => {
    const id = parseInt(e.target.id.split("::")[0]);
    addAchievementFromList(id);
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
                    (generalInfo.photos &&
                      generalInfo.photos.length > 0 &&
                      generalInfo.photos[0].url) ||
                    null
                  }
                  alt={`${generalInfo.firstName} ${generalInfo.lastName}`}
                />
              </div>
              <div className="header__content">
                <InputField
                  type="text"
                  label="First Name"
                  value={generalInfo.firstName}
                  size="small"
                  onChange={(e) =>
                    setGeneralInfo({
                      ...generalInfo,
                      firstName: e.target.value,
                    })
                  }
                />
                <InputField
                  type="text"
                  label="Second Name"
                  value={generalInfo.lastName}
                  size="small"
                  onChange={(e) =>
                    setGeneralInfo({
                      ...generalInfo,
                      lastName: e.target.value,
                    })
                  }
                />
                <InputField
                  type="text"
                  label="Role"
                  value={generalInfo.profession}
                  size="small"
                  onChange={(e) =>
                    setGeneralInfo({
                      ...generalInfo,
                      profession: e.target.value,
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
          {skills.length > 0 ? (
            <div className="features">
              <h3 className="features__heading">Skills</h3>
              <ul className="features__list">
                {skills.map((skill) => (
                  <li key={skill.id} className="features__item">
                    {skill.name}
                  </li>
                ))}
                <li className="features__item">
                  <input
                    value={skill}
                    onChange={(e) => setSkill(e.target.value)}
                    onKeyPress={(e) => addSkillOnKeyPress(e)}
                    className="features__input"
                  />
                  {skillSuggestions.length > 0 ? (
                    <ul className="features__suggestions">
                      {skillSuggestions.map((suggestion) => (
                        <li key={suggestion.id}>
                          <button
                            id={`${suggestion.id}::${suggestion.name}`}
                            onClick={(e) => addSkillOnClick(e)}
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
          {achievements.length > 0 ? (
            <div className="features">
              <h3 className="features__heading">Achievements</h3>
              <ul className="features__list">
                {achievements.map((achievement) => (
                  <li key={achievement.id} className="features__item">
                    {achievement.name}
                  </li>
                ))}
                <li className="features__item">
                  <input
                    value={achievement}
                    onChange={(e) => setAchievement(e.target.value)}
                    onKeyPress={(e) => addAchievementOnKeyPress(e)}
                    className="features__input"
                  />
                  {achievementSuggestions.length > 0 ? (
                    <ul className="features__suggestions">
                      {achievementSuggestions.map((suggestion) => (
                        <li key={suggestion.id}>
                          <button
                            id={`${suggestion.id}::${suggestion.name}`}
                            onClick={(e) => addAchievementOnClick(e)}
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

export default DeveloperCardEditable;
