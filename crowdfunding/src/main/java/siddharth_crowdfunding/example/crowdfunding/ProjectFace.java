package siddharth_crowdfunding.example.crowdfunding;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/project")
public class ProjectFace {
    @Autowired
    ProjectService projectService;
    @GetMapping("/update")
    public String update(){
        return "UpdateBudget";
    }
    @GetMapping("/create")
    public String create(){
        return "CreateForm";
    }
    @GetMapping("/print")
    public String print(@RequestParam("name") String name, Model model) throws  RuntimeException{
        try {
            Project project = projectService.getProjectByName(name);
            model.addAttribute("name", project.getName());
            model.addAttribute("description", project.getDescription());
            model.addAttribute("current_budget", project.getCurrent_budget());
            model.addAttribute("required_budget", project.getRequired_budget());
            return "PrintForm";  // Renders PrintForm.jsp
        }catch (RuntimeException e){
            return "oops";
        }
    }
}
