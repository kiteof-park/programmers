class Solution {
    public String solution(int num) {
        int result = num % 2;
        
        String answer = switch(result){
            case 0 -> "Even";  
            default -> "Odd";
        };
        return answer;
    }
}