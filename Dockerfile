# 1. ビルド環境 (JDK 21 + Gradlew を使用)
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Gradle Wrapper 関連のファイルをコピー
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# 実行権限を付与
RUN chmod +x ./gradlew

# ソースコードをコピーしてビルド実行
COPY src src
RUN ./gradlew build -x test --no-daemon

# 2. 実行環境 (軽量 JRE 21)
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]