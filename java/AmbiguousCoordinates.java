package com.leetcode.medium

//816. Ambiguous Coordinates
//Input: s = "(123)"
//Output: ["(1, 2.3)","(1, 23)","(1.2, 3)","(12, 3)"]
//Input: s = "(00011)"
//Output: ["(0, 0.011)","(0.001, 1)"]


class AmbiguousCoordinates {
public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList();
        for(int i= 2; i< s.length()-1; ++i ){
            for(String left: generate(s, 1, i)){
                for(String right: generate(s, i, s.length()-1)){
                    result.add("("+left +", " + right+")");
                }
                
            }
        }
        return result;
                
    }
    
    List<String> generate(String s, int start, int end){
        List<String> list = new ArrayList();
        for( int d = 1; d <= end-start; d++){
            String left = s.substring(start, start + d);
            String right = s.substring( start+d, end);
        
            if ( (!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
                list.add( left + (d< end - start ? "." : "") + right);
            }
        }
        return list;
    }
}
