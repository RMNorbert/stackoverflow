import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Answer } from "../answers/Answer";

export const SelectedQuestion = () => {
  const [currentQuestion, setCurrentQuestion] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [answers, setAnswers] = useState([]);
  const [params, searchParams] = useState(useParams());

  const getData = async () => {
    setIsLoading(true);
    const questionResponse = await fetch(
      "http://127.0.0.1:8080/questions/" + params.id
    );
    const answersResponse = await fetch(
      "http://127.0.0.1:8080/answers/q/" + params.id
    );
    const questionData = await questionResponse.json();
    const answerData = await answersResponse.json();
    setCurrentQuestion(questionData.question);
    setAnswers(answerData);
    setIsLoading(false);
  };
  useEffect(() => {
    getData();
  }, []);
  console.log(answers);
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
          <div className="h-64 bg-white my-5 rounded-xl w-2/3 text-black  ">
            <p className="text-5xl flex justify-center">
              {currentQuestion.title}
            </p>
            <p className="text-3xl gap-3">{currentQuestion.description}</p>
          </div>
        </div>
        <div className="flex justify-center items-center flex-col">
          {answers.map((currentAnswer, i) => (
            <Answer
              key={i}
              description={currentAnswer.answer.description}
              created={currentAnswer.answer.created}
            />
          ))}
        </div>
      </div>
    );
};
