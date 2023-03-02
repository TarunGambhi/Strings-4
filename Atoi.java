//https://leetcode.com/problems/string-to-integer-atoi
//TC : O(1) - > the maximum iterations would be length of integer max value ie 10
//SC : O(1)
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        if(s.charAt(0) != '-' && s.charAt(0) != '+' && !Character.isDigit(s.charAt(0))) return 0;
        int num = 0;
        boolean sign = true;
        if(s.charAt(0) == '-')
            sign = false;
        int limit = Integer.MAX_VALUE/10;
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int digit = s.charAt(i) - '0';
                if(num > limit){
                    if(sign)
                        return Integer.MAX_VALUE;
                    return Integer.MIN_VALUE;
                }else if(num == limit){
                    if(sign && digit >= 7) return Integer.MAX_VALUE;
                    if(!sign && digit >=8) return Integer.MIN_VALUE;
                }
                num = num*10 + digit;
            }else if(i != 0){
                break;
            }
        }
        if(!sign) return -num;
        return num;
    }
}
