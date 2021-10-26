import React from "react";
import Name from "../Name/Name";
import Email from "../Email/Email";
import Phone from "../Phone/Phone";


const AccountSettings = (props) => {
    return (
        <div>
            <Name name={props.name} setIsName={props.setIsName}/>
            <Email email={props.email} setIsEmail={props.setIsEmail}/>
            <Phone phone={props.phone} setIsPhone={props.setIsPhone}/>
        </div>
    );
}

export default AccountSettings