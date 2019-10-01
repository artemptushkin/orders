package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        headers {
            header(accept(), applicationJson())
        }
        url '/order/2'
    }
    response {
        status 200
        headers {
            header(contentType(), applicationJsonUtf8())
        }
        body(
                orderId: 2,
                items: [
                        [
                                itemId     : 3,
                                description: "old item"
                        ],
                        [
                                itemId     : 4,
                                description: "very old item"
                        ]
                ]
        )
    }
}
