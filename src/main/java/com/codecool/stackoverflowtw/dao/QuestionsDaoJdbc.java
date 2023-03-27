package com.codecool.stackoverflowtw.dao;

import java.sql.Connection;

public class QuestionsDaoJdbc implements QuestionsDAO {

/*    public Connection connectToDatabase(Database database){
        databaseConnection = database.getConnection();
        return databaseConnection;
    }*/
    @Override
    public void sayHi() {
        System.out.println("Hi DAO!");
    }
}
