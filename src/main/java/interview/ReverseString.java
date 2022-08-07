package interview;

public class ReverseString {

    String reverse(String s) {
        int lastIndex = s.length() -1;
        StringBuilder sBuilder = new StringBuilder();
        rec(s, lastIndex, 0, sBuilder);
        return sBuilder.toString();
    }

    void rec(String s,int lastIndex, int currIndex, StringBuilder sBuilder) {
        if (lastIndex == currIndex) {
            sBuilder.append(s.charAt(currIndex));
            return;
        }
        rec(s, lastIndex, currIndex+1, sBuilder);
        sBuilder.append(s.charAt(currIndex));
    }

    public static void main(String[] args) {
        int a = 2 ;
        int b = 2;
        String d = "_g_";
        String s = a + b + d + a + b;
        System.out.println(s);


        System.out.println(new ReverseString().reverse("soma"));
    }


}
