package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'PUT'
		headers {
			header(accept(), applicationJson())
		}
		url '/order/2'
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
	response {
		status 204
	}
}
