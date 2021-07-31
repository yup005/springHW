package pers.pan.springHW;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/viewTestPage")
    public String viewTestPage() {
        return "/test/test1";
    }



    @GetMapping("/viewBankPage")
    public String viewBankPage() {
        return "/bank/bank_home";
    }

    @GetMapping("/viewIndexPage")
    public String viewIndexPage() {
        return "index";
    }

}
