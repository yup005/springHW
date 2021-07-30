package pers.pan.springHW;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping()
    public String getTest() {
        return "TEST GET";
    }

    @PostMapping()
    public String createTest() {
        return "TEST POST";
    }

    @DeleteMapping ()
    public String deleteTest() {
        return "TEST Delete";
    }

    @PutMapping()
    public String updateTest() {
        return "TEST PUT";
    }
}

