import React, { useContext } from "react";
import { ActiveConversationContext } from "../../Contexts/ActiveConversation";
import Conversation from "./Conversation/Conversation";
import "./Conversations.css";

const Conversations = () => {
  const { activeConversation } = useContext(ActiveConversationContext);

  return (
    <div className="conversations">
      {activeConversation ? (
        <Conversation conversation={activeConversation} />
      ) : (
        "Select conversation"
      )}
    </div>
  );
};

export default Conversations;
