class Solution {
    public boolean isValid(String s) {
        // 스택 사용. 만약 Top이 현재 만난 괄호와 같다면 제거, 아니면 계속 쌓음
        // 반복문 끝난 후 스택에 값이 남아있다면 false
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
