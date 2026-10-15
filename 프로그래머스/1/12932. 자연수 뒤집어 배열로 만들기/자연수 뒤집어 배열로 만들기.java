class Solution {
    public int[] solution(long n) {
        
        String str = String.valueOf(n);
        char[] charArr = str.toCharArray();
        
        int[] answer = new int[charArr.length];
        
        for(int i = 0; i < charArr.length; i++){
            answer[i] = charArr[charArr.length - 1 - i] - '0';
        }
        
        return answer;
    }
}