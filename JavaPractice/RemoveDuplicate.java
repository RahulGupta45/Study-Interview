import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s1.length(); i++) {
            int count = 0;
            char chI = s1.charAt(i);
            for (int j = i + 1; j < s1.length(); j++) {
                char chJ = s1.charAt(j);

                if (chI == chJ) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                sb.append(chI);
            }
        }

        System.out.println(sb.toString());
    }
}
