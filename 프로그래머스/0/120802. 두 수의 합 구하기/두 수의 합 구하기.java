class Solution {
    public int solution(int num1, int num2) {
        int answer = -1;
        int min = -50000;
        int max = 50000;
        
        if(num1 >= min && num1 <= max && num2 >= min && num2 <= max){
            answer = num1 + num2;
        }        
        return answer;
    }
}