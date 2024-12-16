package calculator.constClass.constClass;

import java.math.BigDecimal;

public abstract final class ConstOperation {

    public static final int ADDITION = 1; // ��������
    public static final int SUBTRACTION = 2; // ���������
    public static final int MULTIPLICATION = 3; // ���������
    public static final int DIVISION = 4; // ���������
    public static final int PERCENT = 5; //�������

    public abstract BigDecimal calculate(BigDecimal number1, BigDecimal number2);
}
