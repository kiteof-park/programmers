### 야르한 코드 아카이빙

```java
import java.time.*;
class Solution {
    public int solution(int age) {
        LocalDate today = LocalDate.now();
        return today.getYear() - age + 1;
    }
}
```
