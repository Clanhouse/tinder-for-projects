import { useKeycloak } from "@react-keycloak/web";
import React from "react";
import NoPermission from "./NoPermission";

const Protected = ({ children }) => {
  const { keycloak } = useKeycloak();
  const isLogged = keycloak.authenticated;

  return isLogged ? children : <NoPermission />;
};

export default Protected;
