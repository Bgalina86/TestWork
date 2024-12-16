package calculator.constClass.constClass;

import java.math.BigDecimal;

public abstract final class ConstOperation {

    public static final int ADDITION = 1; // сложение
    public static final int SUBTRACTION = 2; // вычитание
    public static final int MULTIPLICATION = 3; // умножение
    public static final int DIVISION = 4; // разделить
    public static final int PERCENT = 5; //процент

    public abstract BigDecimal calculate(BigDecimal number1, BigDecimal number2);
}
