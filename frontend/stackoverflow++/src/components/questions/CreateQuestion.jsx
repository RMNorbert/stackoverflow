import Cookies from "js-cookie";
import { useState } from "react";

export const CreateQuestion = () => {
  const [userID, setUserID] = useState();
  const handleSubmit = async (e) => {
    e.preventDefault();
    setUserID(parseInt(Cookies.get("id")));
    let title = e.target[0].value;
    let description = e.target[1].value;

    const response = await fetch("http://127.0.0.1:8080/questions/", {
      method: "POST",
      body: JSON.stringify({
        title,
        description,
        userID,
      }),
      mode: "cors",
      headers: { "Content-Type": "application/json" },
    });
    const data = await response.json();
    console.log(data);
  };
  return (
    <div className="text-black">
      <form onSubmit={(e) => handleSubmit(e)}>
        <label htmlFor="question">Question:</label>
        <input type="text" name="question" id="" />
        <label htmlFor="desc">Describe your question</label>
        <input type="text" name="desc" id="" />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};
