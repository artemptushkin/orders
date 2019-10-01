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
					id: 3,
					description: "old item"
				],
				[
					id: 5,
					description: "new item"
				]
			]
		)
	}
	response {
		status 204
	}
}
