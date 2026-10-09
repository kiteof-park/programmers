class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        double result = 0.0;
        if(0 < num1 && num1 <= 100 && 0 < num2 && num2 <=100){
            result = (double)num1 / (double)num2;
            answer = (int)(result * 1000);
            return answer;
        }
        return answer;
    }
}