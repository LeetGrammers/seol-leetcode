class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        
        int bestL = 0;
        int bestR = n - 1;
        int bestLen = Integer.MAX_VALUE;
        
        int left = 0;
        int sum = 0;
        
        for (int right = 0; right < n; right ++) {
            sum += sequence[right];
            
            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }
            
            if (sum == k) {
                int len = right - left + 1;
                if (len < bestLen) {
                    bestL = left;
                    bestR = right;
                    bestLen = len;
                }
            }
        }
        return new int[] {bestL, bestR};
    }
}