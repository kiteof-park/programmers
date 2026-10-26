import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        
        List<Integer> list = new ArrayList<>();
        int min  = arr[0];
        
        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
            if(arr[i] < min){
                min = arr[i];
            }
        }
        list.remove(Integer.valueOf(min));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}