import { useState, useEffect } from "react";
import SearchDataService from "../services/search";

import { v4 as uuidv4 } from "uuid"; // then use uuidv4() to insert id
import Moment from "react-moment";

function Result({ isAuth }) {
  const [history, setHistory] = useState([]);

  useEffect(() => {
    SearchDataService.searchHistory(localStorage.userId)
      .then((response) => {
        console.log(response.data._embedded);
        setHistory(response.data._embedded.history);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  return (
    <div className="row">
      <table className="table table-hover table-dark">
        <thead>
          <tr>
            <th scope="col">Search Query</th>
            <th scope="col">Database</th>
            <th scope="col">Time Stamp</th>
          </tr>
        </thead>
        <tbody>
          {history.length > 2 ? (
            history.map((historyRow) => {
              return (
                <tr key={uuidv4()}>
                  <td>{historyRow.searchQuery}</td>
                  <td>{historyRow.db}</td>
                  <td>
                    <Moment
                      date={historyRow.queryDateTime}
                      subtract={{ hours: 3, minutes: 30 }}
                      format="YYYY/MM/DD hh:mm:ss"
                    />{" "}
                    [NST]
                  </td>
                </tr>
              );
            })
          ) : (
            <tr>
              <td colSpan={3} className="text-center">
                {" "}
                <h1>No Search Results</h1>
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default Result;
