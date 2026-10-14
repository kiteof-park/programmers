### 험난한 정답의 길

#### 1트
```java
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;

        // n개의 리스트 -> n번 반복
        for(int i = 0; i < n; i++){
            // x부터 시작해 x씩 증가
            answer[i] = x;
            x = x + num;
        }
        return answer;        
    }
}
```

#### Error
```text
/Solution.java:10: error: incompatible types: possible lossy conversion from long to int
            x = x + num;
                  ^
1 error
```
---

#### 2트
```java
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;

        // n개의 리스트 -> n번 반복
        for(int i = 0; i < n; i++){
            // x부터 시작해 x씩 증가
            answer[i] = x;
            (long) x = x + num;
        }
        return answer;        
    }
}

```

#### Error
```text
/Solution.java:10: error: unexpected type
            (long) x = x + num;
            ^
  required: variable
  found:    value
1 error
```
---
#### 3트
야르 ,, 3트 만에 성공  
`long`과 `int` 사이에 타입 에러가 계속 발생하길래 `long`타입 변수 `num`을 기준으로 문제를 풀었다.
```java
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;
        
        // n개의 리스트 -> n번 반복
        for(int i = 0; i < n; i++){
            // x부터 시작해 x씩 증가
            answer[i] = num;
            num = num + x;
        }
        return answer;        
    }
}
```
---
## 왜 3트까지 갔을까? - 꼭 알고가야 할 3가지 개념
### 1. 자료형의 표현 범위
이 문제에서 `x`는 최대 10,000,000이고 `n`은 최대 1,000  
따라서 결과 배열의 마지막 값은 최대 10,000,000,000까지 커질 수 있있음  
**`int`의 범위를 초과하므로 결과값을 계산하고 저장할 때 `long` 타입이 필요**  

### 2. 자동 형변환, 명시적 형변환
#### 1트 - 자동 형변환
자바에서 서로 다른 자료형끼리의 연산 결과는 **표현 범위가 더 큰 자료형으로 변환해서 연산**     
```java
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;        // int -> long 자동 형변환

        for(int i = 0; i < n; i++){
            answer[i] = x;   // int -> long 자동 형변환
            x = x + num;     // 💥 에러 발생
        }
        return answer;        
    }
```
1트에서 `x + num`의 연산 결과는 `long`타입인데 `int`타입의 `x`에 대입해서 컴파일 에러 발생

#### 2트 - 명시적 형변환
형변환은 **변수 자체의 자료형을 바꾸지 않음**
```java
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;

        for(int i = 0; i < n; i++){
            answer[i] = x;
            (long) x = x + num;
        }
        return answer;        
    }
```
2트에서 `(long) x`는 `x`의 값을 `long`으로 변환한 결과를 만들 뿐 `x`의 자료형은 여전히 `int`  
대입 연산자 왼쪽의 변수는 값을 저장할 수 있는 변수여야되는데, `(long) x`는 형변환 결과값

### 3. 대입 연산과 형변환의 관계
#### 일반 대입 연산자(=)
```java
int a = 10;
long b = 20L;
a = a + b;      // ❌ 컴파일 에러
```


#### 복합 대입 연산자(+=)
복합 대입 연산자는 **왼쪽 변수의 자료형으로 암묵적 형변환을 수행**한다.  
`a += b;`는 `a = (int)(a + b);`와 같다.
```java
int a = 10;
long b = 20L;
a += b;         // ✅ 
```





