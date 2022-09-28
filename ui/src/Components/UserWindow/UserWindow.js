import React, { useState } from "react";
import Dashboard from "../Dashboard/Dashboard";
import UserWindowMenu from "./UserWindowMenu/UserWindowMenu";
import ProjectCard from "../Card/ProjectCard";
import DeveloperCard from "../Card/DeveloperCard";
import ProjectCardEditable from "../Card/ProjectCardEditable";
import DeveloperCardEditable from "../Card/DeveloperCardEditable";
import { PopupProvider, PopupWrapper } from "../Popup/Popup";
import { ActiveConversationProvider } from "../../Contexts/ActiveConversation";
import Conversations from "../Conversations/Conversations";
import "./UserWindow.css";

const UserWindow = ({ user }) => {
  const [dashboardState, setDashboardState] = useState("connections");
  const [userEditMode, setUserEditMode] = useState(false);
  const [updateConnectionsList, setUpdateConnectionsList] = useState(false);

  let cardComponent = null;
  if (user.role === "developer") {
    cardComponent = userEditMode ? (
      <DeveloperCardEditable user={user} />
    ) : (
      <ProjectCard
        updateConnectionsList={updateConnectionsList}
        setUpdateConnectionsList={setUpdateConnectionsList}
      />
    );
  }
  if (user.role === "project") {
    cardComponent = userEditMode ? (
      <ProjectCardEditable user={user} />
    ) : (
      <DeveloperCard
        updateConnectionsList={updateConnectionsList}
        setUpdateConnectionsList={setUpdateConnectionsList}
      />
    );
  }
  return (
    <PopupProvider>
      <PopupWrapper>
        <div className="user-window">
          <aside className="user-window__aside">
            <UserWindowMenu
              dashboardState={dashboardState}
              setdashboardState={setDashboardState}
              setUserEditMode={setUserEditMode}
            />
            <Dashboard
              dashboardState={dashboardState}
              updateConnectionsList={updateConnectionsList}
              setUpdateConnectionsList={setUpdateConnectionsList}
            />{" "}
          </aside>
          <main className="user-window__main">{cardComponent}</main>
        </div>
      </PopupWrapper>
    </PopupProvider>
  );
};

export default UserWindow;
