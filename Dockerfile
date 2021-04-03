from openjdk:17-buster

RUN mkdir /product_details

COPY target/product_details-0.0.1-SNAPSHOT.jar /product_details

COPY src/main/resources/moviedb.mv.db /product_details

COPY src/main/resources/moviedb.trace.db /product_details

COPY src/main/resources/application.properties /product_details

WORKDIR /product_details

entrypoint ["java", "-jar", "/product_details/product_details-0.0.1-SNAPSHOT.jar"]

