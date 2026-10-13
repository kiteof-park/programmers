### 코드 개선
```java
class Solution {
    public int solution(int num) {
        for(int x = 2; x < num; x++){
            if(num % x == 1) return x;
        }
        return 0;
    }
}
```
- `answer` 변수와 `break`를 생략하고, 조건을 만족하는 순간 바로 `return`

### 수학적 접근
`num % x == 1`이라는 건 `num - 1`이 `x`로 나누어떨어진다는 뜻으로  
`num - 1`의 가장 작은 약수를 찾는 문제로도 풀 수 있음.

```java
if(num % x == 1)
if((num - 1) % x == 0)
```

```java
class Solution {
    public int solution(int num) {
        for(int x = 2; x < num; x++){
            if((num - 1) % x == 0) return x;
        }
        return 0;
    }
}
```
