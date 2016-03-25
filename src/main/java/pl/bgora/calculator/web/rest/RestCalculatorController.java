package pl.bgora.calculator.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bgora.calculator.web.model.CalculationResponse;
import pl.bgora.calculator.web.model.ErrorResponse;
import pl.bgora.rpn.Calculator;
import pl.bgora.rpn.exceptions.RPNException;

import java.math.BigDecimal;

@RestController
public class RestCalculatorController {


    @RequestMapping("/calculate/{input}")
    public CalculationResponse calculate(@PathVariable String input) throws RPNException {
        CalculationResponse response = new CalculationResponse();
        response.setInput(input);
        BigDecimal calculationResult = Calculator.createDefaultCalculator().calculate(input);
        response.setResult(calculationResult.toString());
        return response;
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RPNException.class)
    public ErrorResponse handleRPNException(RPNException exception) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
