SELECT question.question_id, title, question.description, question.created, COUNT(answer_id) as numberOfAnswers
FROM question
    LEFT JOIN answer a on question.question_id = a.question_id
WHERE question.question_id = 2
GROUP BY question.question_id