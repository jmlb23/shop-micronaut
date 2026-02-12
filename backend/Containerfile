FROM eclipse-temurin:21 as build

WORKDIR /build

COPY . .

RUN ./gradlew shadowJar --no-daemon --no-configuration-cache

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /build/app/build/libs/app-0.1-all.jar .

EXPOSE 8080

ENTRYPOINT ["java"]

CMD ["-jar", "app-0.1-all.jar"]
