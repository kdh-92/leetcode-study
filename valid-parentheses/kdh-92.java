// 풀이법 전체 - 시간복잡도 : O(n), 공간복잡도 : O(n)
class Solution {
    public boolean isValid(String s) {
        // (1) Stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') stack.push(curr);
            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((curr == ')' && top != '{') ||
                        (curr == '}' && top != '{') ||
                        (curr == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

        // (2) 생각 전환 풀이 - 인접한 [] {} ()를 하나씩 제거하는 방법
        while (true) {
            if (s.contains("()")) s = s.replace("()", "");
            else if (s.contains("{")) s = s.replace("{", "");
            else if (s.contains("]")) s = s.replace("]", "");
            else return s.isEmpty();
        }
    }
}
