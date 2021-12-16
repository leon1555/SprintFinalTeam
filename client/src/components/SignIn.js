import { useState } from "react";
import { useHistory } from "react-router";
import { toast } from "react-toastify";

function Login({ setAuth }) {
  const history = useHistory();

  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  const { username, password } = user;

  const onChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmitForm = async (e) => {
    e.preventDefault();
    try {
      const body = { username, password };
      const response = await fetch(`http://localhost:8080/api/auth/signin`, {
        method: "POST",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify(body),
      });

      const parseRes = await response.json();

      if (parseRes.token) {
        localStorage.setItem("token", parseRes.token);
        localStorage.setItem("userId", parseRes.id);
        localStorage.setItem("username", parseRes.username);
        localStorage.setItem("email", parseRes.email);
        setAuth(true);
        toast.success("Login Successful");
        history.push("/");
      } else {
        setAuth(false);
        toast.dark(parseRes.message);
      }
    } catch (err) {
      console.error(err.message);
    }
  };

  return (
    <>
      <h1 className="text-center">Sign-In</h1>
      <form className="text-center m-5" onSubmit={onSubmitForm}>
        <div className="row my-2 justify-content-center">
          <input
            type="text"
            className="form-control m-2 input-size"
            id="email"
            name="username"
            placeholder="Username"
            required
            value={user.username}
            onChange={(e) => onChange(e)}
          />
          <input
            type="password"
            className="form-control m-2 input-size"
            id="password"
            name="password"
            placeholder="Password"
            required
            value={user.password}
            onChange={(e) => onChange(e)}
          />
        </div>
        <button className="btn btn-success px-5">Login</button>
      </form>
    </>
  );
}

export default Login;
