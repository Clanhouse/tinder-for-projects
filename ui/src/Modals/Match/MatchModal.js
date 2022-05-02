import React from "react";
import Modal from "react-responsive-modal";
import "react-responsive-modal/styles.css";
import "./MatchModal.css";

const MatchModal = ({ open, setOpen, user, card }) => {
  const onCloseModal = () => setOpen(false);
  return (
    <div className="matchmodal__container">
      <Modal open={open} onClose={onCloseModal} center>
        <div className="matchmodal__container">
          {/*}  <div>
            <div className="header__image">
              <img
                src={}
                alt={}
              />
  </div> 
            </div>*/}
        </div>
      </Modal>
    </div>
  );
};

export default MatchModal;
