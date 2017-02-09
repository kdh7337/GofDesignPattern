# Gof Design Patterns


## list:

 * Iterator
 * Proxy

##

### Iterator


#### 집합을 순서대로 지정하면서 전체를 검색하는 처리.

‘반복자’

집합에 해당하는 Aggregate 인터페이스와 순환을 담당하는 반복자 Iterator로 구성된다.

##### 왜? : 구현과 분리한 사용을 위해

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

###

### Proxy

#### 앞서서 본 객체 대신 특정 수준까지 작업을 대신 처리
‘대리인’

어느 정도까지 일을 대신 처리하여 본 객체의 부담을 줄여준다. 

본 객체와 대리 객체(Proxy)는 같은 인터페이스를 공유한다.

본 객체가 처리해야할 경우에만 본 객체로 작업을 넘긴다.

본 객체가 처리해야하는 업무에 해당하는 메소드는 대리 객체가 본 객체의 해당 메소드를 호출하는 방법을 사용한다.  

#### 왜?: 대리인이 수행할 만한 일과 본 객체가 수행해야 할 일을 분할 관리하면서 동시에, 대리인이 수행해야할 일이 없는 경우 본 객체로 쉽게 사용 전환 할 수 있다.
```java
//대리인을 통한 구현 
Operator opertator = new OperatorProxy();
operator.doMinorJob(param1);
operator.doMainJob(param2);


//필요에 따라 본 객체를 통해 구현
Operator operator = new OperatorClient();
Operator.doMinorJob(param1);
Operator.doMainJob(param2)’
```

생성자만 변화하여 proxy기능의 사용여부를 조절할 수 있다.

#### Operator 인터페이스
* 외관으로 드러나는 처리 객체 형태이다.
* 대리인과 본 객체 (의뢰인) 모두 같은 인터페이스를 사용한다.
