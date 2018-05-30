import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should get all the registered account."
    request {
        method 'GET'
        url '/api/users'
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
    response {
        status 200
        body(
                "content": [
                        [
                                "id": $(consumer('9febab1c-6f36-4a0b-88d6-3b6a6d81cd4a'), producer(regex('[0-9a-zA-z]{8}-[0-9a-zA-z]{4}-[0-9a-zA-z]{4}-[0-9a-zA-z]{4}-[0-9a-zA-z]{12}'))),
                                "email"    : $(consumer("pandeymradul@gmail.com"), producer(regex(email()))),
                                "firstName": "mradul",
                                "lastName" : "pandey",
                                "gender"   : "MALE"
                        ]
                ],
                "last": true,
                "totalPages": 1,
                "totalElements": 1,
                "size": 20,
                "number": 0,
                "sort": null,
                "numberOfElements": 1,
                "first": true
        )
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}