package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'POST'
		headers {
			header(contentType(), applicationJson())
		}
		url '/order'
		body(
			merchantId: 1,
			items: [
				[
					id: 1,
					description: "wonderful item",
					orderedQuantity: 4
				],
				[
					id: 2,
					description: "useful item",
					orderedQuantity: 2
				]
			]
		)
	}
	response {
		status 201
		body(
			id: anyNonBlankString(),
			merchantId: 1,
			items: [
				[
					id: 1,
					description: "wonderful item",
					partitions : [
						[
							status: 'ORDERED'
						],
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
				]
			]
		)
	}
}
