class Solution {
    public String solution(String s) {
        StringBuilder remaining = new StringBuilder(s);
        StringBuilder result = new StringBuilder();
        
        
        while(remaining.length() > 0){
            int maxIdx = 0;
            
            // 남아있는 문자 중 가장 큰 문자의 위치 찾기
            for(int i = 1; i < remaining.length(); i++){
                if(remaining.charAt(i) > remaining.charAt(maxIdx)){
                    maxIdx = i;
                }
            }
            
            // 결과에 붙이고, 남은 문자에서 제거
            result.append(remaining.charAt(maxIdx));
            remaining.deleteCharAt(maxIdx);
            
        }
        
        return result.toString();
    }
}