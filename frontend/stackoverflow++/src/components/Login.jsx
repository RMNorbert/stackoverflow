import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Header } from "./Header";

export const Login = () => {
  const navigate = useNavigate();
  const [invalid, setInvalid] = useState(false);
  const handleSubmit = async (e) => {
    e.preventDefault();
    let username = e.target[0].value;
    let password = e.target[1].value;
    let user = await checkAvailableUser(username, password);
    if (user) {
      navigate("/");
    } else setInvalid(true);
  };
  return (
    <div>
      <Header />
      <div className="flex justify-center flex-col items-center text-2xl ">
        <div>Log in!</div>
        <div className="text-red-400">{invalid ? "This username/password combo doesn't work" : ""}</div>
        <form
          onSubmit={(e) => {
            handleSubmit(e);
          }}
          className="flex justify-center flex-col items-center text-black"
        >
          <label htmlFor="name">Username</label>
          <input type="text" className="name" />
          <label htmlFor="">Password</label>
          <input type="password" className="password" />
          <button
            type="submit"
            className="bg-buttonBlue m-5 p-2 border-spacing-2 border-black border-4 hover:bg-blue-600"
          >
            Log in
          </button>
        </form>
      </div>
    </div>
  );
};

const checkAvailableUser = async (username, password) => {
  const response = await fetch("http://127.0.0.1:8080/user/login", {
    method: "PUT",
    body: JSON.stringify({ username, password }),
    mode: "cors",
    headers: { "Content-Type": "application/json" },
  });
  const potentialUser = await response.json();
  return potentialUser;
};
