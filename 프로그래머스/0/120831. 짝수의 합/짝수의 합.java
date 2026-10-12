import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int num) {
        int answer = 0;
        for(int i = 0; i <= num; i++){
            if(i % 2 == 0){
                answer += i;
            }
        }
        return answer;
    }
}