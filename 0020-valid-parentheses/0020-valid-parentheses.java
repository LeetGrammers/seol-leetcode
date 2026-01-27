class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else { // 닫힘괄호 나옴
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        char[] arr = s.toCharArray();

        for (char c : arr) {
            // 열린 괄호일때 우선 스택에 넣음
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else { // 닫힌 괄호일때 짝이 일치하지 않으면 바로 false 리턴
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                char expected = map.get(c);
                
                if (top != expected) return false;
            }
        }

        return stack.isEmpty();
    }
}
