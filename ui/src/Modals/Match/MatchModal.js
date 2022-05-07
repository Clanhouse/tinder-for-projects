import React from "react";
import Modal from "react-responsive-modal";
import "react-responsive-modal/styles.css";
import "./MatchModal.css";

const MatchModal = ({ open, setOpen, user, generalInfo }) => {
  const onCloseModal = () => setOpen(false);
  console.log("Modal user: ", user);
  console.log("Modal card: ", generalInfo);
  return (
    <div className="matchmodal__container">
      <Modal open={open} onClose={onCloseModal} center>
        <div className="matchmodal__container">
          <div className="matchmodal__header">
            <p>It's a Match!</p>
            <p>
              You and{" "}
              {user?.role === "developer"
                ? `${user?.role}`
                : `${generalInfo?.firstName}`}{" "}
              have liked each other.
            </p>
            <div className="header__images">
              {/*}    <img
                src={}
                alt={}
              />
  <img />*/}
            </div>
          </div>
        </div>
      </Modal>
    </div>
  );
};

export default MatchModal;
