import React from "react";
import { nanoid } from "nanoid";
import {
  BasicStorage,
  ChatProvider,
  AutoDraft,
  IStorage,
  UpdateState,
} from "@chatscope/use-chat";
import { ExampleChatService } from "@chatscope/use-chat/dist/examples";

// Storage needs to generate id for messages and groups
const messageIdGenerator = () => nanoid();
const groupIdGenerator = () => nanoid();

// Create serviceFactory
const serviceFactory = (storage, updateState) => {
  return new ExampleChatService(IStorage, UpdateState);
};

const chatStorage = new BasicStorage({ groupIdGenerator, messageIdGenerator });

export const ConversationsProvider = ({ children }) => {
  console.log(chatStorage);
  return (
    <ChatProvider
      serviceFactory={serviceFactory}
      storage={chatStorage}
      config={{
        typingThrottleTime: 250,
        typingDebounceTime: 900,
        debounceTyping: true,
        autoDraft: AutoDraft.Save | AutoDraft.Restore,
      }}
    >
      {children}
    </ChatProvider>
  );
};
