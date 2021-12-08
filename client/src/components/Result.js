import { useState, useEffect } from "react";
import SearchDataService from "../services/search";
// import { Link } from "react-router-dom";

const Personnel = (props) => {
  // console.log("isAuth [officer.js]: " + props.isAuth);
  // console.log("database: " + props.database);
  const database = props.database;

  const initialPersonnelState = {
    id: null,
    surname: null,
    first: null,
    middle: null,
    dob: null,
    dod: null,
    serial: null,
    assignments: [],
    promotions: [],
    events: [],
  };

  const [personnel, setPersonnel] = useState(initialPersonnelState);
  console.log(personnel);

  useEffect(() => {
    const getPersonnel = (id) => {
      SearchDataService.get(id, database)
        .then((response) => {
          setPersonnel(response.data);
          console.log(response.data);
        })
        .catch((err) => {
          console.error(err);
        });
    };

    getPersonnel(props.match.params.id);
  }, [props.match.params.id, database]);

  return (
    <>
      {personnel ? (
        <div>
          {personnel.surname && <h5>{personnel.surname}</h5>}
          {personnel.first && <h6>{personnel.first}</h6>}
          {personnel.middle && <h6>{personnel.middle}</h6>}
          <h6>{personnel.serial}</h6>
          <p>
            {personnel.dob && (
              <>
                <strong>Date of Birth: </strong>
                {personnel.dob.slice(0, 10)}
                <br />
              </>
            )}
            {personnel.dod && (
              <>
                <strong>Date of Death: </strong>
                {personnel.dod.slice(0, 10)}
                <br />
              </>
            )}
          </p>
        </div>
      ) : (
        <div>
          <br />
          <p>No Information Found</p>
        </div>
      )}
    </>
  );
};

export default Personnel;