package pers.pan.springHW;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.pan.springHW.employee.Employee;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/showTest2")
    public String showTest2() {
        return "/test/test2";
    }

}

