import React, { useContext, useState } from "react";
import { ThemeContext } from "../../../Contexts/ThemeContext";
import { ReactComponent as SwitchButton } from "../../../Data/Images/switch-button.svg";
import Toggle from "react-toggle";
import "react-toggle/style.css";

const Darkmode = () => {
  const { theme, setTheme } = useContext(ThemeContext);
  const [toggle, setToggle] = useState(false);

  const handleThemeToggle = (e) => {
    console.log(theme);
    e.preventDefault();
    setTheme(theme === "light" ? "dark" : "light");
    setToggle(!toggle);
  };
  return (
    <div className="profile--item">
      Dark-mode
      <div className="profile--item--right" onClick={handleThemeToggle}>
        {/* <SwitchButton /> */}
        <label>
          <Toggle checked={toggle} icons={false} onChange={handleThemeToggle} />
        </label>
      </div>
    </div>
  );
};

export default Darkmode;
