import axios from "axios";

const headers = {
  "Content-type": "application/json",
  Authorization: "Bearer " + localStorage.token,
};

export default axios.create({
  baseURL: "http://localhost:8080/",
  headers: headers,
});
