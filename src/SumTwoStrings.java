import java.util.Objects;

import static java.util.Objects.isNull;

public class SumTwoStrings {
    public static void main(String[] args) {
        System.out.println(findSum("111", "1"));
    }

    private static String findSum(String first, String second) {

        if (isNull(first) || isNull(second) || first.length() == 0 || second.length() == 0)
            return "";

        StringBuilder answer = new StringBuilder();
        if (second.length() < first.length()) {
            String tmp = first;
            first = second;
            second = tmp;
        }

        int firstLength = first.length();
        int secondLength = second.length();

        int carry = 0;
        for (int i = firstLength - 1; i >= 0; i--) {
            int sum = (first.charAt(i) - '0') + (second.charAt(i) - '0') + carry;
            answer.append((sum % 10));
            carry = sum / 10;
        }

        for (int i = secondLength - firstLength - 1; i >= 0; i--) {
            int sum = (second.charAt(i) - '0') + carry;
            answer.append((sum % 10));
            carry = sum / 10;
        }

        if (carry > 0)
            answer.append(carry);

        return answer.reverse().toString();
    }
}
