/**
 * Created by DoDo on 2017-02-10.
 */
public class IteratorPattern {
    /*기본적으로 반복자 패턴을 사용하는 이유는 반복 검색의 대상의 자료 구조에
    영향을 받지 않고 사용할 수 있다는 것이다.
    즉 각각의 구성을 부품화하여 유지 보수를 용이하게한다.
    */

    //note 반복자 인터페이스, 기본적으로 다음항 유무 여부, 다음항 반환 메소드가 있어야한다.
    interface Iterator{
        //반복자에서 현재 바라보고 있는 항 이란 개념이 있다 이는 인덱스로 표현될 수 있다.
        //hasNext()는 다음 항의 유무를 따진다, 하지만 이것이 현재 반환할 것이 없다는 의미는 아니다.
        boolean hasNext();
        // next()는 현재 인덱스에 해당하는 항을 반환하고 인덱스 값을 추가해(index++) 다음 항으로 포커스를 바꾼다.
        Object next();
    }
    //집합체 인터페이스, 사용할 반복자를 만들어내는 메소드를 포함한다.
    interface Aggregate {
        Iterator createIterator();
    }

    /*주의사항
    * next, hasNext라는 이름에 휘둘리지 말라.
    * next는 returnCurrentMoveFocusToNext가 더 정확하다 할 수 있다.
    * hasNext는 다음항의 유무 자체보다는 현재 인덱스와 전체 자료의 길이를 기준으로 하는 편이 적합 할 수있다.
    * */
}
