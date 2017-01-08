package pl.bgora.calculator.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.bgora.calculator.web.model.CalculationResponse;
import pl.bgora.calculator.web.model.ErrorResponse;
import pl.bgora.calculator.web.util.WebCalculatorDecorator;
import pl.bgora.rpn.exceptions.RPNException;

import java.math.BigDecimal;

@RestController
public class RestCalculatorController {

    private final WebCalculatorDecorator webCalculatorDecorator;

    @Autowired
    public RestCalculatorController(WebCalculatorDecorator webCalculatorDecorator) {
        this.webCalculatorDecorator = webCalculatorDecorator;
    }


    @RequestMapping("/calculate/{input}")
    public CalculationResponse calculate(@PathVariable String input) throws RPNException {
        CalculationResponse response = new CalculationResponse();
        response.setInput(input);
        BigDecimal calculationResult = webCalculatorDecorator.calculate(input);
        response.setResult(calculationResult.toString());
        return response;
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RPNException.class)
    public ErrorResponse handleRPNException(RPNException exception) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
