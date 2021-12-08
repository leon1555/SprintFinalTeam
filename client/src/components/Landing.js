// import { useState, useEffect } from "react";

// import PersonnelDataService from "../services/personnel";

function Login({ setAuth, userId, getProfile, userName }) {
  // // const [history, setHistory] = useState({});

  // const searchHistory = async (userId) => {
  //   try {
  //     const response = await fetch(`http://localhost:8000/api/v1/personnel/history/${userId}`, {
  //       method: "GET",
  //       headers: { token: localStorage.token },
  //     });

  //     const parseData = await response.json();
  //   } catch (err) {
  //     console.error(err.message);
  //   }

  //   // PersonnelDataService.searchHistory(id)
  //   //   .then((response) => {
  //   //     console.log(response.data);
  //   //     setHistory(response.data.history);
  //   //   })
  //   //   .catch((e) => {
  //   //     console.log(e);
  //   //   });
  // };

  // useEffect(() => {
  //   searchHistory(userId);
  // }, [userId]);

  return (
    <>
      <article>
        <header>
          <h3>
            Welcome to our Final Sprint Project {userName && ","} {userName}
          </h3>
        </header>
        <div className="article_content">
          <h5>This is the generic search forum we have designed using React and Java</h5>
        </div>
        <footer>
          <a href="http://johnoneill.tech" target="_blank" rel="noreferrer">
            johnoneill.tech
          </a>
          <div className="footer_bar"></div>
        </footer>
      </article>
    </>
  );
}

export default Login;
