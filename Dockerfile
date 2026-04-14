# 1. 실행 환경 구성: 가벼운 Java 17 JRE 이미지 사용
FROM openjdk:17-jdk-slim

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 빌드된 JAR 파일을 컨테이너 내부로 복사
# Gradle 빌드 시 생성되는 파일명(0.0.1-SNAPSHOT.jar)을 app.jar로 변경하여 복사
COPY build/libs/*-SNAPSHOT.jar app.jar

# 4. 애플리케이션 실행 (Spring Boot)
ENTRYPOINT ["java", "-jar", "app.jar"]

# 5. 서비스 포트 노출 (기본 8080)
EXPOSE 8080
