package pl.bgora.calculator.web.util;

import com.github.bgora.rpnlibrary.Calculator;
import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
@Component
public class WebCalculatorDecorator {

    public BigDecimal calculate(final String input) throws WrongArgumentException, NoSuchFunctionFound {
        final String replaced = StringUtils.replace(input, "div", "/");
        return Calculator.createDefaultCalculator().calculate(replaced);
    }

}
