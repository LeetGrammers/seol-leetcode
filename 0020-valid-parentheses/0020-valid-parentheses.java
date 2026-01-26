class Solution {
    public boolean isValid(String s) {
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
                if (stack.peek() != map.get(c)) {
                    return false;
                } else { // 일치 시 제거
                    stack.pop();
                }
            }
        }

        // 스택 비어있지 않아도 false 리턴
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
