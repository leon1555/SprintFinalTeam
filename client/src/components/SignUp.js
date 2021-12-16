import { useState } from "react";
import { useHistory } from "react-router-dom";
import { toast } from "react-toastify";

function Register() {
  let history = useHistory();

  const [inputs, setInputs] = useState({
    username: "",
    email: "",
    password: "",
    password2: "",
  });

  const { username, email, password, password2 } = inputs;

  const onChange = (e) => {
    setInputs({ ...inputs, [e.target.name]: e.target.value });
  };

  const onSubmitForm = async (e) => {
    e.preventDefault();
    try {
      const body = { username: username, email: email, password: password, role: ["mod", "admin"] };

      if (!email || !password || !username || !password2) {
        toast.warning("Fields Incomplete");
        return;
      }

      if (password !== password2) {
        toast.warning("Password fields do not match");
        return;
      }

      const response = await fetch("http://localhost:8080/api/auth/signup", {
        method: "POST",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify(body),
      });

      const parseRes = await response.json();

      if (parseRes.message) {
        toast.success(parseRes.message);
        setTimeout(() => {
          history.push("/signin");
        }, 3500);
      } else {
        toast.error(parseRes.message);
      }
    } catch (err) {
      console.error(err.message);
    }
  };

  return (
    <>
      <h1 className="text-center">Sign Up</h1>
      <form className="text-center m-2" onSubmit={onSubmitForm}>
        <div className="row my-2 justify-content-center">
          <input
            className="form-control m-2 input-size"
            type="text"
            name="username"
            placeholder="Username"
            required
            value={username}
            onChange={(e) => onChange(e)}
          />
          <input
            className="form-control m-2 input-size"
            type="email"
            name="email"
            placeholder="E-mail"
            required
            value={email}
            onChange={(e) => onChange(e)}
          />
          <input
            className="form-control m-2 input-size"
            type="password"
            name="password"
            placeholder="Password"
            required
            value={password}
            onChange={(e) => onChange(e)}
          />
          <input
            className="form-control m-2 input-size"
            type="password"
            name="password2"
            placeholder="Re-Enter Password"
            required
            value={password2}
            onChange={(e) => onChange(e)}
          />
        </div>
        <button className="btn btn-success px-5">Register</button>
      </form>
    </>
  );
}

export default Register;
