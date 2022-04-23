try catch
    예외를 처리하기 위한 구문 
    try문에서 예외(Exception)가 발생한 경우 catch(Exception e)로 빠져서 그 안의 실행문을 실행한다

    printStackTrace()
    예외발생당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메세지를 콘솔화면에 출력한다.
    리턴값이 없다.

    중괄호가 많아져서 실무에서 잘 쓰지 않음
    아무리 코드를 잘 짜도 오류가 있는데 그러한 오류를 잡기위한 정말 세밀한 작업을 할 때 사용한다.

문법
    try {
        //예외발생할 가능성이 있는 문장 
    }catch(Exception1 e1) {
        //Exception1이 발생했을 경우, 이를 처리하기 위한 문장적는다. 
        //보통 이곳에 예외메세지를 출력하고 로그로 남김. 
        e.printStackTrace(); //예외정보 출력
    }catch(Exception2 e2) {
        //Exception2이 발생했을 경우, 이를 처리하기 위한 문장적는다. 
    }catch(ExceptionN eN) {
        //ExceptionN이 발생했을 경우, 이를 처리하기 위한 문장적는다. 
    }finally{
        //예외발생여부에 관계없이 상항 수행되어야 하는 문장적는다. 
    }

출처: https://cheershennah.tistory.com/147 [Today I Learned. @cheers_hena 치얼스헤나]