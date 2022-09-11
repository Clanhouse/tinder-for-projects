import React, { useEffect } from "react";
import Navbar from "../Navbar/Navbar";
import Footer from "../Footer/Footer";
import Hero from "./Hero/Hero";
import Section from "./Section/Section";
import Quotes from "./Quotes/Quotes";
import "./LandingPage.css";
import { useKeycloak } from "@react-keycloak/web";
import { useUser } from "../../Hooks/useUser";

const LandingPage = () => {
  const { keycloak } = useKeycloak();
  const { user, setUser } = useUser();

  useEffect(() => {
    // eslint-disable-next-line no-unused-expressions
    keycloak.authenticated
    //TODO: setUser with right data
      ? setUser({ role: "project", id: 3 })
      : setUser(null);
  }, [keycloak.authenticated]);

  return (
    <div className="landing">
      <Navbar />
      <Hero />
      <Section>
        <h2>Testimonials</h2>
        <Quotes />
      </Section>
      <Footer />
    </div>
  );
};

export default LandingPage;
