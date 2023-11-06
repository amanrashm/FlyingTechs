package com.flyingtechs;
import com.flyingtechs.userManagement.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about-us/")
public class DashboardController {

    @GetMapping("index")
    public String show(Model model, User index) {
        model.addAttribute("index", index);
        return "index";
    }
}