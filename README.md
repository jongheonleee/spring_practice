# spring_practice

### 01. Template Callback

- 템플릿 콜백 작동 흐름
<img src="https://github.com/user-attachments/assets/2dcd0626-42e7-4f92-b95e-8afea8a06b28" width="500" height="500"/>

- 현재 만든 템플릿 콜백 구조
<img src="https://github.com/user-attachments/assets/6e0108cd-1e4f-4ec4-b425-fe4600b39496" width="500" height="500"/>

- 템플릿 콜백 핵심
- Strategy Pattern & DI 동시에 적용한 것 
- 템플릿 콜백은 변경되는 부분을 오브젝트로 전달받아서 콜백을 호출하여 템플릿 작업을 처리하는 방식이다.
  - 템플릿 : 변경되지 않는 문맥
  - 콜백 : 변경되는 부분을 내부 익명 클래스로 정의한 것 


