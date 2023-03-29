import { QuestionCard } from "./QuestionCard";


export const QuestionList = ({ questionData }) => {
  console.log(questionData);
  return (
    
    <div>
      {questionData.map((question) => {
        const questionObject = { ...question.question };
        return (
          <div className="flex justify-center items-center">
            <QuestionCard
              key={questionObject.question_id + "a"}
              id={questionObject.question_id}
              title={questionObject.title}  
              description={questionObject.description}
              created={questionObject.created}
              numberOfAnswers={questionObject.numberOfAnswers}
            />
            
          </div>
        );
      })}
    </div>
  );
};
