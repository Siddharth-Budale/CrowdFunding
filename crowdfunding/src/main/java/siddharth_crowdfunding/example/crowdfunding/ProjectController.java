package siddharth_crowdfunding.example.crowdfunding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
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
    private ProjectService projectService;

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            projectService.setUsername(username);
            // Add username to the model if needed
            model.addAttribute("username", username);
            return "Index"; // return the name of the view
        } else {
            return "redirect:/api/password/login";
        }
    }




    @GetMapping("/create")
    public String create(Model model,HttpSession session) {
        if (check(session)){
            return "CreateForm";
        }
        return "redirect:/api/password/login";

    }

    @PostMapping("/create")
    public String createProject(@RequestParam("name") String name, @RequestParam("description") String description,
                                @RequestParam("current_budget") Double current_budget, @RequestParam("required_budget") double required_budget) {
        projectService.createProject(name, description, current_budget, required_budget);
        return "redirect:/api/project/home";
    }

    @GetMapping("/update")
    public String update(HttpSession session) {
        if (check(session)) return "UpdateBudget";
        return "redirect:/api/password/login";
    }

    @PostMapping("/updateBudget")
    public String updateCurrentBudget(@RequestParam("name") String name, @RequestParam("current_budget") double current_budget,
                                      RedirectAttributes redirectAttributes) {
        try {
            projectService.updateCurrentBudget(name, current_budget);
            redirectAttributes.addFlashAttribute("message", "Project updated successfully!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", "Error updating project: " + e.getMessage());
        }
        return "redirect:/api/project/update";
    }

    @GetMapping("/print")
    public String print(HttpSession session) {
        if (check(session)) return "Print";
        return "redirect:/api/password/login";
    }

    @PostMapping("/print")
    public String print(@RequestParam("name") String name, Model model, RedirectAttributes redirectAttributes) {
        try {
            Project project = projectService.getProjectByName(name);
            model.addAttribute("name", project.getName());
            model.addAttribute("description", project.getDescription());
            model.addAttribute("current_budget", project.getCurrent_budget());
            model.addAttribute("required_budget", project.getRequired_budget());
            return "PrintForm";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("message", "Data Not Found under : "+name);
            return "redirect:/api/project/print";
        }
    }


    @GetMapping("/fundBrowser")
    public String browser(Model model, HttpSession session) {
        if (!check(session)) {
            return "redirect:/api/password/login";
        }

        List<Project> projects = projectService.getProjectList();
        for (Project project : projects) {
            System.out.println("Name: " + project.getName());
        }

        ObjectMapper mapper = new ObjectMapper();
        String projectsJson = "";
        try {
            projectsJson = mapper.writeValueAsString(projects);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        model.addAttribute("projectsJson", projectsJson);
        return "FundBrowser";

    }

    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes,HttpSession session){
        projectService.setUsername(null);
        session.removeAttribute("username");
        return "redirect:/api/password/login";
    }

    public static boolean check(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return username != null;
    }

}
