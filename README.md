# Quarkus JAR tree-shaking drops a class referenced only from an invokedynamic call site

`lib/` has a public interface whose constant is a lambda cast to a package-private sub-interface
(the same shape as `io.vertx.core.net.endpoint.LoadBalancer` in vertx-core 5.x). `Tagged` only
appears in the call site descriptor `()Lorg/acme/lib/Tagged;`.

```
mvn clean package
java -jar app/target/quarkus-app/quarkus-run.jar          # prints "selected"

mvn clean package -Dquarkus.package.jar.tree-shake.mode=classes
java -jar app/target/quarkus-app/quarkus-run.jar          # NoClassDefFoundError: org/acme/lib/Tagged

mvn clean package -Dquarkus.package.jar.tree-shake.mode=classes \
    -Dquarkus.package.jar.tree-shake.excluded-artifacts=org.acme:lib
java -jar app/target/quarkus-app/quarkus-run.jar          # prints "selected"
```

Quarkus 4.0.0.Beta1, Java 25.
