package pers.pan.springHW;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping("/showTest1")
    public String showTest1() {
        return "/test/test1";
    }
    @GetMapping("/showTest2")
    public String showTest2() {
        return "/test/test2";
    }

}

