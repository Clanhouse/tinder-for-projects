import React from "react";
import "./ProjectData.css";
import ProjectName from "./ProjectName/ProjectName";
import ProjectOwner from "./ProjectOwner/ProjectOwner";
import ProjectDescription from "./ProjectDescription/ProjectDescription";

const dummyData = {
  name: "Trauma APP",
  owner: "Trauma Team International",
  description:
    "We are looking for an experienced full-stack web developer, who helps us improve our Trauma App. New functionalities will allow Trauma paramedics to respond even faster to our client's every sudden emergency.",
};

const ProjectData = () => {
  return (
    <div className="projectData__div">
      <ProjectName projectName={dummyData.name} />
      <ProjectOwner projectOwner={dummyData.owner} />
      <ProjectDescription projectDescription={dummyData.description} />
      </div>
  );
};

export default ProjectData;