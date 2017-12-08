package pl.arkadiuszparafiniuk.app.todo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pl.arkadiuszparafiniuk.app.todo.model.Todo;

import java.util.List;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
@Repository
public class TodoDaoImpl implements TodoDao {

    private static final Logger logger = LoggerFactory.getLogger(TodoDaoImpl.class);

    private SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Todo.class).buildSessionFactory();

    @Override
    public void add(Todo todo) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(todo);
            session.getTransaction().commit();
            logger.info("Todo saved successfully, Todo Details="+todo);
        } catch (Exception e) {
            logger.error("Adding todo to database failed.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Todo todo) {
        Session session = this.sessionFactory.getCurrentSession();
        if(null != todo){
            session.delete(todo);
        }
        logger.info("Todo deleted successfully, todo details="+todo);
    }

    @Override
    public void update(Todo todo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(todo);
        logger.info("Todo updated successfully, Todo Details="+todo);
    }

    @Override
    public Todo get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Todo Todo = (Todo) session.load(Todo.class, new Integer(id));
        logger.info("Todo loaded successfully, Todo details="+Todo);
        return Todo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Todo> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Todo> todoList = session.createQuery("from Todo").list();
        for(Todo todo : todoList){
            logger.info("Person List::"+todo);
        }
        return todoList;
    }

}
