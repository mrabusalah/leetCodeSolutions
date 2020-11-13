import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {-1, -1, 0, 0, 0, 0};
        int[] nums2 = {-1, 0};
        int n = nums1.length;
        Arrays.sort(nums1);
        int idx = IntStream.range(0, n)
                .filter(i -> 0 == nums1[i])
                .findFirst()
                .orElse(-1);
        if (idx >= 0) {
            for (int i = idx, j = 0; j < nums2.length; i++, j++) {
                nums1[i] = nums2[j];
            }
        }
        Arrays.sort(nums1);
        System.out.println(idx);
        System.out.println(Arrays.toString(nums1));
    }
}
