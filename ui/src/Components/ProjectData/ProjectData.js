import React from "react";
import "./ProjectData.css";
import ProjectName from "./ProjectName/ProjectName";
import ProjectOwner from "./ProjectOwner/ProjectOwner";
import ProjectDescription from "./ProjectDescription/ProjectDescription";
import DeveloperCardLogo from "./DeveloperCardLogo/DeveloperCardLogo";

const dummyData = {
  logo: "http://shezannj.com/wp-content/uploads/2019/01/dummy-logo-png-7.png",
  name: "Trauma APP",
  owner: "Trauma Team International",
  description:
    "We are looking for an experienced full-stack web developer, who helps us improve our Trauma App. New functionalities will allow Trauma paramedics to respond even faster to our client's every sudden emergency.",
};

const ProjectData = () => {
  return (
    <div className="projectData">
      <div className="projectData__logo">
        <DeveloperCardLogo logo={dummyData.logo} />
      </div>
      <div className="projectData__div">
        <ProjectName projectName={dummyData.name} />
        <ProjectOwner projectOwner={dummyData.owner} />
        <ProjectDescription projectDescription={dummyData.description} />
      </div>
    </div>
  );
};

export default ProjectData;
