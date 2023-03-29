import { useNavigate } from "react-router-dom";
import { Header } from "./Header";

export const Register = () => {
  const navigate = useNavigate();
  const handleSubmit = () => {
    //Post request, hogy van-e ilyen felhasznalo
    navigate("/");
  };
  return (
    <div>
      <Header />
      <div>Register!</div>
      <div className="flex justify-center flex-col items-center text-2xl ">
        <form
          action=""
          className="flex justify-center flex-col items-center text-black"
        >
          <label htmlFor="name">Username</label>
          <input type="text" className="name" />
          <label htmlFor="">Password</label>
          <input type="password" className="password" />
        </form>
        <button
          type="click"
          className="bg-buttonBlue m-5 p-2 border-spacing-2 border-black border-4 hover:bg-blue-600"
          onClick={handleSubmit}
        >
          Register
        </button>
      </div>
    </div>
  );
};
