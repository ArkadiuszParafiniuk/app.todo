package pl.arkadiuszparafiniuk.app.todo.service;

import org.springframework.stereotype.Service;
import pl.arkadiuszparafiniuk.app.todo.dao.TodoDaoImpl;
import pl.arkadiuszparafiniuk.app.todo.model.Todo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
@Service
public class TodoServiceImpl implements TodoService {

    @Resource
    TodoDaoImpl todoDao;

    @Override
    public void add(Todo todo) {
        todoDao.add(todo);
    }

    @Override
    public void delete(Todo todo) {
        todoDao.delete(todo);
    }

    @Override
    public void update(Todo todo) {
        todoDao.update(todo);
    }

    @Override
    public Todo get(int id) {
        return todoDao.get(id);
    }

    @Override
    public List<Todo> getAll() {
        return todoDao.getAll();
    }

}
