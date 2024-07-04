package siddharth_crowdfunding.example.crowdfunding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/home")  // the home page
    public String index(){
        return "Index";
    }

    @GetMapping("/create") // creation form
    public String create(){
        return "CreateForm";
    }
    @PostMapping("/create") // creates and then redirects
    public String createProject(@RequestParam("name") String name, @RequestParam("description") String description,
                              @RequestParam("current_budget") Double current_budget, @RequestParam("required_budget") double required_budget) {
        projectService.createProject(name, description, current_budget, required_budget);
        return "redirect:/api/project/home";
    }
    @GetMapping("/update") // updatation form
    public String update(){
        return "UpdateBudget";
    }
    @PostMapping("/updateBudget") //updates and redirects
    public String updateCurrentBudget(@RequestParam("name") String name, @RequestParam("current_budget") double current_budget,
                                      RedirectAttributes redirectAttributes) {
        try {
            projectService.updateCurrentBudget(name, current_budget);
            redirectAttributes.addFlashAttribute("message", "Project updated successfully!");
        }catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", "Error updating project: " + e.getMessage());
        }
        return "redirect:/api/project/update";
    }
    @GetMapping("/print") // print form
    public String print(){
        return "Print";
    }
    @PostMapping("/print") //prints the request
    public String print(@RequestParam("name") String name, Model model , RedirectAttributes redirectAttributes) {
        try {
            Project project = projectService.getProjectByName(name);
            model.addAttribute("name", project.getName());
            model.addAttribute("description", project.getDescription());
            model.addAttribute("current_budget", project.getCurrent_budget());
            model.addAttribute("required_budget", project.getRequired_budget());
            return "PrintForm";
        }catch (RuntimeException e){
            redirectAttributes.addFlashAttribute("message","Data Not Found");
            return "redirect:./print";

        }
    }

    @GetMapping("/fundBrowser")
    public String Browser(Model model){
        List<Project> projects= projectService.getProjectList();
        for(Project project:projects){
            System.out.println("Name: "+project.getName());

        }
        ObjectMapper mapper = new ObjectMapper();
        String projectsJson = "";
        try {
            projectsJson = mapper.writeValueAsString(projects);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Add JSON string to the model
        model.addAttribute("projectsJson", projectsJson);
        return "FundBrowser";

    }
}
