package pers.pan.springHW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pers.pan.springHW.bank.UserService;

@Controller
public class IndexController {
    @GetMapping("/viewTestPage")
    public String viewTestPage() {
        return "/test/test1";
    }

    @Autowired
    private UserService userService;
    @GetMapping("/viewBankPage")
    public String viewBankPage(Model model) {

        model.addAttribute("listUsers", userService.getAllUsers());
        return "/bank/user";
    }

    @GetMapping("/viewIndexPage")
    public String viewIndexPage() {
        return "index";
    }

}
