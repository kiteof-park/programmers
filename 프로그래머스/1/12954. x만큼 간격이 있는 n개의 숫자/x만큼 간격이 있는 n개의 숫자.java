class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;
        
        // n개의 리스트 -> n번 반복
        for(int i = 0; i < n; i++){
            // x부터 시작해 x씩 증가
            answer[i] = num;
            num = num + x;
        }
        return answer;        
    }
}