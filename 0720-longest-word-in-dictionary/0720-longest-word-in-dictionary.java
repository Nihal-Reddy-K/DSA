class Solution {
    class TrieNode{
            TrieNode[] children = new TrieNode[26];
            boolean isEnd;
        }

        TrieNode root = new TrieNode(); 

        void insert(String word){
            TrieNode current = root;

            for(char c : word.toCharArray()){
                int index = c - 'a';

                if(current.children[index] == null){
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }
            current.isEnd = true;
        }

    public String longestWord(String[] words) {
        for(String word : words){
            insert(word);
        }
        String answer = "";

        for(String word: words){
            TrieNode current = root;
            boolean valid = true;
            for(char c : word.toCharArray()){
                int index = c - 'a';

                current = current.children[index];

                if(!current.isEnd){
                    valid = false;
                    break;
                }
            }
            if(valid){
                if(word.length() > answer.length()){
                    answer = word;
                }
                else if(word.length() == answer.length() && word.compareTo(answer) < 0){
                    answer = word;
                }
            }
        }
        return answer;
    }
}