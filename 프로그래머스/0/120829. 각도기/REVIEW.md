### 야르한 풀이 아카이빙

#### 1. 삼항 연산자 활용
```java
class Solution {
    public int solution(int angle) {
        return angle == 180 ? 4 : angle < 90 ? 1 : angle == 90 ? 2 : angle > 90 ? 3 : 0;
    }
}

```

#### 2. switch-case문을 활용하고 싶다면?
```java
class Solution {
    public int solution(int angle) {
        int answer = 0;
        String gak = null;
        if(0 < angle && angle < 90){
            gak = "예각";
        };
        if(angle == 90){
            gak = "직각";
        };
        if(90 < angle && angle < 180){
            gak = "둔각";
        };
        if(angle == 180){
            gak = "평각";
        };


        switch(gak){
            case "예각":
                answer = 1;
                break;
            case "직각":
                answer = 2;
                break;
            case "둔각":
                answer = 3;
                break;
            case "평각":
                answer = 4;
                break;
        }
        return answer;
    };
}

```
