import {useEffect, useState} from "react";
import "./App.css";
import {Header} from "./components/Header";

function App() {
    const [questions, setQuestions] = useState([]);

    const fetchData = async () => {
        const data = await fetch("http://127.0.0.1:8080/questions/all");
        console.log(data);
        // const dataJSON = await JSON.stringify(data.body);
        // console.log(dataJSON);
        // setQuestions(dataJSON);
    };

    useEffect(() => {
        fetchData();
    }, []);
    console.log(questions);
    return (
        <div className="App">
            <Header/>
        </div>
    );
}

export default App;
