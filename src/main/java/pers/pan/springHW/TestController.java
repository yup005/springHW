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

//    @GetMapping("/test/test1")
//    public String getTest() {
//        return "TEST GET";
//    }
//
//    @PostMapping("/test/test1")
//    public String createTest() {
//        return "TEST POST";
//    }
//
//    @DeleteMapping ("/test/test1")
//    public String deleteTest() {
//        return "TEST Delete";
//    }
//
//    @PutMapping("/test/test1")
//    public String updateTest() {
//        return "TEST PUT";
//    }

}

