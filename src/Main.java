import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BstNode root = new BstNode(1);
        root.insert(3);
        root.insert(5);
        root.insert(7);
        root.insert(2);
        root.insert(1);
        root.insert(9);
        root.printInOrder();
    }
}
