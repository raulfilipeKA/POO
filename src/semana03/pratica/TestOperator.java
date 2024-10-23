package semana03.pratica;

import java.util.ArrayList;
import java.util.List;

public class TestOperator {
    public static void main(String[] args) {
        List<Operator> operators = new ArrayList<>();
        operators.add(new Addition());
        operators.add(new Power());
        String[] expression = { "(", "(", "2", "^", "8", ")", "+", "2", ")"}; // 256 + 2 = 258
    }
}
