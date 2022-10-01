import React, { useState } from "react";
import styles from "@chatscope/chat-ui-kit-styles/dist/default/styles.min.css";
import "./Conversation.css";
import {
  ChatContainer,
  ConversationHeader,
  Avatar,
  MessageList,
  Message,
  MessageInput,
} from "@chatscope/chat-ui-kit-react";

const messages = [
  {
    message: "Hello my friend",
    sentTime: "just now",
    sender: "Joe",
    direction: "incoming",
  },
  {
    message: "Lorem...",
    sentTime: "just now",
    sender: "user",
    direction: "outgoing",
  },
];

const Conversation = ({ conversation }) => {
  console.log(conversation);
  const [inputValue, setInputValue] = useState("");
  return (
    <div style={{ width: "100%", height: "100%" }}>
      <ChatContainer>
        <ConversationHeader>
          <Avatar src={conversation.picture} />
          <ConversationHeader.Content
            userName={conversation.name}
            className="test"
          />
        </ConversationHeader>
        <MessageList>
          <Message
            model={{
              message: "Hello my friend",
              sentTime: "just now",
              sender: "Joe",
              direction: "incoming",
            }}
          >
            <Avatar src={conversation.picture} />
          </Message>
        </MessageList>
        <MessageInput
          attachButton={false}
          placeholder="Type message here"
          value={inputValue}
          onChange={(e) => console.log(e)}
          onSend={(e) => {
            console.log("pisze", e);
          }}
        />
      </ChatContainer>
    </div>
  );
};

export default Conversation;
