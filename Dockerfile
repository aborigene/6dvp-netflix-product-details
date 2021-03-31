from openjdk:17-buster

COPY target/product_details-0.0.1-SNAPSHOT.jar /

COPY testdb.mv.db /

COPY testdb.trace.db /

entrypoint ["java", "-jar", "/product_details-0.0.1-SNAPSHOT.jar"]

