### 야르한 풀이 아카이빙

```java
class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        return num1 * 1000 / num2;
    }
}
```
- `* 1000` 을 먼저 해서 정수 연산만으로 답을 구한게 야르하다.

### 알고 넘어가야 할 것
#### 1. 산술 연산 규칙
- 정수 / 정수 = 정수 **(‼️결과의 소수점 이하는 버려짐)**
- 정수 / 실수 = 실수 **(‼️연산 결과는 `double`형)**
#### 2. 형변환
- 연산 이후 형변환 : `dobule result = (dobule)(7 / 3);` // 연산 결과 : 2.0
- 연산 이전 형변환 : `dobule result = (dobule)7 / 3;`   // 연산 결과 : 2.33333..
#### 3. 내 문제풀이의 연산 순서
```java
class Solution {
    public int solution(int num1, int num2) {
        return (int)(((double) num1 / num2) * 1000);

        // 사실 괄호 하나 빼도 됨
        return (int)((double) num1 / num2 * 1000);
  }
}
```
1. `(double) num1`
2. ` num1 / num2`
3. `* 1000`
4. `(int)`
