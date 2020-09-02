class Solution {
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) return false;
        
        int[] counter = new int[26];
        for (int i = 0; i < sLength; i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int c: counter) {
            if (c != 0) return false;
        }
        
        return true;
    }
}