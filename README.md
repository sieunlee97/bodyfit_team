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
**Language** : Java, Spring Boot+gradle, JavaScript, JQuery <br>
**Database** : MyBatis, MySQL <br>


-----

## :mag_right: 설명

### 메인화면
인바디 검사와 식단입력은 회원가입 후 로그인 시 이용 가능하며, 게시판 보기는 비회원도 이용 가능합니다.

<figure>
  <img src="https://user-images.githubusercontent.com/63999784/132992425-4dd852a9-a3db-425e-9341-e6ccca6bb699.PNG">
</figure>


### 1. 인바디 검사
회원가입 완료 후 로그인 시, 이용 가능합니다.

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
  <img src="https://user-images.githubusercontent.com/63999784/132988738-0845ec4b-df9e-4ee7-9794-da284cfd268d.PNG">
</figure>
:bangbang: 총 7개의 항목 : 성별, 나이,키, 몸무게, 현재 체지방률, 목표 체지방률, 운동량, 다이어트 타입, 목표 기간 <br>
:bangbang: 항목을 모두 입력하면 입력한 데이터를 기반으로 결과가 도출됩니다.<br>

#### 1-4 인바디 결과

### 2. 식단
#### 2-1 식단 메인
#### 2-2 식단 입력
