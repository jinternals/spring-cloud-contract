import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should register an account."
    request {
        method 'POST'
        url '/api/user'
        body(
                "email": $(consumer(regex(email())), producer("pandeymradul@gmail.com")),
                "firstName": "mradul",
                "lastName": "pandey",
                "gender": "MALE"
        )
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
    response {
        status 200
        body(
                "id": $(consumer('9febab1c-6f36-4a0b-88d6-3b6a6d81cd4a'), producer(regex('[0-9a-zA-z]{8}-[0-9a-zA-z]{4}-[0-9a-zA-z]{4}-[0-9a-zA-z]{4}-[0-9a-zA-z]{12}'))),
                "email": $(consumer("pandeymradul@gmail.com"), producer(regex(email()))),
                "firstName": "mradul",
                "lastName": "pandey",
                "gender": "MALE"
        )
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}