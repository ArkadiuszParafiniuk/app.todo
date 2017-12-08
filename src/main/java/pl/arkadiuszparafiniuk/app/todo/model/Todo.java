package pl.arkadiuszparafiniuk.app.todo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
@Entity
@Table(name="todo")
public class Todo {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    @NotNull
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="creationDate")
    @NotNull
    private Date creationDate;

    @Column(name="deadline")
    private Date deadline;

    public Todo(){
        //
    }

    public Todo(String title, String description, Date creationDate, Date deadline) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                '}';
    }
}
