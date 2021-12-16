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
  const [database, setDatabase] = useState("mysql-make");
  const [time, setTime] = useState(null);

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
      <Navbar isAuth={isAuthenticated} setAuth={setAuth} setTime={setTime} />
      <main className="main_body">
        <div className="content_wrapper">
          <div className="content_container">
            <Switch>
              <Route
                exact
                path={["/"]}
                render={(props) => <Landing {...props} isAuth={isAuthenticated} />}
              />
              <Route
                exact
                path={["/", "/search"]}
                render={(props) => (
                  <Search
                    {...props}
                    isAuth={isAuthenticated}
                    setDatabase={setDatabase}
                    database={database}
                  />
                )}
              />
              <Route
                path="/history"
                render={(props) => <Results {...props} isAuth={isAuthenticated} />}
              />
              <Route path="/signin" render={(props) => <SignIn {...props} setAuth={setAuth} />} />
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
