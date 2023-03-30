import {useEffect, useState} from "react";
import { useParams } from "react-router-dom";

export const SelectedQuestion = () => {
    const [currentQuestion, setCurrentQuestion] = useState(null);
    const [isLoading, setIsLoading] = useState(true);
    const [params, searchParams] = useState(useParams());
    
    const getData = async () => {
        setIsLoading(true);
        const response = await fetch("http://127.0.0.1:8080/questions/" + params.id);
        const data = await response.json();
        setCurrentQuestion(data.question);
        setIsLoading(false);
    };
    useEffect(() => {
        getData();
    }, []);
    // console.log(currentQuestion);
    if (isLoading)
        return (
            <div>
                <div>Loading...</div>
            </div>
        );
    else
        return (
            <div>
                <div className="flex justify-center">
                    <div className="h-64 bg-white my-5 rounded-xl w-2/3 text-black ">
                        <p className="text-5xl">{currentQuestion.title}</p>
                        <p className="text-3xl gap-3">{currentQuestion.description}</p>
                    </div>
                </div>
            </div>
        );
};
