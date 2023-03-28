import { useEffect, useState } from "react";
import "./App.css";
import { Header } from "./components/Header";

function App() {
  const [questions, setQuestions] = useState([]);

  const fetchData = async () => {
    const data = await fetch("http://127.0.0.1:8080/questions/all");
    const dataJSON = await data.json();
    setQuestions(dataJSON[0].question);
  };

  useEffect(() => {
    fetchData();
  }, []);
  console.log(questions);
  return (
    <div className="App">
      <Header />
      <div>{JSON.stringify(questions)}</div>
    </div>
  );
}

export default App;
