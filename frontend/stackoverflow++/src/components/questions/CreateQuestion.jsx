import Cookies from "js-cookie";

Cookies.get()

export const CreateQuestion = () => {
  const handleSubmit = async(e)=>{
    e.preventDefault();
    let question = e.target[0].value;
    let desc = e.target[1].value;
    await fetch("http://127.0.0.1:8080/questions/",{
      method: "POST",
      body: {question,desc}
    })
  }
  return (
    <div>
      <form onSubmit={(e)=>handleSubmit(e)}>
        <label htmlFor="question">Question:</label>
        <input type="text" name="question" id="" />
        <label htmlFor="desc">Describe your question</label>
        <input type="text" name="desc" id="" />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};
