import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode8 = new ListNode(4);
        ListNode listNode9 = new ListNode(7);
        ListNode listNode10 = new ListNode(3);
        ListNode listNode11 = new ListNode(5);
        ListNode listNode12 = new ListNode(20);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;


        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;

        ArrayList<Integer> arrayList = getArrayFromNodes(listNode, listNode8);
        System.out.println(arrayList);
        ListNode answer = getNodeFromArray(arrayList);
        System.out.println(getArrayFromNodes(answer));
    }

    private static ListNode getNodeFromArray(ArrayList<Integer> arrayList) {
        if (arrayList.isEmpty())
            return null;
        ListNode root = new ListNode(arrayList.get(0));
        for (int i = 1, arrayListSize = arrayList.size(); i < arrayListSize; i++) {
            Integer integer = arrayList.get(i);
            ListNode newNode = new ListNode();
            newNode.val = integer;
            newNode.next = root;
            root = newNode;
        }
        return root;
    }

    private static ArrayList<Integer> getArrayFromNodes(ListNode listNode, ListNode listNode8) {
        ArrayList<Integer> newArray = new ArrayList<>();
        ListNode node = listNode.next;
        while (node != null) {
            newArray.add(node.val);
            node = node.next;
        }
        ListNode node1 = listNode8;
        while (node1 != null) {
            newArray.add(node1.val);
            node1 = node1.next;
        }
        Collections.sort(newArray);
        return newArray;
    }

    private static ArrayList<Integer> getArrayFromNodes(ListNode listNode) {
        ArrayList<Integer> newArray = new ArrayList<>();
        ListNode node = listNode;
        while (node != null) {
            newArray.add(node.val);
            node = node.next;
        }
        Collections.sort(newArray);
        return newArray;
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
