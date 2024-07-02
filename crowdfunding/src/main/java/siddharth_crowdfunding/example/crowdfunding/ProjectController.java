package siddharth_crowdfunding.example.crowdfunding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public void createProject(@RequestBody Map<String, String> tab) {
        String name = tab.get("name");
        String description = tab.get("description");
        double current_budget;
        double required_budget;
        try{
            current_budget=Double.parseDouble(tab.get("current_budget"));
            required_budget=Double.parseDouble(tab.get("required_budget"));
        }
        catch (NumberFormatException e){
            return;
        }
        projectService.createProject(name, description, current_budget, required_budget);
    }
    @PostMapping("/create")
    public void createProject(@RequestParam("name") String name, @RequestParam("description") String description,
    @RequestParam("current_budget") Double current_budget, @RequestParam("required_budget") double required_budget) {
        projectService.createProject(name, description, current_budget, required_budget);
    }

    @PostMapping("/updateBudget")
    public void updateCurrentBudget(@RequestParam("name") String name, @RequestParam("current_budget") double current_budget) {
        projectService.updateCurrentBudget(name, current_budget);
    }




}