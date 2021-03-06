package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		headers {
			header(accept(), applicationJson())
		}
		url '/status/merchant/4'
	}
	response {
		status 200
		headers {
			header(contentType(), applicationJsonUtf8())
		}
		body(
			merchantId: 4,
			orders: [
			    [
				    id: 5,
				    status: 'PARTIALLY_SHIPPED',
				    items: [
					    [
						    id: 1,
						    status: 'PARTIALLY_SHIPPED'
					    ],
					    [
						    id: 2,
						    status: 'ORDERED'
					    ],
					    [
						    id: 3,
						    status: 'PARTIALLY_SHIPPED'
					    ]
				    ]
			    ],
				[
					id: 6,
					status: 'PARTIALLY_SHIPPED',
					items: [
						[
							id: 3,
							status: 'PARTIALLY_SHIPPED'
						],
						[
							id: 4,
							status: 'SHIPPED'
						]
					]
				]
			]
		)
	}
}

