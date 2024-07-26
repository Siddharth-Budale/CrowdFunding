package siddharth_crowdfunding.example.crowdfunding;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
public class Project {
    @Id
    private ObjectId id;
    private String name;
    private String user;
    private String description;
    private double current_budget;
    private double required_budget;
    private byte[] image;

    public Project(String name, String user, String description, double current_budget, double required_budget, byte[] image) {
        this.name = name;
        this.user = user;
        this.description = description;
        this.current_budget = current_budget;
        this.required_budget = required_budget;
        this.image = image;
    }

    public double getCurrent_budget() {
        return current_budget;
    }

    public double getRequired_budget() {
        return required_budget;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }

    public byte[] getImage() {
        return image;
    }
}
