//Leetcode
//745. Prefix and Suffix Search

class WordFilter {
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for ( int weigth = 0; weigth < words.length ; ++weigth){
            String word = words[weigth] + "{";  
            for ( int i = 0 ; i < word.length(); ++i){
                TrieNode cur = root;
                cur.weigth = weigth;
                for(int j = i; j< 2* word.length() - 1; ++j){
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null)
                        cur.children[k] = new TrieNode();
                    cur = cur.children[k];
                    cur.weigth = weigth;
                }
            }
            
        }
        
    }

    
    public int find(String prefix, String suffix) {
        TrieNode cur = root;
        
        for ( char letter : (suffix + '{' + prefix).toCharArray() ) {
           if( cur.children[letter - 'a'] == null)
               return -1;
           cur = cur.children[letter - 'a'];
        }
        
        return cur.weigth;
    }
}

class TrieNode {
    TrieNode[] children;
    int weigth ;
    
    public TrieNode(){
        children = new TrieNode[27];
        weigth = 0;
    }
    
}
