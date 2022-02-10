import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MergeTwoSortedArrays {
    public static List<Integer> listOne = asList(1, 2, 5, 6, 9, 9, 11, 14, 15, 16, 17);
    public static List<Integer> listTwo = asList(1, 3, 4, 7, 9, 10, 13, 20);
    public static List<Integer> answer = new ArrayList<>();
    public static int listOneSize = listOne.size();
    public static int listTwoSize = listTwo.size();
    public static int listOneIdx = 0;
    public static int listTwoIdx = 0;

    public static void main(String[] args) {
        System.out.println("Hello Amazonians");
        System.out.println(mergeTwoArrays(listOne, listTwo));
    }

    private static List<Integer> mergeTwoArrays(List<Integer> listOne, List<Integer> listTwo) {
        if (listOneSize == 0 || listTwoSize == 0)
            return answer;

        merge(listOne, listTwo);
        addRemaining(listOne, listTwo);

        return answer;
    }

    private static void merge(List<Integer> listOne, List<Integer> listTwo) {
        while (listOneIdx < listOneSize && listTwoIdx < listTwoSize) {
            if (listOne.get(listOneIdx) < listTwo.get(listTwoIdx))
                processListOne(listOne);
            else
                processListTwo(listTwo);
        }
    }

    private static void processListTwo(List<Integer> listTwo) {
        answer.add(listTwo.get(listTwoIdx));
        listTwoIdx++;
    }

    private static void processListOne(List<Integer> listOne) {
        answer.add(listOne.get(listOneIdx));
        listOneIdx++;
    }

    private static void addRemaining(List<Integer> listOne, List<Integer> listTwo) {
        if (listOneIdx < listOneSize)
            answer.addAll(listOne.subList(listOneIdx, listOneSize));
        if (listTwoIdx < listTwoSize)
            answer.addAll(listTwo.subList(listTwoIdx, listTwoSize));
    }
}
