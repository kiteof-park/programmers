### 문자열을 숫자로 바꾸기
| 변환               | 메서드                     | 반환타입   |
|------------------|-------------------------|--------|     
| `String` -> `int`   | `Integer.parseInt(str)`   | `int`    |
| `String` -> `long`  | `Long.parseLong(str)`     | `long`   |
| `String` -> `double` | `Double.parseDouble(str)` | `double` |
| `String` -> `float`  | `Float.parseFloat(str)`   | `float`  |


#### parseInt()의 레전드 기능
문자열을 정수로 해석할 때 맨 앞에 있는 `+`, `-` 부호까지 인식해줌 ,,  
처음에 케이스를 (1) `+` 부호가 있는 정수, (2) `+` 부호가 없는 양수, (3) `-` 부호가 있는 정수  
이렇게 세 개로 하려다가 그냥 써봤는데 채점되길래 야르 ~