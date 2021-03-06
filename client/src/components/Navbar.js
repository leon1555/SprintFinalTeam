import { useState, useEffect } from "react";
import { toast } from "react-toastify";
import { Link } from "react-router-dom";
import { useHistory } from "react-router";

function Navbar({ user, isAuth, setAuth, setTime, setAuthToken }) {
  const history = useHistory();
  const [btnText, setBtnText] = useState("menu");
  const [isActive, setIsActive] = useState(false);
  const [refreshClock, setRefreshClock] = useState(false);

  const logout = (e) => {
    e.preventDefault();
    try {
      localStorage.removeItem("token");
      localStorage.removeItem("userId");
      localStorage.removeItem("username");
      localStorage.removeItem("email");
      setAuth(false);
      setAuthToken("");
      toast.success("Logout Succesful");
      history.push("/");
    } catch (err) {
      console.log(err.message);
    }
  };

  useEffect(() => {
    const d = new Date();
    const hour = d.getHours();
    const minutes = d.getMinutes();

    if (hour < 10 && minutes >= 10) {
      setTime("0" + hour.toString() + ":" + minutes.toString());
    } else if (hour >= 10 && minutes < 10) {
      setTime(hour.toString() + ":0" + minutes.toString());
    } else if (hour < 10 && minutes < 10) {
      setTime("0" + hour.toString() + ":0" + minutes.toString());
    } else {
      setTime(hour.toString() + ":" + minutes.toString());
    }
    setRefreshClock(false);
  }, [refreshClock, setTime]);

  setInterval(() => {
    setRefreshClock(true);
  }, 60000);

  const toggleNav = () => {
    setIsActive(!isActive);
    if (btnText === "menu") {
      setBtnText("close");
    } else {
      setBtnText("menu");
    }
  };

  return (
    <>
      <header id="main_header" className="header">
        <div className="header_inner">
          <hgroup>
            <Link to={"/"} className="navbar-brand">
              <h1>Team 3 - Semester 4 Final Sprint</h1>
            </Link>
          </hgroup>

          <div className="menu-btn_wrapper">
            <button id="menu-btn" className="material-icons" onClick={toggleNav}>
              {btnText}
            </button>
          </div>

          <nav id="main_nav" className={isActive ? "active" : null}>
            <ul>
              {isAuth ? (
                <>
                  <li>
                    <span>
                      <Link to={"/history"} className="nav-link">
                        Search History
                      </Link>
                    </span>
                  </li>
                  <li>
                    <span>
                      <Link to={"/search"} className="nav-link">
                        Search
                      </Link>
                    </span>
                  </li>
                </>
              ) : (
                " "
              )}
              <li>
                <span>
                  {isAuth ? (
                    <Link
                      to={"/"}
                      onClick={logout}
                      className="nav-link"
                      style={{ cursor: "pointer" }}
                    >
                      Logout
                    </Link>
                  ) : (
                    <Link to={"/signin"} className="nav-link">
                      Sign In
                    </Link>
                  )}
                </span>
              </li>
              {!isAuth ? (
                <li className="nav-item">
                  <Link to={"/signup"} className="nav-link">
                    Sign Up
                  </Link>
                </li>
              ) : (
                " "
              )}
            </ul>
          </nav>
        </div>
      </header>
    </>
  );
}

export default Navbar;
