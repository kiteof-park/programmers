class Solution {
    public int solution(int num) {
        int answer = 0;
        
        for(int x = 2; x < num; x++){
            if(num % x == 1){
                answer = x;
                break;
            }
        }        
        return answer;
    }
}