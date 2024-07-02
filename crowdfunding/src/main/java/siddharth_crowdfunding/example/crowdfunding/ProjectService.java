package siddharth_crowdfunding.example.crowdfunding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void createProject( String name, String description,double current_budget,double required_budget ){
        projectRepository.insert(new Project(name, description, current_budget, required_budget));
    }
    public void updateCurrentBudget(String name,Double amt){
        // Retrieve current budget
        Double currentBudget = findCurrentBudgetByName(name);
        if (currentBudget == null) {
            return; // or handle the case where currentBudget is null
        }


        // Update current budget
        currentBudget += amt;

        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update().set("current_budget", currentBudget);
        mongoTemplate.updateFirst(query, update, Project.class);
    }
    private Double findCurrentBudgetByName(String name){
        Optional<Project> project= projectRepository.findByName(name);
        if(project.isEmpty())return null;
        return project.get().getCurrent_budget();
    }


    public Project getProjectByName(String name) {
        return projectRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }


}
