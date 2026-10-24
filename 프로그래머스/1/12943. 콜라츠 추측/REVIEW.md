#### 1트
```java
class Solution {
    public int solution(int num) {
        if(num == 1) return 0;
        
        int nextNum = num;
        int count = 0;
        
        while(nextNum > 1){
            if(count >= 500 && nextNum != 1) return -1;
            if(nextNum == 1) break;
            
            nextNum = (nextNum % 2 == 0) ? (nextNum / 2) : (nextNum * 3 + 1);
            count++;
        }
        return count;
    }
}
````

#### 2트
```java
class Solution {
    public int solution(int num) {
        if(num == 1) return 0;
        
        long nextNum = num;
        int count = 0;
        
        while(nextNum > 1){
            if(count > 500) return -1;
            if(nextNum == 1) break;
            
            nextNum = (nextNum % 2 == 0) ? (nextNum / 2) : (nextNum * 3 + 1);
            count++;
        }
        return count;
    }
}
```
