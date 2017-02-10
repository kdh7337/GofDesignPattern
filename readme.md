# Gof Design Patterns
###  재사용성, 유용성, 추상 구현 

# list:

 * Iterator
 * Adapter
 * Proxy
 * Template Method 
 * Factory Method
 * SingleTon
 * Strategy
 * Facade
 

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
 
## 

## Factory Method

### 인스턴스 생성 방식을 정한다. 

‘공장’

인스턴스가 생성되는 방식 절차를 정한다. 

#### 왜?: 미리 정해 높은 생성 방식의 변경 없이 세부 처리 과정만을 자유롭게 변경 할 수 있다. 인스턴스의 생성이 클래스를 특정하는 것으로부터 자유로워질 수 있다.

기본적인 생성자를 통한 인스턴스 생성은 특정 클래스에 한정되어 구현될 수 밖에 없다. 팩토리 메소드는 이로부터 자율성을 만들어 낼 수 있다. 

```java
abstract class Factory{
	public final Product newProduct(Object param){
        Product product = createProduct(param);
        processing();
        return product;
    }
    protected abstract Product createProduct(Object Param);
    protected abstract void processing();
}
``` 

#### Factory 추상 클래스

* 만들어질 객체의 생성, 기본 처리 과정을 담은 틀

#### Product 인터페이스

* 만들어질 객체

Template Method와 호환성이 좋다.

##

## Singleton

###클래스의 인스턴스를 단 한 개만 사용하고자 할 때 사용

'단 하나만’ 

외부에서의 인스턴스 생성을 막고 내부적으로 단 하나의 인스턴스만 생성해 사용

####왜?: 여러 개의 인스턴스가 만들어지는 것을 확실하게 방지해서 사용해야 할 때, 예를 들면 시스템 리소스를 사용하는 객체, 이러한 객체가 많을 경우 시스템에 부담을 줄 수있다.

```java
class Singleton{
    private static Singleton uniqueInstance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return uniqueInstance;
    }
}
```
#### Singleton 클래스
* 프라이빗 생성자
* 유일한 스태틱 인스턴스 
* 인스턴스 게터(getter);

외부에 단 하나의 인스턴스만을 만들어 사용한다는 것을 알리고, 이러한 사실에 대한 보장을 위해 사용된다.

##

## Strategy
  
###문제 해결을 위한 다양한 방법들을 즉각적으로 교체해 문제를 해결한다.
  
'전략’
  
문제 해결을 위해 고안된 알고리즘을 정해진 패턴에 따라 교체해서 쉽게 문제 해결한다.
  
#### 왜?: 내부 문제 해결 알고리즘과 프로그램의 구조를 분리시켜 유연한 문제해결을 가능하게 하기 위해서 
```java
Interface Strategy {
    void sovleProblem();
  	void saveResult();
} 
```
#### Strategy 인터페이스
* 미리 정해진 전략 사용 메소드

#### Player 클래스
* 전략 사용주체 

하나의 문제를 풀기 위해 다양한 전략을 구현할 수 있지만 하나의 일관된 구조 속에서 동작할 수 있다. 

하나의 플레이어가 다양한 전략을 가지고 상황에 따른 유연한 대처가 가능하게 할 수 있다. 

##

## Façade

### 복잡한 과정을 간단하게

‘창구, 정면’

복잡하게 얽혀 있는 구조와 사용법을 단순한 인터페이스로 표현한다.

#### 왜?: 프로그램의 규모가 커지면서 다양한 객체들이 복잡한 상호작용을 갖게 된다. 이러한 복잡한 연계과정을 단순한 메소드로 표현하여 사용성을 높일 수 있다.
```java
public class Façade{
	private ComponentA componentA = new ComponentA();
	private ComponentB componentB = new ComponentB();
	//그외 여러 요소들
	public void doComplexSimply(){
//요소들의 상호작용을 구현한다.
}
}
```
#### Façade 클래스
* 복잡한 객체 간의 상호작용을 간단한 메서드로 표현

인터페이스(메소드) 수를 줄이는데 핵심이 있다. 

Façade들로 새 Façade를 구현하는 것도 좋은 방법이 될 수 있다.

##

## Observer
### 상태 변화를 알려라, 감지하라 
‘관찰자’
관찰 대상의 상태 변화를 관찰자에게 전달하고 이에따라 관찰자가 적합한 액션을 취한다.
관찰보다는 전달
#### 왜?: 관찰 대상을 자유롭게 변화시킬 수 있다. 관찰 대상의 변화에 즉각적인 대응이 가능하도록 할 수 있다.
  
  ```java
  abstract class Observable {
    private Observer[] observers = new Observer[number];
    public void attachObserver(Observer observer){
        observers.add(observer);
    }
    public void doSomething(){
        //동작
        //완료
  		noticeToObsersers();
    }
      protected void noticeToObservers(){
          for(Observer observer : observers){
            observer.notice(this);
            }
        }
  }
  ```

어떠한 변화가 생겨나면 관찰자에게 관찰 대상의 참조를 전달한다. 

이를 통해 더욱 유연한 대처가 가능하다. 

#### 관찰자 추상 클래스 또는 인터페이스
* 관찰 대상의 변화에 대응하는 메소드
#### 관찰 대상 추상 클래스 또는 인터페이스
* 관찰자에게 변화를 전달하는 메소드

관찰 대상 자체를 ‘this’로 넘겨 관찰 대상에 어떠한 영향력을 행사할 수도 있다.

