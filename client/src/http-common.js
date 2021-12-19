import axios from "axios";

const headers = {
  "Content-type": "application/json",
  Authorization: "Bearer " + localStorage.token,
};

export default axios.create({
  baseURL: "http://3.92.38.37:8080/",
  headers: headers,
});
