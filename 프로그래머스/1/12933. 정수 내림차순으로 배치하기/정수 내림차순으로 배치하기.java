import java.util.*;

class Solution {
    public long solution(long n) {
        // n을 리스트로 만들고 
        List<Long> arr = new ArrayList<>();
       
        while(n > 0){
            arr.add(n % 10);
            n /= 10;
        }
        
        // 리스트를 내림 차순한 다음
        arr.sort(Comparator.reverseOrder());
        
        // 리스트 요소들을 하나의 정수로 만들어서 리턴
        long answer = 0;
        for(long arrNum : arr){
            answer = (answer * 10) + arrNum;
        }
        
        return answer;
        
    }
}