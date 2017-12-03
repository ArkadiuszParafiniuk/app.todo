package pl.arkadiuszparafiniuk.app.todo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.arkadiuszparafiniuk.app.todo.model.Todo;
import pl.arkadiuszparafiniuk.app.todo.service.TodoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
@RestController
@RequestMapping("/api")
public class TodoController {

    private static final Log LOG = LogFactory.getLog(TodoController.class);

    @Resource
    TodoService todoService;

    @RequestMapping(value = "/todo/", method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> listAllTodos() {

        LOG.info("GET /api/todo/");

        List<Todo> todos = todoService.getAll();
        if (todos.isEmpty()) {
            LOG.warn("todos is empty");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTodo(@PathVariable("id") int id) {

        LOG.info("GET /api/todo/{id} id:"+id);

        Todo todo = todoService.get(id);
        if (todo == null) {
            LOG.warn("todo id:"+id+" is not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/", method = RequestMethod.POST)
    public ResponseEntity<?> createTodo(@RequestBody Todo todo, UriComponentsBuilder ucBuilder) {

        LOG.info("POST /todo/ todo:"+ todo);

        if (todoService.get(todo.getId()) != null) {
            LOG.warn("todo is exist");
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        todoService.add(todo);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/todo/{id}").buildAndExpand(todo.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {

        LOG.info("PUT /todo/{id} id:"+id);

        Todo oldTodo = todoService.get(id);

        if (oldTodo == null) {
            LOG.warn("todo id:"+id+" is not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        if (todo.getId()!=id) {
            LOG.warn("id conflict");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        todoService.update(todo);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTodo(@PathVariable("id") int id) {

        LOG.info("DELETE /todo/{id} id:"+id);

        Todo todo = todoService.get(id);
        if (todo == null) {
            LOG.warn("todo id:"+id+" is not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        todoService.delete(todo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllTodos() {

        LOG.info("DELETE /todo/");

        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
}
