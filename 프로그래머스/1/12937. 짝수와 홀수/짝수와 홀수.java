class Solution {
    public String solution(int num) {
//         int result = num % 2;
        
//         String answer = switch(result){
//             case 0 -> "Even";
//             case 1 -> "Odd";    
//             default -> "Unknown";
//         };
//         return answer;
        
        String answer = null;
        if(num % 2 == 0){
            answer = "Even";
        }
        else answer = "Odd";
        
        return answer;
    }
}