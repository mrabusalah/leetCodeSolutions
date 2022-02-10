public class MyArrayList {

    private int[] data;
    private int pointer = 0;

    public MyArrayList(int size) {
        this.data = new int[size];
    }

    public void add(int number) {
        int length = data.length;
        if (pointer == length) {
            int[] newData = new int[length * 2];
            for (int i = 0; i < length; i++)
                newData[i] = data[i];
            data = newData;
        }
        data[pointer++] = number;
    }

    public void remove(int index) throws IllegalAccessException {
        if (index >= 0 && index < pointer) {
            for (int i = index; i < pointer - 1; i++)
                data[i] = data[i + 1];
            pointer--;
        } else
            throw new IllegalAccessException("index is out of scope");

    }

    public int get(int index) throws IllegalAccessException {
        if (index >= 0 && index < pointer)
            return data[index];
        throw new IllegalAccessException("index is out of scope");
    }

    public int getSize() {
        return pointer;
    }
}

class Test {
    public static void main(String[] args) throws IllegalAccessException {
        MyArrayList myArrayList = new MyArrayList(10);

        myArrayList.add(5);
        myArrayList.add(44);

        printMyList(myArrayList);

        myArrayList.remove(0);
//        myArrayList.remove(0);
//        myArrayList.remove(0);
//        myArrayList.remove(0);

        printMyList(myArrayList);
    }

    private static void printMyList(MyArrayList myArrayList) throws IllegalAccessException {
        for (int i = 0; i < myArrayList.getSize(); i++)
            System.out.println(myArrayList.get(i));
        System.out.println("-----------------------------------");
    }
}
