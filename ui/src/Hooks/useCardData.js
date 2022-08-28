import axios from "axios";
import { useState, useEffect, useCallback } from "react";
import { useActiveCard } from "../Contexts/ActiveCard";
import { useUser } from "./useUser";

export const useCardData = (cardId, cardType) => {
  const { user } = useUser();
  const [generalInfo, setGeneralInfo] = useState(null);
  const [skills, setSkills] = useState(null);
  const [skill, setSkill] = useState("");
  const [skillSuggestions, setSkillSuggestions] = useState([]);
  const [benefits, setBenefits] = useState(null);
  const [benefit, setBenefit] = useState("");
  const [benefitSuggestions, setBenefitsuggestions] = useState([]);
  const [achievements, setAchievements] = useState(null);
  const [achievement, setAchievement] = useState("");
  const [achievementSuggestions, setAchievementSuggestions] = useState([]);
  const { activeCard } = useActiveCard();
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  const createSuggestions = (string, array) => {
    return array.filter((obj) =>
      obj.name.toLowerCase().includes(string.toLowerCase())
    );
  };

  const getCardData = useCallback(
    async (id) => {
      setLoading(true);
      try {
        const result = id
          ? await axios.get(`${process.env.REACT_APP_API}/${cardType}/${id}`)
          : await axios.get(
              `${process.env.REACT_APP_API}/${cardType}/random/${user.id}`
            );
        setGeneralInfo({
          id: result.data.id || 0,
          firstName: result.data.firstName || "",
          lastName: result.data.lastName || "",
          name: result.data.name || "",
          description: result.data.description || "",
          profession: result.data.profession || "",
          company: result.data.company || "",
          photos: result.data.photos || "",
        });
        setSkills(result.data.skills || null);
        setBenefits(result.data.benefits || null);
        setAchievements(result.data.achievements);
      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    },
    [cardType, user.id]
  );

  const fetchFeatures = useCallback(async (type) => {
    try {
      const result = await axios.get(`${process.env.REACT_APP_API}/${type}`);
      return result.data;
    } catch (err) {
      setError(err.message);
    }
  }, []);

  useEffect(() => {
    getCardData(cardId || activeCard);
  }, [cardId, activeCard, getCardData]);

  useEffect(() => {
    const getSkillSuggestions = async () => {
      const skills = await fetchFeatures("skills");
      const skillsSuggestions = createSuggestions(skill, skills);
      setSkillSuggestions(skillsSuggestions);
    };

    if (skill) {
      getSkillSuggestions();
    } else {
      setSkillSuggestions([]);
    }
  }, [skill, fetchFeatures]);

  useEffect(() => {
    const getbenefitSuggestions = async () => {
      const benefits = await fetchFeatures("benefits");
      const benefitSuggestions = createSuggestions(benefit, benefits);
      setBenefitsuggestions(benefitSuggestions);
    };
    if (benefit) {
      getbenefitSuggestions();
    } else {
      setBenefitsuggestions([]);
    }
  }, [benefit, fetchFeatures]);

  useEffect(() => {
    const getAchievementSuggestions = async () => {
      const achievements = await fetchFeatures("achievements");
      const achievementSuggestions = createSuggestions(
        achievement,
        achievements
      );
      setAchievementSuggestions(achievementSuggestions);
    };
    if (achievement) {
      getAchievementSuggestions();
    } else {
      setAchievementSuggestions([]);
    }
  }, [achievement, fetchFeatures]);

  const updateGeneralInfo = async () => {
    await axios.put(
      `${process.env.REACT_APP_API}/${cardType}/${cardId}/general`,
      generalInfo
    );
  };

  const addSkillFromList = async (skillId) => {
    if (skills.some((skill) => skill.id === skillId)) {
      setSkillSuggestions([]);
      setSkill("");
      return;
    }
    const result = await axios.get(
      `${process.env.REACT_APP_API}/skills/${skillId}`
    );
    const newSkills = [...skills, result.data];
    setSkillSuggestions([]);
    setSkill("");
    await setSkills(newSkills);
    await axios.put(
      `${process.env.REACT_APP_API}/${cardType}/${cardId}/skills`,
      newSkills
    );
  };

  const addNewSkill = async (skill) => {
    const _skill = skill.trim();
    if (
      skills.some((skill) => skill.name.toLowerCase() === _skill.toLowerCase())
    ) {
      setSkillSuggestions([]);
      setSkill("");
      return;
    }
    const newSkill = { name: _skill };
    const newSkills = [...skills, newSkill];
    setSkillSuggestions([]);
    setSkill("");
    await setSkills(newSkills);
    await axios.put(
      `${process.env.REACT_APP_API}/${cardType}/${cardId}/skills`,
      newSkills
    );
  };

  const addBenefitFromList = async (benefitId) => {
    if (benefits.some((benefit) => benefit.id === benefitId)) {
      setBenefitsuggestions([]);
      setBenefit("");
      return;
    }
    const result = await axios.get(
      `${process.env.REACT_APP_API}/benefits/${benefitId}`
    );
    const newBenefits = [...benefits, result.data];
    setBenefitsuggestions([]);
    setBenefit("");
    await setBenefits(newBenefits);
    await axios.put(
      `${process.env.REACT_APP_API}/${cardType}/${cardId}/benefits`,
      newBenefits
    );
  };

  const addNewBenefit = async (benefit) => {
    const _benefit = benefit.trim();
    if (
      benefits.some(
        (benefit) => benefit.name.toLowerCase() === _benefit.toLowerCase()
      )
    ) {
      setBenefitsuggestions([]);
      setBenefit("");
      return;
    }
    const newBenefit = { name: _benefit };
    const newBenefits = [...benefits, newBenefit];
    setBenefitsuggestions([]);
    setBenefit("");
    await setBenefits(newBenefits);
    await axios.put(
      `${process.env.REACT_APP_API}/${cardType}/${cardId}/benefits`,
      newBenefits
    );
  };

  const addAchievementFromList = async (achievementId) => {
    if (achievements.some((achievement) => achievement.id === achievementId)) {
      setAchievementSuggestions([]);
      setAchievement("");
      return;
    }
    const result = await axios.get(
      `${process.env.REACT_APP_API}/achievements/${achievementId}`
    );
    const newAchievements = [...achievements, result.data];
    setAchievementSuggestions([]);
    setAchievement("");
    await setAchievements(newAchievements);
    await axios.put(
      `${process.env.REACT_APP_API}/developers/${cardId}/achievements`,
      newAchievements
    );
  };

  const addNewAchievement = async (achievement) => {
    const _achievement = achievement.trim();
    if (
      achievements.some(
        (achievement) =>
          achievement.name.toLowerCase() === _achievement.toLowerCase()
      )
    ) {
      setAchievementSuggestions([]);
      setAchievement("");
      return;
    }
    const newAchievement = { name: _achievement };
    const newAchievements = [...achievements, newAchievement];
    setAchievementSuggestions([]);
    setAchievement("");
    await setAchievements(newAchievements);
    await axios.put(
      `${process.env.REACT_APP_API}/developers/${cardId}/achievements`,
      newAchievements
    );
  };

  return {
    generalInfo,
    skill,
    skills,
    skillSuggestions,
    benefit,
    benefits,
    benefitSuggestions,
    achievement,
    achievements,
    achievementSuggestions,
    error,
    loading,
    getCardData,
    setGeneralInfo,
    setSkill,
    setBenefit,
    setAchievement,
    updateGeneralInfo,
    addSkillFromList,
    addNewSkill,
    addBenefitFromList,
    addNewBenefit,
    addAchievementFromList,
    addNewAchievement,
  };
};
