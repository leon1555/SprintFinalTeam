import { useState } from "react";
import SearchDataService from "../services/search";
import { Link } from "react-router-dom";
import { v4 as uuidv4 } from "uuid"; // then use uuidv4() to insert id

function Search({ isAuth, userId, admin, setDatabase, database }) {
  const [personnel, setPersonnel] = useState([]);
  const [searchName, setSearchName] = useState("");
  // const [currentUserId, setCurrentUserId] = useState(userId);

  // let PORT = 8000;

  // console.log("IsAuth [personnel-list.js]: " + isAuth);

  // useEffect(() => {
  //   retrievePersonnel();
  // }, []);

  const onChangeSearchName = (e) => {
    const searchName = e.target.value;
    setSearchName(searchName);
  };

  const onChangeDatabase = (e) => {
    const searchDatabase = e.target.value;
    setDatabase(searchDatabase);
  };

  // const retrievePersonnel = () => {
  //   SearchDataService.getAll()
  //     .then((response) => {
  //       // console.log(response.data);
  //       setPersonnel(response.data.personnel);
  //     })
  //     .catch((e) => {
  //       console.log(e);
  //     });
  // };

  // const refreshList = () => {
  //   retrievePersonnel();
  // };

  const find = (query, by, db, userId) => {
    SearchDataService.find(query, by, db, userId)
      .then((response) => {
        console.log(response.data);
        setPersonnel(response.data.personnel);
      })
      .catch((e) => {
        console.log(e);
      });
  };

  const findByName = () => {
    find(searchName, "name", database, userId);
  };

  return (
    <>
      {/* <div>{database}</div> */}
      {isAuth ? (
        <div className="rows d-flex align-content-center">
          <div className="input-group">
            <input
              type="text"
              className="form-control"
              placeholder="Search By Name"
              value={searchName}
              onChange={onChangeSearchName}
            />
          </div>
          <select
            className="form-control"
            name="database"
            value={database}
            onChange={(e) => onChangeDatabase(e)}
          >
            <option>Database</option>
            <option value="mongo">MongoDB</option>
            <option value="post">PostGreSQL</option>
          </select>
          <div className="input-group-append">
            <button className="btn btn-outline-secondary" type="button" onClick={findByName}>
              Search
            </button>
          </div>
        </div>
      ) : (
        <h1>Access Denied, Please Login to Search</h1>
      )}
      <div className="row">
        {personnel.map((officer) => {
          let officerName;
          let officerId = officer.personnel_id ? officer.personnel_id : officer._id;
          if (officer.surname !== "undefined") {
            officerName = officer.surname;
          }
          if (officer.first) {
            officerName += ", " + officer.first;
          }
          if (officer.middle) {
            let middleI = officer.middle.slice(0, 1);
            officerName += " " + middleI + ".";
          }
          return (
            <div className="col-lg-4 p-1" key={uuidv4()}>
              <div className="card text-center bg-dark">
                <div className="card-body m-1">
                  <h5 className="card-title">{officerName}</h5>
                  <div className="row">
                    <Link to={"/personnel/" + officerId} className="btn btn-primary m-1">
                      View Officer Profile
                    </Link>
                  </div>
                </div>
              </div>
            </div>
          );
        })}
      </div>
    </>
  );
}

export default Search;