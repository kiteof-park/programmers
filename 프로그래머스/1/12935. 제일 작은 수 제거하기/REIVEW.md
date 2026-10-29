## 뭐가 문제 였을까?
### 1트 - 실패
```java
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1 && arr[0] == 10){
            return new int[]{-1};
        }
        
        List<Integer> list = new ArrayList<>();
        int min  = 0;
        
        for(int i = 0; i < arr.length - 1; i++){
            list.add(arr[i]);
            min = arr[i] < arr[i + 1] ? arr[i] : arr[i + 1];
        }
        list.remove(Integer.valueOf(min));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
```
#### 1. 배열 길이가 1일 때의 조건
- 문제에서 요구하는건, 배열에 저장된 값이 중요한 게 아니라 배열의 길이가 1인지가 중요함
- 아니 그럼 문제를 제대로 내던가 ,,

#### 2. 최솟값을 구하는 로직
```java
min = arr[i] < arr[i + 1] ? arr[i] : arr[i + 1];
```
- 이 로직은 배열 전체에서 최소값을 찾지 않고, 인접한 두 원소 중 작은 값만 선택하는 로직

#### 3. List에 요소를 추가하는 반복 범위
```java
   for(int i = 0; i < arr.length - 1; i++){
            list.add(arr[i]);
            ...
    }
```
- 최소값을 구하는 로직에서 인접한 두 원소를 비교하기 위해 사용한 조건(`arr.length -`)
- `arr.length - 1`을 조건으로 사용하면 마지막 원소는 List에 추가되지 않음

### 2트 - 성공
```java
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        
        List<Integer> list = new ArrayList<>();
        int min  = arr[0];
        
        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
            if(arr[i] < min){
                min = arr[i];
            }
        }
        list.remove(Integer.valueOf(min));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
```
---
## 야르한 코드 아카이빙
```java
class Solution {
  public int[] solution(int[] arr) {
      if (arr.length <= 1) return new int[]{ -1 };

      int min = Arrays.stream(arr).min().getAsInt();

      return Arrays.stream(arr)
              .filter(i -> i != min)
              .toArray();
  }
}
```
