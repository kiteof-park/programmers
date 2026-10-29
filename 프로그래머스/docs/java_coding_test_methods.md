# Java 코딩테스트 필수 메서드 치트시트

> 기준: Java 21. 자주 쓰는 **메서드 중심**으로 클래스별 정리. 예제는 필요한 변수와 `import`가 이미 준비되어 있다고 가정한 짧은 코드 조각입니다.
>
> 자주 쓰는 import: `import java.util.*;` / `import java.util.stream.*;` / `import java.math.*;`

## 0. 빠른 타입 구분

| 자료형 | 길이/크기 | 요소 접근 | 비고 |
|---|---|---|---|
| `String` | `s.length()` | `s.charAt(i)` | 불변 문자열 |
| 배열 `int[]` | `arr.length` | `arr[i]` | 길이가 고정됨 |
| `List<T>` | `list.size()` | `list.get(i)` | `List.of()`는 수정 불가 |
| `Map<K,V>` | `map.size()` | `map.get(key)` | 키/값 구조 |
| `Set<T>` | `set.size()` | — | 중복 허용 안 함 |

## 1. String — 문자열 처리

| 메서드 | 용도 | 간단한 예시 | 결과 |
|---|---|---|---|
| `length()` | 길이 | `"hello".length()` | `5` |
| `charAt(i)` | 문자 조회 | `"abc".charAt(1)` | `'b'` |
| `substring(a,b)` | a 이상 b 미만 부분 문자열 | `"abcdef".substring(1,4)` | `"bcd"` |
| `substring(a)` | a부터 끝까지 | `"abcde".substring(2)` | `"cde"` |
| `indexOf(x)` | 첫 위치 검색 | `"banana".indexOf("na")` | `2` |
| `lastIndexOf(x)` | 마지막 위치 검색 | `"banana".lastIndexOf("na")` | `4` |
| `contains(x)` | 포함 여부 | `"hello".contains("ell")` | `true` |
| `startsWith(x)` | 접두어 확인 | `"hello".startsWith("he")` | `true` |
| `endsWith(x)` | 접미어 확인 | `"hello".endsWith("lo")` | `true` |
| `equals(x)` | 문자열 값 비교 | `"abc".equals("abc")` | `true` |
| `equalsIgnoreCase(x)` | 대소문자 무시 비교 | `"AbC".equalsIgnoreCase("abc")` | `true` |
| `compareTo(x)` | 사전순 비교 | `"abc".compareTo("abd")` | 음수 |
| `toUpperCase()` | 대문자로 | `"ab".toUpperCase()` | `"AB"` |
| `toLowerCase()` | 소문자로 | `"AB".toLowerCase()` | `"ab"` |
| `trim()` | 양끝 기본 공백 제거 | `"  hi  ".trim()` | `"hi"` |
| `strip()` | 양끝 유니코드 공백 제거 | `"  hi  ".strip()` | `"hi"` |
| `replace(a,b)` | 리터럴 치환 | `"a-b".replace("-", "")` | `"ab"` |
| `replaceAll(regex,repl)` | 정규식 치환 | `"a1b2".replaceAll("[0-9]", "")` | `"ab"` |
| `split(regex)` | 구분자로 나눔 | `"a,b,c".split(",")` | `String[]{"a","b","c"}` |
| `toCharArray()` | `char[]`로 변환 | `"12".toCharArray()` | `{'1','2'}` |
| `isEmpty()` | 길이가 0인지 | `"".isEmpty()` | `true` |
| `isBlank()` | 공백만 있는지 | `"   ".isBlank()` | `true` |
| `repeat(n)` | 문자열 반복 | `"ab".repeat(3)` | `"ababab"` |
| `String.valueOf(x)` | 숫자 등 → 문자열 | `String.valueOf(123L)` | `"123"` |
| `String.join(delim, ...)` | 문자열 연결 | `String.join("-", "a", "b")` | `"a-b"` |

```java
String s = "12345";
int[] digits = new int[s.length()];
for (int i = 0; i < s.length(); i++) {
    digits[i] = s.charAt(i) - '0'; // 숫자 문자 → 정수
}
// digits: [1, 2, 3, 4, 5]
```

> `split()`은 `String[]`를 반환하고 `toCharArray()`는 `char[]`를 반환합니다. 문자열 값 비교는 보통 `==`가 아니라 `equals()`를 사용합니다.

## 2. StringBuilder — 문자열 조립/뒤집기

| 메서드 | 용도 | 간단한 예시 | 결과 |
|---|---|---|---|
| `append(x)` | 뒤에 추가 | `new StringBuilder("a").append(1)` | `"a1"` |
| `reverse()` | 뒤집기 | `new StringBuilder("123").reverse()` | `"321"` |
| `insert(i,x)` | 위치에 삽입 | `new StringBuilder("ac").insert(1,"b")` | `"abc"` |
| `delete(a,b)` | 범위 삭제 | `new StringBuilder("abcd").delete(1,3)` | `"ad"` |
| `deleteCharAt(i)` | 문자 한 개 삭제 | `new StringBuilder("abc").deleteCharAt(1)` | `"ac"` |
| `setCharAt(i,c)` | 문자 변경 | `sb.setCharAt(0, 'X')` | 원본 `sb` 변경 |
| `charAt(i)` | 문자 조회 | `new StringBuilder("abc").charAt(2)` | `'c'` |
| `length()` | 길이 | `new StringBuilder("hi").length()` | `2` |
| `toString()` | `String` 변환 | `new StringBuilder("hi").toString()` | `"hi"` |

```java
String reversed = new StringBuilder("12345").reverse().toString(); // "54321"
StringBuilder sb = new StringBuilder();
for (int x : new int[]{1, 2, 3}) sb.append(x);
String joined = sb.toString(); // "123"
```

## 3. Character — 문자 판별/변환

| 메서드/표현식 | 용도 | 예시 | 결과 |
|---|---|---|---|
| `Character.isDigit(c)` | 숫자 문자 확인 | `Character.isDigit('7')` | `true` |
| `Character.isLetter(c)` | 글자 확인 | `Character.isLetter('A')` | `true` |
| `Character.isLetterOrDigit(c)` | 문자 또는 숫자 | `Character.isLetterOrDigit('3')` | `true` |
| `Character.isUpperCase(c)` | 대문자 여부 | `Character.isUpperCase('A')` | `true` |
| `Character.isLowerCase(c)` | 소문자 여부 | `Character.isLowerCase('a')` | `true` |
| `Character.toUpperCase(c)` | 대문자로 | `Character.toUpperCase('b')` | `'B'` |
| `Character.toLowerCase(c)` | 소문자로 | `Character.toLowerCase('B')` | `'b'` |
| `Character.getNumericValue(c)` | 숫자값 | `Character.getNumericValue('8')` | `8` |
| `c - '0'` | ASCII 숫자 문자 → int | `'8' - '0'` | `8` |

> `Character.isDigit()`는 ASCII 이외의 유니코드 숫자도 인식합니다. `'0' <= c && c <= '9'`는 0~9만 검사합니다.

## 4. Integer / Long / Double — 숫자 변환과 비교

| 메서드 | 용도 | 간단한 예시 | 결과 |
|---|---|---|---|
| `Integer.parseInt(s)` | 문자열 → `int` | `Integer.parseInt("+123")` | `123` |
| `Long.parseLong(s)` | 문자열 → `long` | `Long.parseLong("12345")` | `12345L` |
| `Double.parseDouble(s)` | 문자열 → `double` | `Double.parseDouble("1.5")` | `1.5` |
| `Integer.toString(n)` | 정수 → 문자열 | `Integer.toString(12)` | `"12"` |
| `Long.toString(n)` | long → 문자열 | `Long.toString(12L)` | `"12"` |
| `Integer.compare(a,b)` | 안전한 정수 비교 | `Integer.compare(2, 5)` | 음수 |
| `Long.compare(a,b)` | long 비교 | `Long.compare(5L, 2L)` | 양수 |
| `Integer.bitCount(n)` | 이진수의 1 개수 | `Integer.bitCount(7)` | `3` |
| `Integer.toBinaryString(n)` | 2진 문자열 | `Integer.toBinaryString(10)` | `"1010"` |
| `Integer.parseInt(s, radix)` | 다른 진법 → 정수 | `Integer.parseInt("1010", 2)` | `10` |

> `parseInt()`는 `"+12"`, `"-12"`도 처리합니다. 범위를 벗어나거나 숫자가 아닌 문자열이면 `NumberFormatException`이 발생합니다.

## 5. Math — 수학 연산

| 메서드 | 용도 | 간단한 예시 | 결과 |
|---|---|---|---|
| `Math.abs(x)` | 절댓값 | `Math.abs(-7)` | `7` |
| `Math.max(a,b)` | 큰 값 | `Math.max(3, 9)` | `9` |
| `Math.min(a,b)` | 작은 값 | `Math.min(3, 9)` | `3` |
| `Math.pow(a,b)` | 거듭제곱 (double) | `Math.pow(2, 3)` | `8.0` |
| `Math.sqrt(x)` | 제곱근 (double) | `Math.sqrt(81)` | `9.0` |
| `Math.ceil(x)` | 올림 (double) | `Math.ceil(2.1)` | `3.0` |
| `Math.floor(x)` | 내림 (double) | `Math.floor(2.9)` | `2.0` |
| `Math.round(x)` | 반올림 | `Math.round(2.6)` | `3` (`long`) |
| `Math.gcd(a,b)` | 없음 (Java 표준 Math) | 아래 유클리드 호제법 참고 | — |

```java
// 두 정수의 최대공약수(GCD): 유클리드 호제법
int a = 24, b = 18;
while (b != 0) {
    int temp = a % b;
    a = b;
    b = temp;
}
System.out.println(a); // 6
```

> `Math.pow()`는 `double`을 반환합니다. 정수의 정확한 거듭제곱이 중요하면 반복 곱셈이나 오버플로 검사를 고려하세요. `Math.abs(Integer.MIN_VALUE)`는 여전히 음수입니다.

## 6. Arrays — 배열 정렬/탐색/복사/출력

| 메서드 | 용도 | 간단한 예시 | 결과 |
|---|---|---|---|
| `Arrays.sort(a)` | 오름차순 정렬 | `int[] a={3,1,2}; Arrays.sort(a);` | `[1,2,3]` |
| `Arrays.binarySearch(a,x)` | 정렬 배열에서 이진 탐색 | `Arrays.binarySearch(new int[]{1,3,5},3)` | `1` |
| `Arrays.copyOf(a,len)` | 원하는 길이로 복사 | `Arrays.copyOf(new int[]{1,2},3)` | `[1,2,0]` |
| `Arrays.copyOfRange(a,s,e)` | s 이상 e 미만 복사 | `Arrays.copyOfRange(new int[]{1,2,3},1,3)` | `[2,3]` |
| `Arrays.fill(a,x)` | 모든 원소 채우기 | `int[] a=new int[3]; Arrays.fill(a,7);` | `[7,7,7]` |
| `Arrays.equals(a,b)` | 배열 내용 비교 | `Arrays.equals(new int[]{1},new int[]{1})` | `true` |
| `Arrays.toString(a)` | 1차원 배열 출력용 | `Arrays.toString(new int[]{1,2})` | `"[1, 2]"` |
| `Arrays.deepToString(a)` | 다차원 배열 출력용 | `Arrays.deepToString(new int[][]{{1},{2}})` | `"[[1], [2]]"` |
| `Arrays.stream(a)` | 기본형 배열 Stream 생성 | `Arrays.stream(new int[]{1,2,3}).sum()` | `6` |

```java
int[] a = {4, 1, 3, 2};
Arrays.sort(a);                      // [1, 2, 3, 4]
int index = Arrays.binarySearch(a, 3); // 2
```

> `binarySearch()` 전에 오름차순 정렬해야 합니다. `int[]`는 `Arrays.sort()`로 바로 내림차순 정렬할 수 없습니다. `Integer[]`라면 `Arrays.sort(a, Comparator.reverseOrder())`를 사용할 수 있습니다.

## 7. List / ArrayList — 동적 크기 목록

| 메서드 | 용도 | 간단한 예시 | 결과 |
|---|---|---|---|
| `add(x)` | 요소 추가 | `list.add(5)` | 목록 끝에 5 추가 |
| `add(i,x)` | 특정 위치 삽입 | `list.add(0, 9)` | 앞에 9 삽입 |
| `get(i)` | 요소 조회 | `list.get(0)` | 첫 원소 |
| `set(i,x)` | 요소 교체 | `list.set(0, 10)` | 0번 요소 변경 |
| `remove(i)` | 인덱스로 삭제 | `list.remove(0)` | 첫 원소 삭제 |
| `remove(Object)` | 값으로 삭제 | `list.remove(Integer.valueOf(3))` | 값 3 하나 삭제 |
| `size()` | 요소 개수 | `List.of(1,2).size()` | `2` |
| `contains(x)` | 포함 여부 | `List.of(1,2).contains(2)` | `true` |
| `indexOf(x)` | 첫 위치 | `List.of(5,6).indexOf(6)` | `1` |
| `isEmpty()` | 비어 있는지 | `List.of().isEmpty()` | `true` |
| `sort(cmp)` | 정렬 | `list.sort(Comparator.reverseOrder())` | 내림차순 |
| `subList(s,e)` | 부분 리스트 뷰 | `List.of(1,2,3).subList(1,3)` | `[2,3]` |
| `reversed()` | 역순 뷰 (Java 21) | `List.of(1,2,3).reversed()` | `[3,2,1]` |
| `toArray(new T[0])` | 객체 배열로 변환 | `List.of("a","b").toArray(new String[0])` | `String[]` |

```java
List<Integer> list = new ArrayList<>(List.of(3, 1, 2));
list.sort(Comparator.reverseOrder()); // [3, 2, 1]
Collections.reverse(list);             // [1, 2, 3] (원본 변경)
```

> `List.of(...)`는 수정 불가능합니다. `List<Integer>`에서 `remove(1)`은 **인덱스 1 삭제**이고, 값 1을 삭제하려면 `remove(Integer.valueOf(1))`을 사용합니다.

## 8. Collections / Comparator — 정렬 및 빈도

| 메서드 | 용도 | 간단한 예시 | 결과 |
|---|---|---|---|
| `Collections.sort(list)` | List 오름차순 정렬 | `Collections.sort(list)` | 원본 변경 |
| `Collections.reverse(list)` | List 순서 뒤집기 | `Collections.reverse(list)` | 원본 변경 |
| `Collections.max(list)` | 최댓값 | `Collections.max(List.of(3,1,2))` | `3` |
| `Collections.min(list)` | 최솟값 | `Collections.min(List.of(3,1,2))` | `1` |
| `Collections.frequency(list,x)` | 특정 값 빈도 | `Collections.frequency(List.of(1,2,1),1)` | `2` |
| `Comparator.reverseOrder()` | 내림차순 비교기 | `list.sort(Comparator.reverseOrder())` | 내림차순 |
| `Comparator.comparingInt(f)` | 정수 키 기준 정렬 | `words.sort(Comparator.comparingInt(String::length))` | 길이순 |

```java
List<String> words = new ArrayList<>(List.of("pear", "a", "cat"));
words.sort(Comparator.comparingInt(String::length)); // [a, cat, pear]
// 길이가 같으면 사전순:
words.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
```

## 9. Map / HashMap — 개수 세기, 키-값 저장

| 메서드 | 용도 | 간단한 예시 |
|---|---|---|
| `put(k,v)` | 추가/덮어쓰기 | `map.put("a", 1)` |
| `get(k)` | 값 조회 | `map.get("a")` |
| `getOrDefault(k,def)` | 없는 키에 기본값 | `map.getOrDefault("b", 0)` → `0` |
| `containsKey(k)` | 키 존재 확인 | `map.containsKey("a")` |
| `containsValue(v)` | 값 존재 확인 | `map.containsValue(1)` |
| `remove(k)` | 키 삭제 | `map.remove("a")` |
| `keySet()` | 키 모음 | `for (String k : map.keySet()) { ... }` |
| `values()` | 값 모음 | `for (int v : map.values()) { ... }` |
| `entrySet()` | 키·값 함께 순회 | `for (var e : map.entrySet()) { ... }` |
| `merge(k,v,fn)` | 기존 값과 결합 | `map.merge("a", 1, Integer::sum)` |
| `putIfAbsent(k,v)` | 키가 없을 때만 추가 | `map.putIfAbsent("a", 0)` |

```java
Map<Character, Integer> count = new HashMap<>();
for (char c : "banana".toCharArray()) {
    count.put(c, count.getOrDefault(c, 0) + 1);
    // 또는 count.merge(c, 1, Integer::sum);
}
// a=3, b=1, n=2 (HashMap의 순서는 보장되지 않음)
```

> `HashMap`은 순서가 보장되지 않습니다. 삽입 순서가 중요하면 `LinkedHashMap`, 키 정렬이 필요하면 `TreeMap`을 검토하세요.

## 10. Set / HashSet — 중복 제거/존재 확인

| 메서드 | 용도 | 간단한 예시 |
|---|---|---|
| `add(x)` | 추가 (`true`면 신규) | `set.add(3)` |
| `contains(x)` | 포함 여부 | `set.contains(3)` |
| `remove(x)` | 요소 삭제 | `set.remove(3)` |
| `size()` | 고유 요소 수 | `set.size()` |
| `isEmpty()` | 비었는지 | `set.isEmpty()` |

```java
Set<Integer> set = new HashSet<>(List.of(1, 2, 2, 3));
System.out.println(set.size()); // 3
```

> `HashSet`은 순서 보장 X. `LinkedHashSet`은 삽입 순서, `TreeSet`은 정렬 순서를 유지합니다.

## 11. Queue / Deque / ArrayDeque — BFS, 스택, 양끝 처리

| 메서드 | 용도 | 간단한 예시 |
|---|---|---|
| `offer(x)` | 큐 뒤에 추가 | `q.offer(10)` |
| `poll()` | 앞 요소 꺼내고 삭제, 비면 null | `q.poll()` |
| `peek()` | 앞 요소 확인, 비면 null | `q.peek()` |
| `addFirst(x)` | 앞에 추가 | `dq.addFirst(1)` |
| `addLast(x)` | 뒤에 추가 | `dq.addLast(2)` |
| `pollFirst()` | 앞에서 제거 | `dq.pollFirst()` |
| `pollLast()` | 뒤에서 제거 | `dq.pollLast()` |
| `push(x)` | 스택처럼 위에 추가 | `dq.push(3)` |
| `pop()` | 스택처럼 위에서 꺼냄 | `dq.pop()` |

```java
Queue<Integer> q = new ArrayDeque<>();
q.offer(1);
q.offer(2);
System.out.println(q.poll()); // 1 (FIFO)

Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);
stack.push(2);
System.out.println(stack.pop()); // 2 (LIFO)
```

> 코딩테스트에서 단순 큐·스택은 보통 `ArrayDeque`를 추천합니다. `ArrayDeque`는 `null` 요소를 허용하지 않습니다.

## 12. PriorityQueue — 우선순위 큐/힙

| 메서드 | 용도 | 간단한 예시 |
|---|---|---|
| `offer(x)` | 삽입 | `pq.offer(5)` |
| `peek()` | 우선순위 가장 높은 값 조회 | `pq.peek()` |
| `poll()` | 우선순위 가장 높은 값 추출 | `pq.poll()` |
| `size()` | 요소 수 | `pq.size()` |

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(5);
minHeap.offer(1);
System.out.println(minHeap.poll()); // 1

PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
maxHeap.offer(5);
maxHeap.offer(1);
System.out.println(maxHeap.poll()); // 5
```

> `PriorityQueue`는 반복 조회 시 전체 정렬 순서를 보장하지 않습니다. 우선순위 순서대로 얻으려면 `poll()`을 반복하세요.

## 13. Stream / IntStream — 필터링, 변환, 집계

| 메서드 | 용도 | 간단한 예시 | 결과 |
|---|---|---|---|
| `Arrays.stream(arr)` | 배열 → Stream | `Arrays.stream(new int[]{1,2,3})` | `IntStream` |
| `filter(p)` | 조건에 맞는 요소만 | `IntStream.of(1,2,3).filter(x -> x%2==1).toArray()` | `[1,3]` |
| `map(f)` | 각 요소 변환 | `IntStream.of(1,2).map(x -> x*10).toArray()` | `[10,20]` |
| `mapToInt(f)` | 객체 → IntStream | `List.of("a","abc").stream().mapToInt(String::length).sum()` | `4` |
| `mapToLong(f)` | 객체 → LongStream | `List.of(1L,2L).stream().mapToLong(Long::longValue).toArray()` | `long[]{1,2}` |
| `sorted()` | 오름차순 | `IntStream.of(3,1,2).sorted().toArray()` | `[1,2,3]` |
| `distinct()` | 중복 제거 | `IntStream.of(1,1,2).distinct().toArray()` | `[1,2]` |
| `sum()` | 합계 (`IntStream` 등) | `IntStream.of(1,2,3).sum()` | `6` |
| `average()` | 평균 (`OptionalDouble`) | `IntStream.of(1,2,3).average().orElse(0)` | `2.0` |
| `max()` / `min()` | 최댓값/최솟값 Optional | `IntStream.of(1,5).max().orElse(0)` | `5` |
| `count()` | 요소 개수 | `IntStream.of(1,2).count()` | `2L` |
| `anyMatch(p)` | 하나라도 만족 | `IntStream.of(1,2).anyMatch(x -> x>1)` | `true` |
| `allMatch(p)` | 모두 만족 | `IntStream.of(1,2).allMatch(x -> x>0)` | `true` |
| `toArray()` | 기본형 배열로 | `IntStream.of(1,2).toArray()` | `int[]{1,2}` |
| `toList()` | 객체 Stream → List | `Stream.of("a","b").toList()` | `[a,b]` |
| `range(a,b)` | a 이상 b 미만 | `IntStream.range(1,4).toArray()` | `[1,2,3]` |
| `rangeClosed(a,b)` | a 이상 b 이하 | `IntStream.rangeClosed(1,3).toArray()` | `[1,2,3]` |

```java
// 숫자 문자를 역순 int[]로
int[] digits = new StringBuilder("12345")
        .reverse().toString().chars()
        .map(c -> c - '0')
        .toArray(); // [5,4,3,2,1]
```

> `IntStream.toArray()`는 `int[]`를 반환하지만 일반 `Stream<T>.toArray()`는 인수가 없으면 `Object[]`를 반환합니다. Stream은 최종 연산 후 재사용할 수 없습니다. `Stream.toList()`는 수정 불가능한 목록을 반환합니다.

## 14. Optional 계열 — 값이 없을 수도 있는 결과 처리

| 메서드 | 용도 | 간단한 예시 |
|---|---|---|
| `orElse(default)` | 값 없으면 기본값 | `IntStream.empty().max().orElse(-1)` → `-1` |
| `isPresent()` | 값 있는지 | `IntStream.of(3).max().isPresent()` → `true` |
| `getAsInt()` | OptionalInt 값 꺼냄 | `IntStream.of(3).max().getAsInt()` → `3` |
| `getAsDouble()` | OptionalDouble 값 꺼냄 | `IntStream.of(1,2).average().getAsDouble()` → `1.5` |

> `getAsInt()`/`getAsDouble()`은 값이 없으면 예외가 발생하므로 빈 배열 가능성이 있으면 `orElse()` 등을 사용하세요.

## 15. Arrays / Collections 외에 자주 쓰는 알고리즘 패턴

### 빈도수 배열 (문자 범위가 정해졌을 때)

```java
int[] freq = new int[26];
for (char c : "banana".toCharArray()) freq[c - 'a']++;
System.out.println(freq['a' - 'a']); // 3
```

### 숫자 자릿수 추출과 누적

```java
long n = 12345L;
long sum = 0;
while (n > 0) {
    sum += n % 10;
    n /= 10;
}
System.out.println(sum); // 15
```

### 정수를 연결하여 큰 숫자 만들기

```java
long result = 0;
for (int digit : new int[]{5, 4, 3}) {
    result = result * 10 + digit;
}
System.out.println(result); // 543
```

### 투 포인터 (정렬 배열)

```java
int[] a = {1, 2, 4, 6};
int left = 0, right = a.length - 1;
while (left < right) {
    int sum = a[left] + a[right];
    if (sum == 8) break;
    if (sum < 8) left++;
    else right--;
}
```

### 누적 합

```java
int[] a = {2, 3, 5};
long[] prefix = new long[a.length + 1];
for (int i = 0; i < a.length; i++) prefix[i + 1] = prefix[i] + a[i];
long rangeSum = prefix[3] - prefix[1]; // a[1] + a[2] = 8
```

## 16. 실수 방지 체크리스트

- [ ] `int`끼리 곱하거나 더하면 **대입 대상이 long이어도** 연산 자체는 int로 이루어짐: `(long) a * b`처럼 연산 전에 형변환.
- [ ] `a += longValue`는 자동으로 왼쪽 타입으로 좁혀질 수 있어 오버플로 주의.
- [ ] `char` 숫자는 `(int)'5' == 53`, 숫자값 `5`가 필요하면 `'5' - '0'`.
- [ ] `String`은 `.length()`, 배열은 `.length`, List는 `.size()`.
- [ ] `List<Integer>.remove(1)`은 값 1이 아닌 **인덱스 1** 삭제.
- [ ] `Arrays.binarySearch()`는 **정렬된 배열** 전제.
- [ ] `HashMap`, `HashSet`의 순서는 보장되지 않음.
- [ ] 빈 Stream의 `average()`, `max()`는 값이 없는 Optional을 반환할 수 있음.
- [ ] 단순한 반복을 Stream으로 바꾼다고 무조건 빠르거나 읽기 쉬워지는 것은 아님.
- [ ] `%` 연산에서 음수의 나머지에 주의 (`-3 % 2 == -1`).
- [ ] `n = 0`일 때 자릿수 추출용 `while (n > 0)`는 실행되지 않음.

---

**추천 학습 순서:** `String` → `StringBuilder` → `Arrays` → `List` → `Map/Set` → `Deque/PriorityQueue` → `Stream`.
