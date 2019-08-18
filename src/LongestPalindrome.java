public class LongestPalindrome {
    public static void main(String[] args) {

        String str = "babad";
        LongestPalindrome sol = new LongestPalindrome();
        System.out.println(sol.longestPalindromeSub(str));
    }

    public String longestPalindromeSub(String s) {
        if (s == null || s.length() < 1)
            return "";
        if (s.length() == 1)
            return s;

        int begin = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = palinGrow(s, i, i);
            int len2 = palinGrow(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - begin) {
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(begin, end + 1);
    }

    private int palinGrow(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}