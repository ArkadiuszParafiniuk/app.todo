package pl.arkadiuszparafiniuk.app.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.arkadiuszparafiniuk.app.todo.dao.TodoDaoImpl;
import pl.arkadiuszparafiniuk.app.todo.model.Todo;

import java.sql.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Todo todo = new Todo();
		todo.setCreationDate(new java.util.Date());
		todo.setTitle("test12 todo");
		todo.setDescription("test desc");

		TodoDaoImpl todoDao = new TodoDaoImpl();
		todoDao.add(todo);
	}
}
