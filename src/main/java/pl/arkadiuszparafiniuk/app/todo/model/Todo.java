package pl.arkadiuszparafiniuk.app.todo.model;

import java.util.Date;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
@Entity
@Table(name="Person")
public class Todo {

    private int id;
    private String title;
    private String description;
    private Date creationDate;
    private Date deadline;

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
}
