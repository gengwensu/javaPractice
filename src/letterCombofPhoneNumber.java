import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombofPhoneNumber {
    public static void main(String[] args) {

        String input = "23";
        letterCombofPhoneNumber sol = new letterCombofPhoneNumber();
        List<String> result = sol.letterCombinations(input);
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> hm = new HashMap<>();
        hm.put('0', "");
        hm.put('1', "");
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            List<String> out = new ArrayList<>();
            for (char r : hm.get(c).toCharArray()) {
                if (ans.size() == 0)
                    out.add(String.valueOf(r));
                else {
                    for (String s : ans) {
                        out.add(s + String.valueOf(r));
                    }
                }
            }
            ans = out;
        }
        return ans;
    }
}