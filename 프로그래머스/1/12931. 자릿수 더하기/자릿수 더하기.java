import java.util.*;

public class Solution {
    public int solution(int num) {
        int answer = 0;
        
        // 각 자리수의 나머지를 추출(%)하고, 10단위로 숫자를 줄여나감(/)
        while(num > 0){
            answer += num % 10;            
            num /= 10;        }

        return answer;
    }
}