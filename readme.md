# Gof Design Patterns


## list:

 * Iterator

##

### Iterator


#### 집합을 순서대로 지정하면서 전체를 검색하는 처리.

‘반복자’

집합에 해당하는 Aggregate 인터페이스와 순환을 담당하는 반복자 Iterator로 구성된다.

왜? : 구현과 분리한 사용을 위해

```java	
While(iterator.hasNext()){
		Iterator.next(); 
}
```

인터페이스이기 때문에 내부에 구현되는 집합의 자료형이 바뀌어도 다른 소스코드를 변경할 필요가 없다.

##### Aggregate 인터페이스: 집합체

* Iterator를 집합체당 하나의 Iterator를 사용하기 위한 메소드를 가지고있음
* Iteraotr 메소드를 통해 Iteraotr를 생성해 사용한다

##### Iterator 인터페이스 

* 루프와 같은 역할 수행
* Boolean hasNext() 다음 항이 있는지
* Object next(); 다음 항 반환 
