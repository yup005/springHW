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
        User user = new User();
        model.addAttribute("user", user);
        user.setBalance(0);
        return "/bank/new_user";
    }

    @PostMapping("/bank/user/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/viewUserPage";
    }

    @GetMapping("/bank/user/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id,
                                    Model model) {
        User user = userService.getUserByAccountNumber(id);
        model.addAttribute("user", user);
        return "/bank/update_user";
    }

    @GetMapping("/bank/user/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        this.userService.deleteUserByAccountNumber(id);
        return "redirect:/viewUserPage";
    }


    @GetMapping("/bank/user/deposit/{id}")
    public String showFormForDeposit(@PathVariable(value = "id") long id,
                                     Model model) {
        User user = userService.getUserByAccountNumber(id);
        model.addAttribute("user", user);
        double funds = 0;
        model.addAttribute("funds", funds);
        return "/bank/deposit";
    }

    @GetMapping("/bank/user/depositFunds")
    public String deposit(@ModelAttribute("user") User user,
                          @ModelAttribute("funds") double funds) {
        if (funds < 5 || funds > 10000) {
            return "/bank/deposit";
        } else {
            user.setBalance(user.getBalance() + funds);
        }
        userService.saveUser(user);
        return "redirect:/viewUserPage";
    }


    @GetMapping("/bank/user/withdraw/{id}")
    public String showFormForWithdraw(@PathVariable(value = "id") long id,
                                     Model model) {
        User user = userService.getUserByAccountNumber(id);
        model.addAttribute("user", user);
        double funds = 0;
        model.addAttribute("funds", funds);
        return "/bank/withdraw";
    }

    @GetMapping("/bank/user/withdrawFunds")
    public String withdraw(@ModelAttribute("user") User user,
                           @ModelAttribute("funds") double funds) {
        if (funds > user.getBalance()) {
            return "/bank/withdraw";
        } else {
            user.setBalance(user.getBalance() - funds);
        }
        userService.saveUser(user);
        return "redirect:/viewUserPage";
    }

}
