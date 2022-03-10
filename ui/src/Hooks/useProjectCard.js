import axios from "axios";
import { useState, useEffect } from "react";
import { useActiveCard } from "../Contexts/ActiveCard";
import { useUser } from "./useUser";

export const useProjectCard = (projectId) => {
  const { user } = useUser();
  const [generalInfo, setGeneralInfo] = useState(null);
  const [qualifications, setQualifications] = useState(null);
  const [qualification, setQualification] = useState("");
  const [qualificationSuggestions, setQualificationSuggestions] = useState([]);
  const [benefits, setBenefits] = useState(null);
  const [benefit, setBenefit] = useState("");
  const [benefitSuggestions, setBenefitsuggestions] = useState([]);
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
        ? await axios.get(`${process.env.REACT_APP_API}/projects/${id}`)
        : await axios.get(`${process.env.REACT_APP_API}/projects/random/${user.id}`);
      setGeneralInfo({
        name: result.data.name,
        description: result.data.description,
        company: result.data.company.name,
        photos: result.data.photos,
      });
      setQualifications(result.data.skills);
      setBenefits(result.data.benefits);
    } catch (err) {
      setError(err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    getCardData(projectId || activeCard);
  }, [projectId, activeCard]);

  useEffect(() => {
    const fetchQualifications = async () => {
      try {
        const result = await axios.get(`${process.env.REACT_APP_API}/skills`);
        return result.data;
      } catch (err) {
        setError(err);
      }
    };

    const getQualificationSuggestions = async () => {
      const qualifications = await fetchQualifications();
      const qualificationSuggestions = createSuggestions(
        qualification,
        qualifications
      );
      setQualificationSuggestions(qualificationSuggestions);
    };

    if (qualification) {
      getQualificationSuggestions();
    } else {
      setQualificationSuggestions([]);
    }
  }, [qualification]);

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

  const updateGeneralInfo = async () => {
    await axios.put(
      `${process.env.REACT_APP_API}/projects/${projectId}/basic`,
      generalInfo
    );
  };

  const addQualificationFromList = async (qualificationId) => {
    if (
      qualifications.some(
        (qualification) => qualification.id === qualificationId
      )
    ) {
      setQualificationSuggestions([]);
      setQualification("");
      return;
    }
    const result = await axios.get(
      `${process.env.REACT_APP_API}/skills/${qualificationId}`
    );
    const newQualifications = [...qualifications, result.data];
    setQualificationSuggestions([]);
    setQualification("");
    await setQualifications(newQualifications);
    await axios.put(
      `${process.env.REACT_APP_API}/projects/${projectId}/skills`,
      newQualifications
    );
  };

  const addNewQualification = async (qualification) => {
    const _qualification = qualification.trim();
    if (
      qualifications.some(
        (qualification) =>
          qualification.name.toLowerCase() === _qualification.toLowerCase()
      )
    ) {
      setQualificationSuggestions([]);
      setQualification("");
      return;
    }
    const newQualification = { name: _qualification };
    const newQualifications = [...qualifications, newQualification];
    setQualificationSuggestions([]);
    setQualification("");
    await setQualifications(newQualifications);
    await axios.put(
      `${process.env.REACT_APP_API}/projects/${projectId}/skills`,
      newQualifications
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
      `${process.env.REACT_APP_API}/projects/${projectId}/benefits`,
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
      `${process.env.REACT_APP_API}/developers/${projectId}/benefits`,
      newBenefits
    );
  };

  return {
    generalInfo,
    qualification,
    qualifications,
    qualificationSuggestions,
    benefit,
    benefits,
    benefitSuggestions,
    error,
    loading,
    getCardData,
    setGeneralInfo,
    setQualification,
    setBenefit,
    updateGeneralInfo,
    addQualificationFromList,
    addNewQualification,
    addBenefitFromList,
    addNewBenefit,
  };
};
