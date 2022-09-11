import React from "react";
import Modal from "react-responsive-modal";
import "./MatchModal.css";
import Button from "../../Components/Button/Button";

const MatchModal = ({ open, setOpen, user, generalInfo, addToConnections }) => {
  const onCloseModal = () => setOpen(false);

  const getName = (user, generalInfo) => {
    if (user.role === "developer") {
      return ` ${generalInfo.name} from ${generalInfo.company.name} `;
    } else {
      return ` ${generalInfo.name} `;
    }
  };
  return (
    <Modal open={open} onClose={onCloseModal} center>
      <div className="matchmodal__container">
        <div className="matchmodal__header">
          <p className="matchmodal__description">It's a Match!</p>
          <p>
            You and {getName(user, generalInfo)}
            {/*}
            {user.role === "developer" ? 
            ` ${generalInfo.name} from ${generalInfo.company.name} ` : ` ${generalInfo.name} `}
  */}
            have liked each other.
          </p>
        </div>

        <div className="matchmodal__header-images">
          {/* TODO: add images */}
          <img
            src="https://randomuser.me/api/portraits/women/67.jpg"
            alt=""
            className="image"
          />
          <img
            src="https://randomuser.me/api/portraits/women/24.jpg"
            alt=""
            className="image"
          />
        </div>
        <div className="matchmodal__container-buttons">
          <Button
            size="small"
            onClick={addToConnections}
            ghost={undefined}
            mobile={undefined}
            fullWidth={true}
            style={undefined}
          >
            OK
          </Button>
        </div>
      </div>
    </Modal>
  );
};
export default MatchModal;