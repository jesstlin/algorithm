package com.leetcode.medium;

//6. ZigZag Conversion

class ZigZagStringConvert{
  public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}

class ZigZagStringConvert {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int cycleLen = 2 * numRows -2;
        
        for(int i=0; i < numRows; i++){
            for(int j=0; i+j < s.length() ;j+=cycleLen){
                sb.append(s.charAt(i+j));
                
                if(i !=0 && i != numRows-1 && j+cycleLen-i< s.length()){
                    sb.append(s.charAt( j+cycleLen-i));
                }
            }
         }
        return sb.toString();
    }
}
