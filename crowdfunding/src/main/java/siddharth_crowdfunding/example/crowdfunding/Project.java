package siddharth_crowdfunding.example.crowdfunding;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
public class Project {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private double current_budget;
    private double required_budget;

    public Project(String name, String description, double current_budget, double required_budget) {
        this.name = name;
        this.description = description;
        this.current_budget = current_budget;
        this.required_budget = required_budget;
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
}
