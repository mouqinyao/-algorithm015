class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // 1. BFS
        // if (!wordList.contains(endWord)) return 0;
        // Queue<String> queue = new LinkedList<>();
        // Set<String> set = new HashSet<>(wordList);
        // int step = 1;
        // queue.add(beginWord);
        // while (!queue.isEmpty()) {
            // int size = queue.size();
            // for (int k = 0; k < size; k++) {
                // String current = queue.poll();
                // if (current.equals(endWord)) return step;
                // for (int i = 0; i < current.length(); i++) {
                    // char[] word = current.toCharArray();
                    //for (int j = 0; j < 26; j++) {
                        // char c = (char) ('a' + j);
                        // if (word[i] == c) continue;
                        // word[i] = c;
                        // String s = String.valueOf(word);
                        // if (set.contains(s)) {
                            // queue.offer(s);
                            // set.remove(s);
                        // }
                    // }
                // }
            // }
            // step++;
        // }
        // return 0;
    // 2. Bidirectional BFS
        if (!wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>(),
                    endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int len = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                // Swap two sets
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }
        return 0;
    }
}