import axios from "axios";
import { useState, useEffect } from "react";
import { useActiveCard } from "../Contexts/ActiveCard";

export const useDeveloperCard = (userId) => {
  const [generalInfo, setGeneralInfo] = useState(null);
  const [skills, setSkills] = useState(null);
  const [skill, setSkill] = useState("");
  const [skillSuggestions, setSkillSuggestions] = useState([]);
  const [achievements, setAchievements] = useState(null);
  const [achievement, setAchievement] = useState("");
  const [achievementSuggestions, setAchievementSuggestions] = useState([]);
  const { selectCard, activeCard } = useActiveCard();
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  const createSuggestions = (string, array) => {
    return array.filter((obj) =>
      obj.name.toLowerCase().includes(string.toLowerCase())
    );
  };

  const getCardData = async (id) => {
    setLoading(true);
    try {
      const result = id
        ? await axios.get(`${process.env.REACT_APP_API}/developers/${id}`)
        : await axios.get(`${process.env.REACT_APP_API}/developers/random`);
      setGeneralInfo({
        firstName: result.data.firstName,
        lastName: result.data.lastName,
        description: result.data.description,
        profession: result.data.profession,
        photos: result.data.photos,
      });
      setSkills(result.data.skills);
      setAchievements(result.data.achievements);
    } catch (err) {
      setError(err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    getCardData(userId || activeCard);
  }, [userId, activeCard]);

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
      `${process.env.REACT_APP_API}/developers/${userId}/personal`,
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
      `${process.env.REACT_APP_API}/developers/${userId}/skills`,
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
      `${process.env.REACT_APP_API}/developers/${userId}/skills`,
      newSkills
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
      `${process.env.REACT_APP_API}/developers/${userId}/achievements`,
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
      `${process.env.REACT_APP_API}/developers/${userId}/achievements`,
      newAchievements
    );
  };

  return {
    generalInfo,
    skill,
    skills,
    skillSuggestions,
    achievement,
    achievements,
    achievementSuggestions,
    error,
    loading,
    getCardData,
    setGeneralInfo,
    setSkill,
    setAchievement,
    updateGeneralInfo,
    addSkillFromList,
    addNewSkill,
    addAchievementFromList,
    addNewAchievement
  };
};
