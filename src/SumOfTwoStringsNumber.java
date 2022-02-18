public class SumOfTwoStringsNumber {

    public static void main(String[] args) {
        System.out.println(findSum("55", "550"));
    }

    private static String findSum(String first, String second) {

        // swap if first is not smallest
        StringBuilder answer = new StringBuilder();
        int firstLength = first.length();
        int secondLength = second.length();

        if (secondLength < firstLength) {
            String tmp = first;
            first = second;
            second = tmp;
        }

        firstLength = first.length();
        secondLength = second.length();

        int carry = 0;

        int secondIdx = secondLength - 1;
        // add first number
        for (int i = firstLength - 1; i >= 0; i--) {
            int sum = (first.charAt(i) - '0') + (second.charAt(secondIdx--) - '0') + carry;
            answer.insert(0, sum % 10);
            carry = sum / 10;
        }

        // add the remaining of the larger number
        for (int i = (secondLength - firstLength - 1); i >= 0; i--) {
            int sum = (second.charAt(i) - '0') + carry;
            answer.insert(0, sum % 10);
            carry = sum / 10;
        }

        // check the carry
        if (carry > 0) answer.insert(0, (carry + ""));

        return answer.toString();
    }
}
