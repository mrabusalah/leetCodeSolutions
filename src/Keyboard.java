import static java.util.Objects.isNull;

public class Keyboard {
    public static void main(String[] args) {
        printWord("World[Hello_]");
        printWord("[]abra[bracad]A[A]");
    }

    private static void printWord(String word) {
        if (isNull(word) || word.isEmpty())
            return;
        StringBuilder answer = new StringBuilder();
        StringBuilder tmpString = new StringBuilder();
        int length = word.length();

        for (int i = 0; i < length; i++) {
            char currentCharacter = word.charAt(i);
            if (currentCharacter == '[') {
                answer.append(tmpString);
                tmpString = new StringBuilder();
            } else if (currentCharacter == ']') {
                answer = tmpString.append(answer);
                tmpString = new StringBuilder();
            } else
                tmpString.append(currentCharacter);
        }
        System.out.println(answer);
    }
//    private static void printWord(String word) {
//        Deque<Character> dequeWord = new LinkedList<>();
//        int length = word.length();
//        boolean cursor = false; // false means at cursor at the end
//        for (int i = 0; i < length; i++) {
//            char currentCharacter = word.charAt(i);
//
//            if (currentCharacter == '[') {
//                cursor = true;
//            } else if (currentCharacter == ']') {
//                cursor = false;
//            } else {
//                if (cursor) {
//                    dequeWord.addFirst(currentCharacter);
//                } else {
//                    dequeWord.addLast(currentCharacter);
//                }
//            }
//        }
//        System.out.println(dequeWord);
//    }
}
