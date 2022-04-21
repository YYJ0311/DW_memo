```
Iterator
    자바의 컬렉션 프레임워크에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화 했는데 그 중 하나
    
    Iterator는 인터페이스로 다음의 구성을 가진다
```
```java
    public interface Iterator{
        boolean hasNext();
        Object next();
        void remove();
    }
```
```
    boolean hasNext()
        읽어 올 요소가 남아있는지 확인하는 메소드
        있으면 true, 없으면 false 반환
    Object next()
        읽어 올 요소가 남아있는지 확인하는 메소드??
        있으면 true, 없으면 false 반환
    void remove()
        next()로 읽어 온 요소를 삭제함
        next()를 호출한 다음에 remove()를 호출해야 한다
```
```java
문법
    Iterator로 list의 모든 값을 가져온다

    ArrayList<Integer> list = new ArrayList<Integer>();
    for(Iterator<Integer> itr = list.iterator(); itr.hasNext();){
        list.get(itr.next());
    }
    또는
    ArrayList<Integer> list = new ArrayList<Integer>();
    Iterator<Integer> itr = list.iterator();
    while( itr.hasNext() ){
        list.get( itr.next() );
    }
```
```
단점
    자동으로 Index를 관리해주기 때문에 편리하지만 Iterator는 사용될때 객체를 만들기 때문에 list의 size를 사용하는 것보다 느리다.
```