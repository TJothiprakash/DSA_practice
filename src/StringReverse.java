import org.jetbrains.annotations.NotNull;

public class StringReverse {

    public String reversePrefix(@NotNull String word, char ch) {

        StringBuilder sb = new StringBuilder();
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (ch == word.charAt(i)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return word;
        }
        for (int i = index; i >= 0; i--) {
            sb.append(word.charAt(i));
        }


        sb.append(word.substring(index + 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        StringReverse stringReverse= new StringReverse();
       String ans= stringReverse.reversePrefix("abcdefd",'d');
        System.out.println(ans);
    }
}

