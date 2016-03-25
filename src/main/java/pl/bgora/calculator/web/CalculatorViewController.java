package pl.bgora.calculator.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorViewController {

    @RequestMapping("/hello")
    String getHello(){
        return "calculator";
    }
}
