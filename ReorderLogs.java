//https://leetcode.com/problems/reorder-data-in-log-files
//TC : nlogn
//SC : O(1) - in case of quick sort | O(n) in case of merge sort - under the hood.
// O(1) space over the hood
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(a,b)-> {
            
            String[] s1 = a.split(" ",2);
            String[] s2 = b.split(" ",2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int val = s1[1].compareTo(s2[1]);
                if(val != 0){
                    return val;
                }else{
                    return s1[0].compareTo(s2[0]);
                }
            }else if(isDigit1 && !isDigit2){
                return 1;
               
            } else if(!isDigit1 && isDigit2){
                    return -1;
            }
            else{
                return 0;
            }
        });
        return logs;
    }
}
