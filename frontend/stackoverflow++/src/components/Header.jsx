import Cookies from "js-cookie";
import React from "react";
import { useEffect, useState } from "react";
import { RiUser3Fill } from "react-icons/ri";
export const Header = () => {
  const [open, setOpen] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState(null);

  const handleLogout = () => {
    setUsername(null);
    setIsLoggedIn(false);
    Cookies.remove("user");
  };

  const handleOpen = () => setOpen(!open);

  useEffect(() => {
    setUsername(Cookies.get("user"));
    if (username) setIsLoggedIn(true);
  });

  return (
    <div className="flex justify-between bg-white text-4xl text-lightgray h-24">
      <div>
        <a href="/">Stackoverflow++</a>
      </div>
      <div className="flex justify-evenly gap-y-12">
        <div>
          <RiUser3Fill className="text-blue-600" onClick={() => handleOpen()} />
        </div>
        {open ? (
          isLoggedIn ? (
            <div>
              <a href="/user">
                <div>{username}</div>
              </a>

              <button onClick={handleLogout}>Logout</button>
            </div>
          ) : (
            <ul>
              <li>
                <a href="/login">Log in</a>
              </li>
              <li>
                <a href="/register">Register</a>
              </li>
            </ul>
          )
        ) : (
          <></>
        )}
      </div>
    </div>
  );
};
