package calculator.constClass.operations;

import calculator.constClass.constClass.ConstOperation;
import java.math.BigDecimal;

public class Addition implements ConstOperation {
    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2){
        return number1.add(number2);
    }

}
