public class BstNode {

    BstNode left, right;
    int data;

    public BstNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) left = new BstNode(value);
            else left.insert(value);

        } else {
            if (right == null) right = new BstNode(value);
            else right.insert(value);
        }
    }

    public boolean contains(int value) {
        if (data == value) return true;
        if (value < data) {
            if (left == null) return false;
            else return left.contains(value);
        } else {
            if (right == null) return false;
            else return right.contains(value);
        }
    }

    public void printInOrder() {
        if (left != null) left.printInOrder();
        System.out.println(data);
        if (right != null) right.printInOrder();
    }
}
