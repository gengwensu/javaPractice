import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        String input = "()[]{}";
        ValidParentheses sol = new ValidParentheses();
        System.out.println(sol.isValid(input));
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
            case '(':
            case '{':
            case '[':
                st.push(c);
                break;
            case ')':
                if (st.isEmpty() || st.pop() != '(')
                    return false;
                break;
            case '}':
                if (st.isEmpty() || st.pop() != '{')
                    return false;
                break;
            case ']':
                if (st.isEmpty() || st.pop() != '[')
                    return false;
                break;
            default:
                return false;
            }
        }
        if (!st.isEmpty())
            return false;

        return true;
    }
}