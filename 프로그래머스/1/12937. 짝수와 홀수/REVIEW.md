### 첫 번째 코드는 뭐가 문제였을까?
#### ver1 - 오답
빡대갈쓰,, **‼️음수를 고려하지 못한 코드‼️**였다.
```java
class Solution {
    public String solution(int num) {
         int result = num % 2;
        
         String answer = switch(result){
             case 0 -> "Even";
             case 1 -> "Odd";    
             default -> "Unknown";
         };
         return answer;
    }
}
```
| num | num % 2 | 반환값 |
|-------|-------|-------|     
| 4   | 0   | Even ✅   |
| 3   | 1   | Odd ✅ |
| 0   | 0   | Even ✅   |
| -4   | 0   | Even ✅   |
| -3   | -1   | Unknown ❌ |

#### ver1 - 정정
```java
class Solution {
    public String solution(int num) {
        int result = num % 2;
        
        String answer = switch(result){
            case 0 -> "Even";  
            default -> "Odd";
        };
        return answer;
    }
}
```

#### ver2 - 정답
This code is so 범부,,
```java
class Solution {
    public String solution(int num) {
        String answer = null;
        if(num % 2 == 0){
            answer = "Even";
        }
        else answer = "Odd";
        
        return answer;
    }
}
```

