package siddharth_crowdfunding.example.crowdfunding;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    private String username="";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void createProject(String name, String user, String description, double current_budget,
                              double required_budget, byte[] image) {
        Project project = new Project(name, user, description, current_budget, required_budget, image);
        projectRepository.save(project);
    }
        public void updateCurrentBudget(String name, Double amt, HttpSession session){
        // Retrieve current budget
        if(findUserByName(name)==null) throw new RuntimeException("Data Not found");
        if(!session.getAttribute("username").equals(findUserByName(name))){
            throw new RuntimeException("NO access");
        }
        Double currentBudget = findCurrentBudgetByName(name);
        if (currentBudget == null) {
            throw  new RuntimeException("Data Not Found");
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
    private String findUserByName(String name){
        Optional<Project> project= projectRepository.findByName(name);
        if(project.isEmpty())return null;
        return project.get().getUser();
    }


    public Project getProjectByName(String name) {
        return projectRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }



    public List<Project> getProjectList() {
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }


}
