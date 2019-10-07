package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		headers {
			header(accept(), applicationJson())
		}
		url '/order/4'
	}
	response {
		status 200
		headers {
			header(contentType(), applicationJsonUtf8())
		}
		body(
			id: 4,
			merchantId: 2,
			items: [
				[
					id: 3,
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
					id: 4,
					description: "very old item",
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
				]
			]
		)
	}
}
