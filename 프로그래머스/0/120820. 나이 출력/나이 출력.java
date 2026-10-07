class Solution {
    public int solution(int age) {
        int result = 0;
        int year = 2022;
        
        if(age > 0 && age <= 120 ){
            result = year - age + 1;
        }
        return result;
    }
}