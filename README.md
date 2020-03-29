# paysafe-api-client

Spring Boot project that integrates PaySafe API. The program is able to execute requests to some of the [Typical API Calls](https://developer.paysafe.com/en/classic-apis/3ds/typical-api-calls/verify-that-the-service-is-accessible/) endpoints through its own API.

## Paysafe 3D Secure API

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

## Usage

> The APIs below are executed against a mock server: `https://private-anon-eb6f38e9ae-paysafeapi3dsecurev1.apiary-mock.com`

```
GET ==> http://localhost:8090/service-status
GET ==> http://localhost:8090/testaccount/enrollmentcheck
GET ==> http://localhost:8090/testaccount/enrollmentcheck/authentication
GET ==> http://localhost:8090/testaccount/authentication
```

#### Details

```
GET ==> http://localhost:8090/service-status
```

- Makes `GET` request to `/threedsecure/monitor` and if the service is available, it will return "3DS Service Status: READY".

```
GET ==> http://localhost:8090/testaccount/enrollmentcheck
```

- Makes `POST` request to `/threedsecure/v1/accounts/{account_id}/enrollmentchecks` using a test `account_id` and hardcoded `EnrollmentCheck` object. After that, checks if  the cardholder is enrolled in 3D Secure and returns one of the three options:
  - "Cardholder authentication available."
  - "Cardholder not enrolled in authentication."
  - "Cardholder authentication unavailable."

```
GET ==> http://localhost:8090/testaccount/enrollmentcheck/authentication
```

- Makes `POST` request to `/threedsecure/v1/accounts/{account_id}/enrollmentchecks/{enrollmentcheck_id}/authentications` using a test `account_id` and hardcoded `EnrollmentCheck` object. It returns one of the following authentication results:
  - "The cardholder successfully authenticated with their card issuer."
  - "The cardholder authentication was attempted."
  - "The cardholder failed to successfully authenticate with their card issuer."
  - "Authentication with the card issuer was unavailable."
  - "An error occurred during authentication."

```
GET ==> http://localhost:8090/testaccount/authentication
```

- Makes `GET` request to `/threedsecure/v1/accounts/{account_id}/authentications/{authentication_id}` using a test `account_id` and hardcoded `Authentication` object. If the `GET` is successful, it should return "Successfully retrieved authentication with id: 5d4db3bc-34c9-417f-a051-0d992ad9284e".
