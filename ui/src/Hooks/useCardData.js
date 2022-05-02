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
          firstName: result.data.firstName || null,
          lastName: result.data.lastName || null,
          name: result.data.name || null,
          description: result.data.description || null,
          profession: result.data.profession || null,
          company: (result.data.company && result.data.company.name) || null,
          photos: result.data.photos || null,
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

  useEffect(() => {
    getCardData(cardId || activeCard);
  }, [cardId, activeCard, getCardData]);

  useEffect(() => {
    const fetchSkills = async () => {
      try {
        const result = await axios.get(`${process.env.REACT_APP_API}/skills`);
        return result.data;
      } catch (err) {
        setError(err);
      }
    };

    const getSkillSuggestions = async () => {
      const skills = await fetchSkills();
      const skillsSuggestions = createSuggestions(skill, skills);
      setSkillSuggestions(skillsSuggestions);
    };

    if (skill) {
      getSkillSuggestions();
    } else {
      setSkillSuggestions([]);
    }
  }, [skill]);

  useEffect(() => {
    const fetchBenefits = async () => {
      try {
        const result = await axios.get(`${process.env.REACT_APP_API}/benefits`);
        return result.data;
      } catch (err) {
        setError(err);
      }
    };

    const getbenefitSuggestions = async () => {
      const benefits = await fetchBenefits();
      const benefitSuggestions = createSuggestions(benefit, benefits);
      setBenefitsuggestions(benefitSuggestions);
    };
    if (benefit) {
      getbenefitSuggestions();
    } else {
      setBenefitsuggestions([]);
    }
  }, [benefit]);

  useEffect(() => {
    const fetchAchievements = async () => {
      try {
        const result = await axios.get(
          `${process.env.REACT_APP_API}/achievements`
        );
        return result.data;
      } catch (err) {
        setError(err);
      }
    };

    const getAchievementSuggestions = async () => {
      const achievements = await fetchAchievements();
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
  }, [achievement]);

  const updateGeneralInfo = async () => {
    await axios.put(
      `${process.env.REACT_APP_API}/${cardType}/${cardId}/basic`,
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
