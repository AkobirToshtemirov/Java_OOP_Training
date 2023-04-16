package LeetCodeTest;

public class LeetCodeTest {
    public static void main(String[] args) {
        String res = restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3});
        System.out.println(res);
    }

    static String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < indices.length; i++)
            sb.append(s.charAt(indices[i]));
        return sb.toString();
    }
}
