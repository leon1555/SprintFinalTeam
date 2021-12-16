import { useState } from "react";
import SearchDataService from "../services/search";
import { v4 as uuidv4 } from "uuid"; // then use uuidv4() to insert id

function Search({ isAuth, setDatabase, database }) {
  const [searchData, setSearchData] = useState([]);
  const [searchName, setSearchName] = useState("");

  const onChangeSearchName = (e) => {
    const searchName = e.target.value;
    setSearchName(searchName);
  };

  const onChangeDatabase = (e) => {
    const searchDatabase = e.target.value;
    setDatabase(searchDatabase);
    setSearchData([]);
  };

  const find = (query, dbPath) => {
    SearchDataService.find(query, dbPath)
      .then((response) => {
        console.log(response.data._embedded);
        if (dbPath.includes("mysql")) {
          setSearchData(response.data._embedded.mysqlmockdata);
        } else {
          setSearchData(response.data._embedded.mock_data);
        }
      })
      .catch((e) => {
        console.log(e);
      });
  };

  const findByName = () => {
    find(searchName, database);
  };

  return (
    <>
      {isAuth ? (
        <div className="rows d-flex align-content-center">
          <div className="input-group">
            <input
              type="text"
              className="form-control"
              placeholder="Search Query"
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
            <option>Database Option</option>
            <option value="mysql-model">MySQL - Car Model</option>
            <option value="mysql-make">MySQL - Car Make</option>
            <option value="post-buzz">PostGreSQL - Buzzword</option>
            <option value="post-app">PostGreSQL - App Name</option>
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
        {database.includes("mysql")
          ? searchData.map((searchMySQL) => {
              return (
                <div className="col-lg-4 p-1" key={uuidv4()}>
                  <div className="card text-center bg-dark">
                    <div className="card-body m-1">
                      <h3 className="card-title">{searchMySQL.carmake}</h3>
                      <h5 className="card-title">
                        {searchMySQL.carmodel} [{searchMySQL.color}]
                      </h5>
                    </div>
                  </div>
                </div>
              );
            })
          : searchData.map((searchPostGreSQL) => {
              return (
                <div className="col-lg-4 p-1" key={uuidv4()}>
                  <div className="card text-center bg-dark">
                    <div className="card-body m-1">
                      <h3 className="card-title">{searchPostGreSQL.buzzwords}</h3>
                      <h5 className="card-title">
                        {searchPostGreSQL.appnames} [{searchPostGreSQL.companynames}]
                      </h5>
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
