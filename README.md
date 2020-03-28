# paysafe-api-client

Spring Boot project that integrates PaySafe API. The program is able to execute requests to some of the [Typical API Calls](https://developer.paysafe.com/en/classic-apis/3ds/typical-api-calls/verify-that-the-service-is-accessible/) endpoints through its own API.

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

```console
mvn clean install
java -jar target/paysafe-api-client-0.0.1-SNAPSHOT.jar
```

## API

Note that those APIs are executed against a mock server (`https://private-anon-eb6f38e9ae-paysafeapi3dsecurev1.apiary-mock.com`) which means that it doesn't matter what `account_id` will be used for the requests below.

```
http://localhost:8090/servicestatus
```

Makes `GET` request to `/threedsecure/monitor` and if the service is available, it will return `3DS Service Status: READY`.

```
http://localhost:8090/testaccount/enrollmentchecks
http://localhost:8090/accounts/{account_id}/enrollmentchecks
```

Makes `POST` request to `/threedsecure/v1/accounts/{account_id}/enrollmentchecks` using a hardcoded `EnrollmentCheck` object. After that checks if  the cardholder is enrolled in 3D Secure and returns one of the three options:
- Cardholder authentication available
- Cardholder not enrolled in authentication
- Cardholder authentication unavailable

```
http://localhost:8090/testaccount/enrollmentchecks/authentications
```

Makes `POST` request to `/threedsecure/v1/accounts/{account_id}/enrollmentchecks/{enrollmentcheck_id}/authentications` and returns one of the following authentication results:
- The cardholder successfully authenticated with their card issuer.
- The cardholder authentication was attempted.
- The cardholder failed to successfully authenticate with their card issuer.
- Authentication with the card issuer was unavailable.
- An error occurred during authentication.