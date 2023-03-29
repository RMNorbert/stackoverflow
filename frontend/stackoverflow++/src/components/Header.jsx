import { useState } from "react";
import { RiUser3Fill } from "react-icons/ri";

export const Header = () => {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(!open);
  return (
    <div className="flex justify-between bg-white text-4xl text-lightgray h-24">
      <div>
        <a href="/">Stackoverflow++</a>
      </div>
      <div className="flex justify-evenly gap-y-12">
        <div>
          {" "}
          <RiUser3Fill className="text-blue-600" onClick={() => handleOpen()} />
        </div>
        {open ? (
          <ul>
            <li>
              <a href="/login">Log in</a>
            </li>
            <li>
              <a href="/register">Register</a>
            </li>
          </ul>
        ) : (
          <></>
        )}
      </div>
    </div>
  );
};
