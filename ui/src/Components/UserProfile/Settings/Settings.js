import React from "react";
import Darkmode from "../Darkmode/Darkmode";
import Language from "../Language/Language";


const Settings = (props) => {
    return (
        <div>
            <Language language={props.language} />
            <Darkmode />
        </div>
    );
}

export default Settings