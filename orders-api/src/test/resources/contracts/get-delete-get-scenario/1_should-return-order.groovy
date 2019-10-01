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
			items: [
				[
					id: 1,
					description: "wonderful item"
				],
				[
					id: 2,
					description: "useful item"
				]
			]
		)
	}
}
