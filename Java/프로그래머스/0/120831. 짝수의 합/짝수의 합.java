class Solution {
    public int solution(int n) {
        int answer = 0;
        int current = 2;
        
        if (n == 1) {
            return 0;
        }
        
        while (current <= n) {
            answer += current;
            current += 2;
        }
        return answer;
    }
}