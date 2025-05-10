# community_feed_service

## 📌 프로젝트 개요
커뮤니티 사용자들이 게시글(Post)을 작성하고, 댓글(Comment)을 통해 소통할 수 있는 피드 기반 커뮤니티 백엔드 API 서버입니다.  
사용자 인증 없이 자유롭게 사용할 수 있으며, CRUD 중심의 기능을 통해 RESTful API 설계 및 테스트, QueryDSL 적용 경험을 목적으로 합니다.

## 주요 기능
- 사용자(User) 등록 및 조회
- 게시글(Post) 작성, 수정, 삭제, 조회
- 댓글(Comment) 작성, 수정, 삭제, 조회
- QueryDSL을 통한 조건 기반 게시글 검색

## 🔧 개선 예정 사항
- Spring Security 도입
- JWT 인증 기능 추가
- 게시글 검색 필터 개선 (페이징, 정렬, 조건 추가)
- Docker 환경 구성

# 🛠️ 기술 스택 (Tech Stack)

## Backend
- Java 17
- Spring Boot: spring-boot-starter, spring-boot-starter-web, spring-boot-starter-validation, spring-boot-starter-data-jpa
- Spring Validation: 사용자 입력 검증 처리
- Spring Data JPA: ORM 기반 데이터 접근 처리

## Database
- MySQL: 운영 환경 데이터베이스
- H2 Database: 테스트 및 개발용 인메모리 데이터베이스

## ORM & Query
- JPA (Java Persistence API): ORM 매핑
- QueryDSL: 타입 안정성과 동적 쿼리를 위한 SQL 빌더

## Build & Annotation
- Lombok: @Getter, @Setter, @Builder 등 반복 코드 제거
- Annotation Processor: Lombok 및 QueryDSL 코드 생성 지원

## Testing
- JUnit 5: 단위 테스트 프레임워크
- Spring Boot Test: 통합 테스트 환경
- REST Assured: REST API 테스트를 위한 DSL 기반 HTTP 클라이언트

# API 명세

## User
<img width="1454" alt="스크린샷 2025-05-11 오전 12 11 00" src="https://github.com/user-attachments/assets/5c9598dc-03c6-42e8-8fd7-7f64c08f8c6d" />

## Post
<img width="1452" alt="스크린샷 2025-05-11 오전 12 11 32" src="https://github.com/user-attachments/assets/61798c96-4786-49b3-aa5d-c1b2253e9400" />

## Comment
<img width="1452" alt="스크린샷 2025-05-11 오전 12 12 02" src="https://github.com/user-attachments/assets/996472b4-aeb7-40bd-8239-be93c226b588" />

