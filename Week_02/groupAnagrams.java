class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        for (String s : strs) {
            // char[] ca = s.toCharArray();
            // Arrays.sort(ca);
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String key = String.valueOf(ca);
            // if (!map.containsKey(key))
            map.putIfAbsent(key, new ArrayList());
            
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}