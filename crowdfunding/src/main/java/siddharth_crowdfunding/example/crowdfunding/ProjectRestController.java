package siddharth_crowdfunding.example.crowdfunding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/project")
public class ProjectRestController {
    @Autowired
    private ProjectService projectService;

//    @PostMapping
//    public void createProject(@RequestBody Map<String, String> tab,HttpSession session) {
//        String name = tab.get("name");
//        String description = tab.get("description");
//        double current_budget;
//        double required_budget;
//        try{
//            current_budget=Double.parseDouble(tab.get("current_budget"));
//            required_budget=Double.parseDouble(tab.get("required_budget"));
//        }
//        catch (NumberFormatException e){
//            return;
//        }
//        projectService.createProject(name, (String)session.getAttribute("username"), description, current_budget, required_budget);
//    }
//    @PostMapping("/create")
//    public void createProject(@RequestParam("name") String name, @RequestParam("description") String description,
//    @RequestParam("current_budget") Double current_budget, @RequestParam("required_budget") double required_budget) {
//        projectService.createProject(name, description, current_budget, required_budget);
//    }

//    @PostMapping("/updateBudget")
//    public String updateCurrentBudget(@RequestParam("name") String name, @RequestParam("current_budget") double current_budget) {
//        projectService.updateCurrentBudget(name, current_budget);
//        return "redirect:/api/project/home";
//    }


//    @GetMapping("/fundBrowser")
//    public String browser(Model model, HttpSession session) {
//        if (!check(session)) {
//            return "redirect:/api/password/login";
//        }
//
//        List<Project> projects = projectService.getProjectList();
//        model.addAttribute("projects", projects);
//        return "fundBrowser";
//    }


    public static boolean check(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return username != null;
    }




}