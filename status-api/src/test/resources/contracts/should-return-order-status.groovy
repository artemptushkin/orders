package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		headers {
			header(accept(), applicationJson())
		}
		url '/status/order/1'
	}
	response {
		status 200
		headers {
			header(contentType(), applicationJsonUtf8())
		}
		body(
			id: 1,
			merchantId: 1,
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
		)
	}
}

