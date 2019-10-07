package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'PUT'
		headers {
			header(contentType(), applicationJson())
		}
		url '/order/2'
		body(
			items: [
				[
					id         : 3,
					description: "old item",
					partitions : [
						[
							status: 'SHIPPED'
						],
						[
							status: 'ORDERED'
						],
						[
							status: 'SHIPPED'
						],
						[
							status: 'SHIPPED'
						]
					]
				],
				[
					id         : 5,
					description: "new item",
					orderedQuantity: 3
				]
			]
		)
	}
	response {
		status 204
	}
}
