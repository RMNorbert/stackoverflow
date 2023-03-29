import {useEffect, useState} from "react";
import "./App.css";
import {Header} from "./components/Header";
import {QuestionList} from "./components/questions/QuestionList";

function App() {
    const [questions, setQuestions] = useState([]);
    const [user, setUser] = useState(null);

    const fetchData = async () => {
        const data = await fetch("http://127.0.0.1:8080/questions/all");
        const dataJSON = await data.json();
        setQuestions(dataJSON);
    };
    useEffect(() => {
        fetchData();
    }, []);
    return (
        <div className="App">
            <Header setter={setUser}/>
            <QuestionList questionData={questions}/>
        </div>
    );
}

export default App;
