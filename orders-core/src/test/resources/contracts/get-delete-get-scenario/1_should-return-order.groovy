package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        headers {
            header(accept(), applicationJson())
        }
        url '/order/1'
    }
    response {
        status 200
        headers {
            header(contentType(), applicationJsonUtf8())
        }
        body(
                orderId: 1,
                items: [
                        [
                                itemId     : 1,
                                description: "wonderful item"
                        ],
                        [
                                itemId     : 2,
                                description: "useful item"
                        ]
                ]
        )
    }
}
