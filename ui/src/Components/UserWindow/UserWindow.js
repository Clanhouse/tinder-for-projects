import React, { useState } from "react";
import Dashboard from "../Dashboard/Dashboard";
import UserWindowMenu from "./UserWindowMenu/UserWindowMenu";
import { PopupProvider, PopupWrapper } from "../Popup/Popup";
import { ActiveConversationProvider } from "../../Contexts/ActiveConversation";
import Conversations from "../Conversations/Conversations";
import "./UserWindow.css";

const UserWindow = ({ cardComponent }) => {
  const [dashboardState, setdashboardState] = useState("connections");
  const Card = cardComponent;
  return (
    <PopupProvider>
      <ActiveConversationProvider>
        <PopupWrapper>
          <div className="user-window">
            <div className="user-window__aside">
              <UserWindowMenu
                dashboardState={dashboardState}
                setdashboardState={setdashboardState}
              />
              <Dashboard dashboardState={dashboardState} />
            </div>
            <div className="user-window__main">
              {dashboardState === "conversations" ? (
                <Conversations />
              ) : (
                <Card />
              )}
            </div>
          </div>
        </PopupWrapper>
      </ActiveConversationProvider>
    </PopupProvider>
  );
};

export default UserWindow;
