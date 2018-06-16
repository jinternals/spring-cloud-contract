import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should get account by id."
    request {
        method 'GET'
        url $(consumer(regex('/api/user/[0-9a-zA-z]{8}-[0-9a-zA-z]{4}-[0-9a-zA-z]{4}-[0-9a-zA-z]{4}-[0-9a-zA-z]{12}' )), producer('/api/user/9febab1c-6f36-4a0b-88d6-3b6a6d81cd4a'))
        headers {
            header('Content-Type': 'application/vnd.user.api.v1+json')
            header('Accept': 'application/vnd.user.api.v1+json')
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
            header('Content-Type': 'application/vnd.user.api.v1+json;charset=UTF-8')
        }
    }
}