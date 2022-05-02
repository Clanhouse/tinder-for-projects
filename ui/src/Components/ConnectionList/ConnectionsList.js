import axios from "axios";
import React, { useEffect, useState } from "react";
import { useUser } from "../../Hooks/useUser";
import { PopupMenu, PopupScrollHandler } from "../Popup/Popup";
import ConnectionsItem from "./ConnectionsItem/ConnectionsItem";
import "./ConnectionsList.css";
{
  /*
const data = [
  {
    id: "1",
    name: "Julia Williams",
    picture: "https://randomuser.me/api/portraits/women/67.jpg",
  },
  {
    id: "2",
    name: "Keith Robertson",
    picture: "https://randomuser.me/api/portraits/men/41.jpg",
  },
  {
    id: "3",
    name: "Nadia Mcclean",
    picture: "https://randomuser.me/api/portraits/women/24.jpg",
  },
  {
    id: "4",
    name: "Joseph Perez",
    picture: "https://randomuser.me/api/portraits/men/77.jpg",
  },
  {
    id: "5",
    name: "Christina Dam",
    picture: "https://randomuser.me/api/portraits/women/58.jpg",
  },
  {
    id: "6",
    name: "Julia Williams",
    picture: "https://randomuser.me/api/portraits/women/67.jpg",
  },
  {
    id: "7",
    name: "Keith Robertson",
    picture: "https://randomuser.me/api/portraits/men/41.jpg",
  },
  {
    id: "8",
    name: "Nadia Mcclean",
    picture: "https://randomuser.me/api/portraits/women/24.jpg",
  },
  {
    id: "9",
    name: "Joseph Perez",
    picture: "https://randomuser.me/api/portraits/men/77.jpg",
  },
  {
    id: "10",
    name: "Christina Dam",
    picture: "https://randomuser.me/api/portraits/women/58.jpg",
  },
];
*/
}
const ConnectionsList = () => {
  const [connections, setConnections] = useState([]);
  const [error, setError] = useState("");
  const { user } = useUser();

  function fetchMatches() {
    user.role === "project" ?
    axios
      .get(`${process.env.REACT_APP_API}/match/projects/${user.id}`)
      .then(function (response) {
        console.log("project match: ", response);
        setConnections(response.data);
      })
      .catch(function (error) {
        console.log(error);
        setError(error);
      }) 
      :
      axios
      .get(`${process.env.REACT_APP_API}/match/developers/${user.id}`)
      .then(function (response) {
        console.log("developer match: ", response);
        setConnections(response.data);
      })
      .catch(function (error) {
        console.log(error);
        setError(error);
      })
  }
  useEffect(() => {
    fetchMatches();
  }, []);
  // @ts-ignore
  if (error) return <p className="connections__error-p">{error.message}</p>;
  return (
    <PopupScrollHandler>
      <PopupMenu>
        <li className="popup-menu__item">Start chat</li>
        <li className="popup-menu__item">Delete contact</li>
      </PopupMenu>
      <div className="connections">
        {connections.length > 0 ? (
          <ul className="connections__list">
            {connections && connections.map((connection) => (
              <ConnectionsItem key={connection.id} connection={connection} />
            ))}
          </ul>
        ) : (
          <div className="connection__empty">
            <p className="connections__error-p">
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
