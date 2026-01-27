import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if(list.isEmpty() || list.get(list.size()-1) != i) {
                list.add(i);
            }
            
        }
        
        int[] answer = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }

        return answer;
    }
    
    public int[] solution2(int []arr) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i : arr) {
            if (!stack.isEmpty()) {
                if (stack.peek() == i) {
                    stack.pop();
                }
            }
            stack.push(i);
        }
        
        int[] answer = new int[stack.size()];
        int k = 0;
        for (int c : stack) {
            answer[k] = c;
            k++;
        }

        return answer;
    }
    
}