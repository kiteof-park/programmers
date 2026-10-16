## 알아두면 좋은 Java 문법

| 구분 | 문법 | 설명 | 반환 타입 |
|---|---|---|---|
| 숫자 → 문자열 | `String.valueOf(n)` | 숫자를 문자열로 변환 | `String` |
| 숫자 → 문자열 | `Long.toString(n)` | long 타입을 문자열로 변환 | `String` |
| 문자열 길이 | `str.length()` | 문자열 길이 조회 | `int` |
| 특정 문자 추출 | `str.charAt(i)` | i번째 문자 추출 | `char` |
| 문자열 → 문자 배열 | `str.toCharArray()` | 문자열을 문자 배열로 변환 | `char[]` |
| 문자열 → 문자열 배열 | `str.split("")` | 문자열을 문자 단위로 분리 | `String[]` |
| 문자열 뒤집기 | `sb.reverse()` | 문자 순서 뒤집기 | `StringBuilder` |
| StringBuilder → String | `sb.toString()` | 문자열로 변환 | `String` |
| 문자 → 숫자 | `ch - '0'` | 숫자 문자를 정수로 변환 | `int` |
| 문자 → 숫자 | `Character.getNumericValue(ch)` | 문자의 숫자 값 추출 | `int` |
| 문자열 → Stream | `str.chars()` | UTF-16 코드 단위로 스트림 생성 | `IntStream` |
| Stream 요소 변환 | `.map(ch -> ch - '0')` | 숫자 문자 코드를 정수로 변환 | `IntStream` |
| Stream → 배열 | `.toArray()` | IntStream을 배열로 변환 | `int[]` |
| 마지막 자릿수 추출 | `n % 10` | 마지막 자릿수 추출 | 정수형 |
| 마지막 자릿수 제거 | `n /= 10` | 마지막 자릿수 제거 | 대입문 |
| 숫자 자릿수 계산 | `String.valueOf(n).length()` | 숫자의 자릿수 계산 | `int` |

## 다양한 문제 풀이 방법
### 1. 산술 연산으로 문제 풀기
```java
class Solution {
    public int[] solution(long n) {
        int length = String.valueOf(n).length();
        int[] answer = new int[length];

        int i = 0;

        while (n > 0) {
            answer[i++] = (int) (n % 10);
            n /= 10;
        }
        return answer;
    }
}
```

### 2. StringBuilder + for 문
```java
class Solution {
    public int[] solution(long n) {
        String str = new StringBuilder(String.valueOf(n))
                .reverse()
                .toString();

        int[] answer = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            answer[i] = str.charAt(i) - '0';
        }
        return answer;
    }
}
```

### 3. StringBuilder + Stream 
```java
class Solution {
    public int[] solution(long n) {
        return new StringBuilder(String.valueOf(n))
                .reverse()
                .toString()    
                .chars()
                .map(ch -> ch - '0')
                .toArray();
    }
}
```
| 실행 순서 | 메서드 | 반환 타입 | 결과 예시 |
|---|---|---|---|
| 1 | `String.valueOf(n)` | `String` | `"12345"` |
| 2 | `new StringBuilder(...)` | `StringBuilder` | `"12345"` |
| 3 | `.reverse()` | `StringBuilder` | `"54321"` |
| 4 | `.toString()` | `String` | `"54321"` |
| 5 | `.chars()` | `IntStream` | 53, 52, 51, 50, 49 |
| 6 | `.map(ch -> ch - '0')` | `IntStream` | 5, 4, 3, 2, 1 |
| 7 | `.toArray()` | `int[]` | `[5, 4, 3, 2, 1]` |