# paysafe-api-client

Spring Boot project that integrates PaySafe API. The program is able to execute requests to the [Typical API Calls](https://developer.paysafe.com/en/classic-apis/3ds/typical-api-calls/verify-that-the-service-is-accessible/) endpoints through its own API.

## Paysafe API

```
GET  ==> /threedsecure/monitor
POST ==> /threedsecure/v1/accounts/{account_id}/enrollmentchecks
GET  ==> /threedsecure/v1/accounts/{account_id}/enrollmentchecks/{enrollmentcheck_id}
POST ==> /threedsecure/v1/accounts/{account_id}/enrollmentchecks/{enrollmentcheck_id}/authentications
GET  ==> /threedsecure/v1/accounts/{account_id}/authentications/{authentication_id}
GET  ==> /threedsecure/v1/accounts/{account_id}/authentications/{authentication_id}?fields=enrollmentchecks
```

## Build and run

```
mvn clean install
java -jar target/paysafe-api-client-0.0.1-SNAPSHOT.jar
```

## API

```
http://localhost:8090/servicestatus
```

> This API makes `GET` request to `/threedsecure/monitor` and if the service is available, it will return `3DS Service Status: READY`.