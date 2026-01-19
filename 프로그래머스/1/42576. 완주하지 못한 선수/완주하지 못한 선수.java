import java.util.*;
class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Map<String, Integer> map = new HashMap<>();
            for (String p : participant) {
                map.put(p, map.getOrDefault(p, 0) + 1); // <이름, 명수> , 시간복잡도 : O(1)
            }
            // containsKey로 completion 값 찾음. 있고 동명이인 있으면 값만 줄이고, 있고 1명이라면 해당 값 remove
            for (String c : completion) {
                if (map.containsKey(c) && (map.get(c) > 1)) { // 동명이인일 경우
                    map.put(c, map.get(c)-1); // 동명이인 한명 줄임
                } else if (map.containsKey(c) && (map.get(c) == 1)) { // 한명밖에 없을 경우
                    map.remove(c); // 해당 참가자 삭제
                }
            }
            // 만약 반복문을 끝까지 돌았다면, map에는 1개 요소만 남아있을 것 -> iterator().next() 사용해서 해당 key값 가져옴
            answer = map.keySet().iterator().next();
            return answer;
        }
}
