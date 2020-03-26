# paysafe-api-client

Spring Boot project that integrates PaySafe API. The program is able to execute requests to the [Typical API Calls](https://developer.paysafe.com/en/classic-apis/3ds/typical-api-calls/verify-that-the-service-is-accessible/) endpoints.

## Paysafe API

```
GET  ==> /threedsecure/monitor
POST ==> /threedsecure/v1/accounts/{account_id}/enrollmentchecks
GET  ==> /threedsecure/v1/accounts/{account_id}/enrollmentchecks/{enrollmentcheck_id}
POST ==> /threedsecure/v1/accounts/{account_id}/enrollmentchecks/{enrollmentcheck_id}/authentications
GET  ==> /threedsecure/v1/accounts/{account_id}/authentications/{authentication_id}
GET  ==> /threedsecure/v1/accounts/{account_id}/authentications/{authentication_id}?fields=enrollmentchecks
```

## TODO - add docs for the api calls