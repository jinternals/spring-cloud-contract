import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should register an account."
    request {
        method 'POST'
        url '/api/user'
        body("""
        {
          "email":"pandeymradul@gmail.com",
          "firstName":"mradul",
          "lastName":"pandey",
          "gender":"MALE"
        }
        """)
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
    response {
        status 200
        body("""
        {
          "email":"pandeymradul@gmail.com",
          "firstName":"mradul",
          "lastName":"pandey",
          "gender":"MALE"
        }
        """)
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}