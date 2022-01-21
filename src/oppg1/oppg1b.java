package oppg1;

import java.util.function.BiFunction;

public class oppg1b {
	

	public static void main(String[] args) {

        System.out.println(beregn(12, 13, (a, b) -> {
            return a + b;
        }));

        System.out.println(beregn(-5, 3, (a, b) -> {
            if (a < b) {
                return b;
                // returnerer b viss b er størst
            } else {
                return a;
                // returnerer a viss a er størst
            }
        }));

        System.out.println(beregn(54, 45, (a, b) -> {
            int forskjell = a - b;
            //returnerer forskjellen mellom a og b
            if (forskjell < 0) {
                return forskjell * (-1);
            } else {
                return forskjell;
            }
        }));
    }

    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> func) {
        return func.apply(a, b);
    }
	
}
