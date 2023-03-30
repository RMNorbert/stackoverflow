import Cookies from "js-cookie";
import React, { useState } from "react";
import { uploadQuestion } from "../../utils/uploadQuestion";

export const CreateQuestion = () => {
  const [userID, setUserID] = useState();
  const handleSubmit = async (e) => {
    e.preventDefault();
    setUserID(parseInt(Cookies.get("id")));
    let title = e.target[0].value;
    let description = e.target[1].value;
    uploadQuestion(title, description, userID);
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
