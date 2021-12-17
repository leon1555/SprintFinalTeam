import axios from "axios";

const setAuthToken = () => {
  if (localStorage.token) {
    // Apply authorization token to every request if logged in
    axios.defaults.headers.common["Authorization"] = localStorage.token;
  } else {
    // Delete auth header
    delete axios.defaults.headers.common["Authorization"];
  }
};

export default setAuthToken;
