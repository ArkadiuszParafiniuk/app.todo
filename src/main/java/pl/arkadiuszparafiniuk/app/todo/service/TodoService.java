package pl.arkadiuszparafiniuk.app.todo.service;

import pl.arkadiuszparafiniuk.app.todo.model.Todo;

import java.util.List;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public interface TodoService {

    void add(Todo todo);
    void delete(Todo todo);
    void update(Todo todo);
    Todo get(int id);
    List<Todo> getAll();

}
