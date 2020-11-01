import java.util.*;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(4);
        ListNode listNode8 = new ListNode(4);
        ListNode listNode9 = new ListNode(5);
        ListNode listNode10 = new ListNode(5);
        ListNode listNode11 = new ListNode(5);
        ListNode listNode12 = new ListNode(20);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode10.next = listNode10;
        listNode11.next = listNode12;

        Set<Integer> integerSet = getSetFromListNode(listNode);
        if (integerSet.isEmpty()) {
//            return null;
        }
        List<Integer> list = new ArrayList<>(integerSet);
        list.sort(Collections.reverseOrder());
        LinkedHashSet<Integer> resultSet = new LinkedHashSet<>(list);
        ListNode answer = getListFromSet(resultSet);
        System.out.println(getSetFromListNode(answer));
//        return answer;
    }

    private static ListNode getListFromSet(Set<Integer> integerSet) {
        Iterator<Integer> itr = integerSet.iterator();
        ListNode root = new ListNode(itr.next());
        while (itr.hasNext()) {
            ListNode newNode = new ListNode();
            newNode.val = itr.next();
            newNode.next = root;
            root = newNode;
        }
        return root;
    }

    private static Set<Integer> getSetFromListNode(ListNode head) {
        ListNode tmp = head;
        Set<Integer> set = new LinkedHashSet<>();
        while (tmp != null) {
            set.add(tmp.val);
            tmp = tmp.next;
        }
        return set;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
