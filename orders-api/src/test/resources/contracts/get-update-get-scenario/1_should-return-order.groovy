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
					id: 3,
					description: "old item"
				],
				[
					id: 4,
					description: "very old item"
				]
			]
		)
	}
}
