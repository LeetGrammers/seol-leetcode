class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26]; 
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
            count[t.charAt(i) - 'a'] -= 1;
        }

        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        mapS = countAlphabet(s);
        mapT = countAlphabet(t);

        for (Character key : mapS.keySet()) {
            if(mapS.get(key).equals(mapT.getOrDefault(key, 0))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public Map<Character, Integer> countAlphabet(String str) {
         Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}