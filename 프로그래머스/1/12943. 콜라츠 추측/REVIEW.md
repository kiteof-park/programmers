## 알고 넘어가야 할 것
### 1. 자료형과 오버플로
- 주어진 수 `int`형은 `8,000,000` 미만인데, 연산과정에서 발생하는 `nextNum`도 항상 `8,000,000`미만일까?
- `int`는 최대 `2,147,483,647`까지만 표현 가능 
### 2. 불필요한 조건문
- `while(nextNum > 1)`이 실행 중이라면 `nextNum == 1`이 가능할까?
- 이미 `nextNum > 1`인 상태인데 `nextNum != 1`을 다시 확인할 필요가 있을까?
### 3. 반복횟수 500번의 경계 조건
- 500번쨰 연산에서 정확히 1이 되는 경우는?
- 문제에서는 500번까지 연산하는 것을 허용하고 있음

#### 1트 - 오답
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

#### 2트 - 정답
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
