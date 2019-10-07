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
			id: 1,
			"merchantId": 1,
			items: [
				[
					id: 1,
					description: "wonderful item",
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
					id: 2,
					description: "useful item",
					partitions : [
						[
							status: 'ORDERED'
						],
						[
							status: 'ORDERED'
						],
						[
							status: 'ORDERED'
						]
					]
				],
				[
					id: 3,
					partitions : [
						[
							status: 'ORDERED'
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
