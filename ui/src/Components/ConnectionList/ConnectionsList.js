import axios from "axios";
import React, { useEffect, useState } from "react";
import { useActiveCard } from "../../Contexts/ActiveCard";
import { useCardData } from "../../Hooks/useCardData";
import { useUser } from "../../Hooks/useUser";
import { PopupMenu, PopupScrollHandler } from "../Popup/Popup";
import ConnectionsItem from "./ConnectionsItem/ConnectionsItem";
import "./ConnectionsList.css";

const ConnectionsList = ({
  updateConnectionsList,
  setUpdateConnectionsList,
}) => {
  const [connections, setConnections] = useState([]);
  const [error, setError] = useState("");
  const { activeCard } = useActiveCard();
  const { user } = useUser();
  const { generalInfo } = useCardData(activeCard, "developers");

  function fetchMatches() {
    user.role === "developer"
      ? axios
          .get(`${process.env.REACT_APP_API}/match/projects/${user.id}`)
          .then(function (response) {
            setConnections(response.data);
          })
          .catch(function (error) {
            console.log(error);
            setError(error);
          })
      : axios
          .get(`${process.env.REACT_APP_API}/match/developers/${user.id}`)
          .then(function (response) {
            setConnections(response.data);
          })
          .catch(function (error) {
            console.log(error);
            setError(error);
          });
  }

  useEffect(() => {
    fetchMatches();
  }, []);

  useEffect(() => {
    fetchMatches();
  }, [updateConnectionsList]);

  return (
    <PopupScrollHandler>
      <PopupMenu>
        <li className="popup-menu__item">Start chat</li>
        <li className="popup-menu__item">Delete contact</li>
      </PopupMenu>
      <div className="connections">
        {connections.length > 0 ? (
          <ul className="connections__list">
            {connections &&
              connections.map((connection) => (
                <ConnectionsItem key={connection.id} connection={connection} />
              ))}
          </ul>
        ) : (
          <div className="connections__empty">
            <p>
              You don't have any connections yet. Add new connection you are
              interested in by clicking the thumb-up.
            </p>
          </div>
        )}
      </div>
    </PopupScrollHandler>
  );
};

export default ConnectionsList;
