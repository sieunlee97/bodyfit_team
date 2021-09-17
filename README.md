# bodyfit

**스프링부트를 이용한 다이어트 관리 프로그램** <br>
간단한 인바디 검사를 통해 얻은 결과로 다이어트 계획을 세우고, 식단을 관리하는 프로그램.

## :high_brightness: 개요
**기간** : 2021.08.06 - 진행 중 <br>
**인원** : 1명 <br>
**산출물** : 기능명세서, 화면설계서, 기능명세서 <br>

**<개발환경>** <br>
**OS** : Windows <br>
**IDE** : STS4 <br>
**DB Tool** : Workbench <br>

**<사용기술>** <br>
**Front-end Language** : HTML5, CSS, JavaScript <br>
**Back-end Language** : Java, Spring Boot+gradle <br>
**Database** : MyBatis, MySQL <br>


-----

## :mag_right: 설명

### 메인화면
- 인바디 검사와 식단입력은 회원가입 후 로그인 시 이용 가능하며, 게시판 보기는 비회원도 이용 가능합니다.

<figure>
  <img src="https://user-images.githubusercontent.com/63999784/133044142-ba91b5ee-b24e-409c-9328-1f83bbe6302f.PNG">
</figure>

### 1. 인바디 검사
- 회원가입 완료 후 로그인 시, 이용 가능합니다.

#### 1-1 회원가입 
<figure>
  <p align="center"><img src="https://user-images.githubusercontent.com/63999784/132992378-d2b6e292-2853-4cc0-85ab-85f350e339b3.PNG"></p>
</figure>
:bangbang: 모든 항목은 유효성 검사가 적용되어있고 필수항목입니다.  <br>
:bangbang: 이메일과 닉네임 중복검사, 비밀번호는 영문 또는 숫자 8자리 이상이어야합니다.<br>

#### 1-2 로그인 
<figure>
  <p align="center"><img src="https://user-images.githubusercontent.com/63999784/132992375-df4a7ff8-9783-47b3-b026-f3620e5104fd.PNG"></p>
</figure>
:bangbang: 네이버 아이디 로그인은 구현중입니다. 

#### 1-3 인바디 검사
<figure>
  <img src="https://user-images.githubusercontent.com/63999784/133042251-35307772-91bb-4018-bc6d-7f01d826187f.PNG">
</figure>
:bangbang: 총 7개의 항목 : 성별, 나이,키, 몸무게, 현재 체지방률, 목표 체지방률, 운동량, 다이어트 타입, 목표 기간 <br>
:bangbang: 항목을 모두 입력하면 입력한 데이터를 기반으로 결과가 도출됩니다.<br>

#### 1-4 인바디 결과
- 인바디 검사 직후 확인 가능하며, 지난 결과 목록은 마이페이지의 인바디 결과 목록에서 확인 가능합니다.
<figure>
  <img src="https://user-images.githubusercontent.com/63999784/133040471-0e9a9ee4-2e05-45af-adc5-a11a8c194ec2.PNG">
</figure>
<figure>
  <img src="https://user-images.githubusercontent.com/63999784/133041681-c5cb73f5-c4a8-495f-82a5-ca376327faac.PNG">
</figure>

### 2. 식단
- 인바디 검사 후 이용 가능하며, 인바디 결과를 토대로 권장칼로리가 제공됩니다.

#### 2-1 식단 메인
<figure>
  <img src="https://user-images.githubusercontent.com/63999784/133040448-00c8d491-a2fa-4257-9f2c-ee0a4115fedd.PNG">
</figure>

#### 2-2 식단 입력
<figure>
  <img src="https://user-images.githubusercontent.com/63999784/133040462-5cef64f0-ae3d-4c1d-aa01-c1dad9297ad3.PNG">\
</figure>

:bangbang: 식품의약품안전처 식품영양성분DB OpenAPI 활용 예정<br>

#### 2-3 식단 목록

<figure>
  <img src="https://user-images.githubusercontent.com/63999784/133040458-57b42f2e-9014-4b8a-aba4-ea5f92b57485.PNG">
<figure>


### 3. 게시판
- 공지사항과 자유게시판으로 구분되며, 공지사항은 관리자권한만 등록 가능합니다.
- 공지사항 조회와 자유게시판 등록 및 조회는 모든 이용자가 가능합니다.
- 작성자 및 제목으로 검색 가능하고, 최신순 또는 좋아요 순으로 정렬할 수 있습니다.

#### 3-1 게시글 목록
<figure>
  <img src="https://user-images.githubusercontent.com/63999784/133043161-8612e7b0-542d-470f-8485-e7252030c923.PNG">
</figure>

#### 3-1 게시글 상세보기
<figure>
  <img src="https://user-images.githubusercontent.com/63999784/133043154-fbd4a50f-139e-41fd-8aec-c5e7823bfa57.PNG">
</figure>
  
:bangbang: 로그인한 사용자와 작성자의 닉네임이 일치할 때, 수정 및 삭제가 가능합니다. <br>
:bangbang: 좋아요 또는 싫어요를 누를 수 있습니다.
