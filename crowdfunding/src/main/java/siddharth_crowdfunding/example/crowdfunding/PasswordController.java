package siddharth_crowdfunding.example.crowdfunding;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api/password")
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @GetMapping("/sign_up")
    public String createUser() {
        return "CreateUser";
    }

    @PostMapping("/submit-registration")
    public String createUser(@RequestParam("username") String username, @RequestParam("password") String password,
                             RedirectAttributes redirectAttributes) {
        try {
            System.out.println("hello");
            boolean userAdded = passwordService.addUser(username, password);
            System.out.println(userAdded);
            if (userAdded) {
                redirectAttributes.addFlashAttribute("message", "User Successfully Added");
                return "redirect:/api/password/login";
            } else {
                redirectAttributes.addFlashAttribute("message", "Username Already Exists");
                return "redirect:/api/password/sign_up";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "An error occurred: " + e.getMessage());
            return "redirect:/api/password/sign_up";
        }
    }

    @PostMapping("/submit-login")
    public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        try {
            boolean isAuthenticated = passwordService.authentication(username, password);
            if (isAuthenticated) {
                session.setAttribute("username", username);
                return "redirect:/api/project/home";
            } else {
                redirectAttributes.addFlashAttribute("message", "Invalid Credentials");
                return "redirect:/api/password/login";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/api/password/login";
        }
    }
}
