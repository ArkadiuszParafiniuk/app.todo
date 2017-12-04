package pl.arkadiuszparafiniuk.app.todo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.arkadiuszparafiniuk.app.todo.model.Todo;

import static org.junit.Assert.assertTrue;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoDaoTest {

    TodoDaoImpl todoDao = new TodoDaoImpl();

    @Test
    public void createAndGetTodo(){
        Todo todo = new Todo();
        todo.setTitle("testTodo");
        assertTrue(todoDao.getAll().size()>0);
    }

}
