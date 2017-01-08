package pl.bgora.calculator.web.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pl.bgora.rpn.Calculator;
import pl.bgora.rpn.exceptions.NoSuchFunctionFound;
import pl.bgora.rpn.exceptions.WrongArgumentException;

import java.math.BigDecimal;
@Component
public class WebCalculatorDecorator {


    public BigDecimal calculate(String input) throws WrongArgumentException, NoSuchFunctionFound {
        String replaced = StringUtils.replace(input, "div", "/");
        return Calculator.createDefaultCalculator().calculate(replaced);
    }

}
