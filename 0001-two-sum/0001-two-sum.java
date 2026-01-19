class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int numi_index = 0;
        int numj_index = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int k = 0; k < nums.length; k++) {
            map.put(nums[k], k); // (숫자, 숫자의 인덱스)
        }

        // 배열의 요소 한개를 꺼내 target과의 차를 구한 다음 해당 값이 map에 있는지 확인
        for (int i = 0; i < nums.length; i++) {
            int numj = target - nums[i];
            if (map.containsKey(numj) && (map.get(numj) != i)) {
                numi_index = i;
                numj_index = map.get(numj);
                answer[0] = numi_index;
                answer[1] = numj_index;
                Arrays.sort(answer);
            }
        }
        return answer;
    }
}