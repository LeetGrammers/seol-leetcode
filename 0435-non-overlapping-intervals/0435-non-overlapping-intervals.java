class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // end 기준으로 오름차순 정렬
        int removeCount = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start < end) { // 구간이 겹친다면
                removeCount++;
            } else { // 겹치지 않는다면
                end = intervals[i][1];
            }
        }
        
        return removeCount;
        
    }
}