# Gof Design Patterns
###  재사용성, 유용성

# list:

 * Iterator
 * Adapter
 * Proxy
 * Template 

##

## Iterator


### 집합을 순서대로 지정하면서 전체를 검색하는 처리.

‘반복자’

집합에 해당하는 Aggregate 인터페이스와 순환을 담당하는 반복자 Iterator로 구성된다.

#### 왜? : 구현과 분리한 사용을 위해

```java	
While(iterator.hasNext()){
		iterator.next(); 
}
```

인터페이스이기 때문에 내부에 구현되는 집합의 자료형이 바뀌어도 다른 소스코드를 변경할 필요가 없다.

#### Aggregate 인터페이스: 집합체

* Iterator를 집합체당 하나의 Iterator를 사용하기 위한 메소드를 가지고있음
* Iteraotr 메소드를 통해 Iteraotr를 생성해 사용한다

#### Iterator 인터페이스 

* 루프와 같은 역할 수행
* Boolean hasNext() 다음 항이 있는지
* Object next(); 다음 항 반환 

##

## Adapter 패턴

### 서로 다른(차이점) 두 가지 요소를 연결

‘개조자, 어댑터’

두 요소간 ‘차이점’을 해소하는 디자인 패턴, 감싸 사용한다는 면에서 Wrapper이기도 하다

#### 왜?: 이미 만들어진 클래스 또는 요소를 다른 환경에서 사용할 때 해당 요소를 적합한 요소로 다시 만들지 않고 바로 활용할 수 있게 만들 수 있다.

기존의 요소를 현재 필요한 요소로 바꾸기 (220v -> 110v)

#### Class Adapter 
* 사용할 요소와, 어댑터를 모두 구현한 클래스를 만들어 사용한다
```java
class Adapted extends Adaptee implements Adapter{
//구현
}
```
####Instance Adapter
* 사용할 요소를 어댑터 내에 인스턴스로 넣어 사용한다.
```java
class Adapted implements Adapter{
	Adaptee adaptee = new Adaptee();
//구현 
}
```
기존의 것을 직접 수정하지 않고 활용한다.

버전 간의 호환성.

##

## Proxy

### 앞서서 본 객체 대신 특정 수준까지 작업을 대신 처리
‘대리인’

어느 정도까지 일을 대신 처리하여 본 객체의 부담을 줄여준다. 

본 객체와 대리 객체(Proxy)는 같은 인터페이스를 공유한다.

본 객체가 처리해야할 경우에만 본 객체로 작업을 넘긴다.

본 객체가 처리해야하는 업무에 해당하는 메소드는 대리 객체가 본 객체의 해당 메소드를 호출하는 방법을 사용한다.  

### 왜?: 대리인이 수행할 만한 일과 본 객체가 수행해야 할 일을 분할 관리하면서 동시에, 대리인이 수행해야할 일이 없는 경우 본 객체로 쉽게 사용 전환 할 수 있다.
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

### Operator 인터페이스
* 외관으로 드러나는 처리 객체 형태이다.
* 대리인과 본 객체 (의뢰인) 모두 같은 인터페이스를 사용한다.

##

## Template


### 사용법을 미리 정하고 구체적인 구현은 후에 정해지는 패턴

‘틀’

상위 클래스에서 추상 메소드를 통해 어떠한 메소드가 있고 호출되는지를 미리 정한다. 구체적인 메소드의 구현은 하위 클래스에서 이루어진다.

#### 왜?: 구체적인 구현과 무관하게 일관된 로직 구조를 가질 수 있다. 만약 설계적인 측면에서 문제가 생길 경우 (템플렛 설계 문제) 개별적으로 구현된 경우보다 더 빠르게 수정을 할 수 있다. 

추상클래스의 적극적인 활용 예라 할 수도 있다. 
상위 클래스와 하위 클래스 중 어느 쪽에 로직을 더 많이 할당할지는 온전히 설계자의 몫이다.

#### Abstract 클래스: 틀

* 추상 메소드 
* 구체적인 운용 로직이 들어간 메소드
#### Concrete 클래스: 구현체 

* 추상 메소드가 구현된 클래스
 