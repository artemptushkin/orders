### Requirements

Build: jdk v.11

Run: jre v.11

### How to build

`./mvnw -pl orders-core clean install && mvn -pl orders-api clean package && mvn -pl status-api clean package`

### How to run

orders-api: `java -jar orders-api/target/orders-api-0.0.1-SNAPSHOT.jar`
status-api: `java -jar status-api/target/status-api-0.0.1-SNAPSHOT.jar`

### Call example / health verification

orders-api: `curl --request GET --url http://localhost:8080/order/2`\
status-api: `curl --request GET --url http://localhost:9090/status/order/1`

For REST API calls please see [orders-api DSL contracts](./orders-api/src/test/resources/contracts/)
and [status-api](./status-api/src/test/resources/contracts)

### Notes

* Orders-api starts with embedded MongoDB on demonstration purpose.
Please use `mongodb` spring profile to use real database 
* Mocks are loading by the `ApplicationStartedListener`

### TODO

1. Extract common interface for classes with `ru.example.orders.repository.domain.Status` to prevent logic duplication
at `ru.example.orders.controller.convertion.OrderStatusConverter : statusResolver.resolveStatus callas`

2. Reconsider database structure and status-api functionality.
Currently status-api is a part of `Item` and that's why has only a few sense to exist
