import { useNavigate } from "react-router-dom";
import { Header } from "./Header";

export const Login = () => {
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    let user = e.target[0].value
    let password = e.target[1].value
    //Post request, hogy van-e ilyen felhasznalo
    // if(1) setter()
    // navigate("/");
  };
  return (
    <div>
      <Header />
      <div className="flex justify-center flex-col items-center text-2xl ">
        <div>Log in!</div>
        <form
          onSubmit={(e)=>{handleSubmit(e)}}
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
