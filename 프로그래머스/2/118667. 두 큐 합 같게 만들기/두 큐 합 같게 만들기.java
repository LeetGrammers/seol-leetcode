import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int x : queue1) {
            q1.offer(x);
            sum1 += x;
        }
        for (int y : queue2) {
            q2.offer(y);
            sum2 += y;
        }

        long total = sum1 + sum2;
        if (total % 2 != 0) return -1;
        long target = total / 2;
        int limit = 3 * q1.size();

        int count = 0;

        while (count <= limit) { // 둘이 같아질때까지? 반복문 종료조건을 어떻게? 불가능하다는걸 어떻게 알지?
            if (sum1 == target) {
                return count;
            }
            if (sum1 > target) { // 만약 q1 합이 크다면, q1 요소를 pop해서 q2에 insert
                Integer temp = q1.poll();
                if (temp == null) return -1;
                q2.offer(temp);
                sum1 -= temp;
                sum2 += temp;
            } else { // 만약 q2 합이 크다면, q2 요소를 pop해서 q1에 insert
                Integer temp = q2.poll();
                if (temp == null) return -1;
                q1.offer(temp);
                sum2 -= temp;
                sum1 += temp;
            }
            count++;
        }
        return -1;
    }
}
