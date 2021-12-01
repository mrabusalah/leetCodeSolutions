public class SameTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode v1 = new TreeNode(2);
        TreeNode v2 = new TreeNode(3);
        TreeNode v3 = new TreeNode(4);
        TreeNode v4 = new TreeNode(5);
        t1.left = v1;
        t1.right = v2;
        v1.left = v3;
        v1.right = v4;

        TreeNode t2 = new TreeNode(1);
        TreeNode x1 = new TreeNode(2);
        TreeNode x2 = new TreeNode(3);
        TreeNode x3 = new TreeNode(4);
        TreeNode x4 = new TreeNode(5);
        t2.left = x1;
        t2.right = x2;
        x1.left = x3;
        x1.right = x4;

        System.out.println(isSame(t1, t2));

    }

    private static boolean isSame(TreeNode t1, TreeNode t2) {
        TreeNode tmp1 = t1;
        TreeNode tmp2 = t2;
        while (tmp1.right != null && tmp1.left != null) {
            if (tmp1.val != tmp2.val ||
                    tmp1.left.val != tmp2.left.val ||
                    tmp1.right.val != tmp2.right.val) {
                return false;
            }
            tmp1 = t1;
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
