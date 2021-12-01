import java.io.IOException;
import java.math.BigDecimal;

public class AddBinary {
    public static void main(String[] args) throws IOException {
        System.out.println(
                convertIntoBinary(
                        convertFromBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"),
                        convertFromBinary("110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011")
                )
        );
    }

    public static BigDecimal convertFromBinary(String num) {
        BigDecimal answer = BigDecimal.ZERO;
        int len = num.length() - 1;
        BigDecimal power = BigDecimal.ONE;
        for (int i = len; i >= 0; i--) {
            if (num.charAt(i) == '1') {
                answer = answer.add(power);
            }
            power = power.multiply(BigDecimal.valueOf(2L));
        }
        return answer;
    }

    public static String convertIntoBinary(BigDecimal a, BigDecimal b) {
        BigDecimal number = a.add(b);
        StringBuilder answer = new StringBuilder();
        while (number.compareTo(BigDecimal.ZERO) > 0) {
            answer.insert(0, (number.remainder(new BigDecimal(2)).compareTo(BigDecimal.ZERO) == 0 ? "0" : "1"));
            number = number.divide(new BigDecimal(2), 0, BigDecimal.ROUND_DOWN);
        }
        return (answer.length() == 0) ? "0" : answer.toString();
    }
}
