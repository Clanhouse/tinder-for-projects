import React, { useState } from "react";
import { useHistory } from "react-router";
import { Link } from "react-router-dom";
import { useUser } from "../../Hooks/useUser";
import InputField from "../Form/InputField/InputField";
import CheckboxField from "../Form/CheckboxField/CheckboxField";
import Button from "../Button/Button";
import AltSigning from "../AltSigning/AltSigning";
import "./SignIn.css";
import axios from "axios";
import { useKeycloak } from "@react-keycloak/web";

const SignIn = () => {
  const { setUser } = useUser();
  const [userData, setUserData] = useState({
    email: "",
    password: "",
  });
  const { keycloak } = useKeycloak();
  let refresh_token = "";

  const history = useHistory();

  const handleSubmit = (e) => {
    console.log("userData: ", userData);
    e.preventDefault();
    const params = new URLSearchParams();
    params.append("client_id", "tfp-app");
    params.append("username", `${userData.email}`);
    params.append("password", `${userData.password}`);
    params.append("grant_type", "password");
    axios
      .post(
        "https://unicorn-auth.cytr.us/auth/realms/dev/protocol/openid-connect/token",
        params
      )
      .then(function (response) {
        console.log("response - 1: ", response.data);
        refresh_token = response.data.refresh_token;
        localStorage.setItem("token", response.data.access_token);
        console.log("localStorage - 1: ", localStorage.getItem("token"));
      })
      .catch(function (error) {
        console.log(error);
      });

    const params_token = new URLSearchParams();
    params_token.append("client_id", "tfp-app");
    params_token.append("grant_type", "refresh_token");
    params_token.append("refresh_token", `${refresh_token}`);
    axios
      .post(
        "https://unicorn-auth.cytr.us/auth/realms/dev/protocol/openid-connect/token",
        params_token
      )
      .then(function (response) {
        console.log("response - 2: ", response.data);
        localStorage.setItem("token", response.data.access_token);
        console.log("localStorage-2: ", localStorage.getItem("token"));
      })
      .catch(function (error) {
        console.log(error);
      });

    //TODO: id to change
    setUser({ role: "developer", id: 5 });
    history.push("/");
    console.log("logged in: ", keycloak.authenticated);
  };
  return (
    <div className="signin">
      <div className="signin__container">
        <form className="signin__form" onSubmit={handleSubmit}>
          <InputField
            name="email"
            label="Email"
            type="email"
            value={userData.email}
            onChange={(e) =>
              setUserData({ ...userData, email: e.target.value })
            }
          />
          <InputField
            name="password"
            label="Password"
            type="password"
            value={userData.password}
            onChange={(e) =>
              setUserData({ ...userData, password: e.target.value })
            }
          />
          <div className="signin__group">
            <CheckboxField name="terms" label="Remember me" />
            <a href="/">Forgot Password?</a>
          </div>
          <Button size="small" fullWidth>
            Sign In
          </Button>
        </form>
        <p>or use</p>
        <AltSigning />
        <p>
          Don’t have an account? <Link to="/signup">Create new one</Link>
        </p>
      </div>
    </div>
  );
};

export default SignIn;
