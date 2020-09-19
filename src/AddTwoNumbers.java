import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode list1A = new ListNode(2);
        ListNode list1B = new ListNode(4);
        ListNode list1C = new ListNode(3);

        list1A.next = list1B;
        list1B.next = list1C;

        ListNode list2A = new ListNode(5);
        ListNode list2B = new ListNode(6);
        ListNode list2C = new ListNode(4);

        list2A.next = list2B;
        list2B.next = list2C;

        BigDecimal firstNum = getNumberFromList(list1A);
        BigDecimal secondNum = getNumberFromList(list2A);

        BigDecimal resultBeforeReversing = firstNum.add(secondNum);
        String resultAfterReversing = getReversedNumber(resultBeforeReversing);

        System.out.println(getListFromSum(resultAfterReversing));
    }

    static String getReversedNumber(BigDecimal resultBeforeReversing) {
        String asString = resultBeforeReversing + "";
        StringBuilder newString = new StringBuilder();
        int size = asString.length();
        for (int i = size - 1; i >= 0; i--) {
            newString.append(asString.charAt(i));
        }

        return newString.toString();
    }

    static ListNode getListFromSum(String s) {
        int size = s.length() - 1;
        ListNode current = new ListNode(Integer.parseInt(s.charAt(size) + ""));
        size--;
        for (int i = size; i >= 0; i--) {
            ListNode newNode = new ListNode();
            newNode.val = Integer.parseInt(s.charAt(i) + "");
            newNode.next = current;
            current = newNode;
        }
        return current;
    }

    static BigDecimal getNumberFromList(ListNode head) {
        BigDecimal number = BigDecimal.ZERO;
        BigDecimal power = BigDecimal.ONE;

        ListNode tmp = head;
        while (tmp != null) {
            number = number.add(power.multiply(BigDecimal.valueOf(Long.parseLong(tmp.val + ""))));
            tmp = tmp.next;
            power = power.multiply(TEN);
        }
        return number;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int data) {
        this.val = data;
    }

    ListNode() {
    }
}














