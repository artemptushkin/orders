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
			items: [
				[
					itemId: 3,
					description: "old item"
				],
				[
					itemId: 5,
					description: "new item"
				]
			]
		)
	}
}
