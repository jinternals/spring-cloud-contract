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
        body("""
        {
            "content":[
                        {
                        "email":"pandeymradul@gmail.com",
                        "firstName":"mradul",
                        "lastName":"pandey",
                        "gender":"MALE"
                        }
                      ],
            "last":true,
            "totalPages":1,
            "totalElements":1,
            "size":20,
            "number":0,
            "sort":null,
            "numberOfElements":1,
            "first":true
            }
        """)
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}