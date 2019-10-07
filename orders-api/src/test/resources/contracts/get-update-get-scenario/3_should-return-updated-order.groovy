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
			id: 2,
			merchantId: 2,
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
					partitions : [
						[
							status: 'SHIPPED'
						],
						[
							status: 'SHIPPED'
						]
					]
				]
			]
		)
	}
}
