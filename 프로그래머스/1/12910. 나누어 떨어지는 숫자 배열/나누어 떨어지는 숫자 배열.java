import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for(int num : arr){
            if(num % divisor == 0) list.add(num);
        }
        
        if(list.size() == 0) list.add(-1);
        
        // list에 있는거 오름차순해서 int[]로 반환
        return list.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}