package com.kappa.movies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExampleController {

    @GetMapping("/greetings")
    public String example() {
        return "greetings"; // This maps to ".jsp" in the "templates" directory
    }

//    @PostMapping("/submit")
//    public String handleFormSubmit(@RequestParam("userString") String userString,@RequestParam("userString2") String userString2, Model model) {
//        // Add the submitted string to the model
//        model.addAttribute("userString", userString);
//        model.addAttribute("userString2",userString2);
//        // Return the view name
//        return "result";
//    }


}
