class Solution {
    public int solution(int[] numbers) {
        int base = 0;
        int sum = 0;
        
        for(int i = 0; i < 10; i++){
            base += i;    
        }
        
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        
        return base - sum;
        
    }
}