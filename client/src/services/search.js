import http from "../http-common";
import setAuthToken from "../utils/setAuthToken";

class SearchDataService {
  find(searchQuery, dbPath = "mysql-make") {
    let [db, path] = dbPath.split("-", 2);
    let userId = localStorage.userId;
    const body = { userId: userId, db: db, searchQuery: searchQuery };
    setAuthToken();
    http
      .post("/history", body)
      .then((response) => null)
      .catch((error) => null);
    if (db === "post") {
      if (path === "buzz") {
        return http.get(`/mock_data/search/findByBuzzwordsContaining/?buzzwords=${searchQuery}`);
      } else {
        return http.get(`/mock_data/search/findByAppnamesContaining/?appnames=${searchQuery}`);
      }
    } else if (db === "mysql") {
      if (path === "make") {
        return http.get(`/mysqlmockdata/search/findByCarmakeContaining/?query=${searchQuery}`);
      } else {
        return http.get(`/mysqlmockdata/search/findByCarmodelContaining/?query=${searchQuery}`);
      }
    }
  }

  searchHistory(id) {
    setAuthToken();
    return http.get(`/history/search/findByUserId/?userId=${id}`);
  }
}

export default new SearchDataService();
