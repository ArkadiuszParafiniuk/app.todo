package pl.arkadiuszparafiniuk.app.todo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJdbc {

    @Test
    public void testJdbc(){

        String jdbcUrl = "jdbc:mysql://localhost:3306/todo_app?useSSL=false";
        String user = "root";
        String pass = "";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successfull");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
