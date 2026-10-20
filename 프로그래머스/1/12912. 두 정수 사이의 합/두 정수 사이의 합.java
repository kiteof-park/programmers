class Solution {
    public long solution(int a, int b) {
        int min = 0;
        int max = 0;
        long answer = 0;
        
        if(a > b){
            max = a;
            min = b;
        } else if(a < b){
            max = b;
            min = a;
        } else return a;
        
        for(int i = 0; i < (max - min); i++){
            answer += (min + i);
        }
        
        return answer + max;
    }
}