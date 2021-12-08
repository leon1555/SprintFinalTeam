import { useState } from "react";
import { Switch, Route } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";

import "bootstrap/dist/css/bootstrap.min.css";
import "react-toastify/dist/ReactToastify.css";
import "./App.css";

import Navbar from "./components/Navbar";
import Landing from "./components/Landing";
import Search from "./components/Search";
import Results from "./components/Result";
import SignIn from "./components/SignIn";
import SignUp from "./components/SignUp";

toast.configure();

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [adminRole, setAdminRole] = useState(false);
  const [database, setDatabase] = useState("mongo");
  const [name, setName] = useState(null);
  const [userId, setUserId] = useState(null);
  const [time, setTime] = useState(null);

  // ---- Get Name and Admin Privileges ---- \\
  async function getProfile(userId) {
    try {
      const response = await fetch(`http://localhost:8000/api/users/${userId}`, {
        method: "GET",
        headers: { token: localStorage.token },
      });

      const parseData = await response.json();

      setName(parseData.name);
      setAdminRole(parseData.admin);
    } catch (err) {
      console.error(err.message);
    }
  }

  const setAuth = (boolean) => {
    setIsAuthenticated(boolean);
  };

  return (
    <div className="container">
      <div className="topbar">
        <div className="time_wrapper">
          <span></span>
          <time>{time}</time>
        </div>
      </div>
      {/* <Provider store={store}> */}
      <Navbar
        isAuth={isAuthenticated}
        setAuth={setAuth}
        setAdmin={setAdminRole}
        setName={setName}
        setTime={setTime}
      />
      <main className="main_body">
        <div className="content_wrapper">
          <div className="content_container">
            <Switch>
              <Route
                exact
                path={["/"]}
                render={(props) => (
                  <Landing
                    {...props}
                    isAuth={isAuthenticated}
                    userId={userId}
                    admin={adminRole}
                    userName={name}
                  />
                )}
              />
              <Route
                exact
                path={["/", "/search"]}
                render={(props) => (
                  <Search
                    {...props}
                    isAuth={isAuthenticated}
                    userId={userId}
                    admin={adminRole}
                    setDatabase={setDatabase}
                    database={database}
                  />
                )}
              />
              <Route
                path="/search/:id"
                render={(props) => (
                  <Results
                    {...props}
                    isAuth={isAuthenticated}
                    admin={adminRole}
                    userId={userId}
                    database={database}
                  />
                )}
              />
              <Route
                path="/signin"
                render={(props) => (
                  <SignIn
                    {...props}
                    setAuth={setAuth}
                    setUserId={setUserId}
                    getProfile={getProfile}
                  />
                )}
              />
              <Route path="/signup" render={(props) => <SignUp {...props} />} />
            </Switch>
          </div>
        </div>
      </main>
      <ToastContainer
        position="bottom-center"
        autoClose={3000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss={false}
        draggable
        pauseOnHover={false}
      />
      {/* </Provider> */}
    </div>
  );
}

export default App;