export const submitAnswer = async(description, question_id  )=>{
    const response = await fetch("http://127.0.0.1:8080/user/answers/", {
        method: "POST",
        body: JSON.stringify({description, question_id}),
        mode: "cors",
        headers: {"Content-Type": "application/json"},
    });
    return await response.json();
}