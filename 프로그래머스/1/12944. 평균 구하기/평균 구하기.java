class Solution {
    public double solution(int[] arr) {
        int result = 0;
        for(int arrNum : arr){
            result += arrNum;
        }
        return result / (double) arr.length;
    }
}