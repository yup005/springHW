package pers.pan.springHW.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // display list of employees
    @GetMapping("/viewUserPage")
    public String viewUserPage(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "/bank/user";
    }

    @GetMapping("/bank/user/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "/bank/new_user";
    }

    @PostMapping("/bank/user/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save employee to database
        userService.saveUser(user);
        return "redirect:/bank/user";
    }

    @GetMapping("/bank/user/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserByAccountNumber(id);
        model.addAttribute("user", user);
        return "/bank/update_user";
    }

    @GetMapping("/bank/user/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        // call delete employee method
        this.userService.deleteUserByAccountNumber(id);
        return "redirect:/bank/user";
    }


    @GetMapping("/user/deposit/{id}")
    public String deposit(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserByAccountNumber(id);
        model.addAttribute("user", user);
        return "/bank/deposit";
    }
    @GetMapping("/user/withdraw/{id}")
    public String withdraw(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserByAccountNumber(id);
        model.addAttribute("user", user);
        return "/bank/withdraw";
    }

}
