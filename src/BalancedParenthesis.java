import java.rmi.UnexpectedException;
import java.util.Random;
import java.util.stream.IntStream;

public class BalancedParenthesis {
    static class Input {
        public static String generatePattern() {
            double rand = new Random().nextInt(10);
            StringBuilder stringBuilder = new StringBuilder();
            String pattern = "{}[]()";
            IntStream
                    .range(0, (int) rand)
                    .forEach(ch -> buildString(ch, pattern, stringBuilder));
            return stringBuilder.toString();
        }

        private static StringBuilder buildString(int ch, String pattern, StringBuilder stringBuilder) {
            int index = (int)(pattern.length()
                    * Math.random());
            return stringBuilder.append(pattern
                    .charAt(index));
        }
    }
    public static void main(String[] args) {
        String input = Input.generatePattern();
        boolean balanced = false;
        try {
            balanced = BalancedParenthesis.isBalanced(input);
            System.out.println(balanced ? "Balanced" : "Unbalanced");

            balanced = BalancedParenthesis.isBalanced("{()}");
            System.out.println(balanced ? "Balanced" : "Unbalanced");

            balanced = BalancedParenthesis.isBalanced("[]{()}");
            System.out.println(balanced ? "Balanced" : "Unbalanced");

            balanced = BalancedParenthesis.isBalanced("[]{()}");
            System.out.println(balanced ? "Balanced" : "Unbalanced");
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }
    }

    private static boolean isBalanced(String input) throws UnexpectedException {
        System.out.println(input);
        if (null == input || ((input.length() % 2) != 0)) {
            return false;
        } else {
            char[] ch = input.toCharArray();
            for (char c : ch) {
                if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) {
                    throw new UnexpectedException("Invalid Input");
                }
            }
        }
        while (input.contains("()")
                || input.contains("[]") || input.contains("{}")) {
            input = input.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
        return (input.length() == 0);
    }
}
