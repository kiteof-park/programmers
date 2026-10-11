class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int result = 0;
        
        for(int arrNum : arr){
            result += arrNum;
        }
        
        return result / (double) arr.length;
    }
}