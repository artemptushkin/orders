package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description(
		"Cancellation of an order is only allowed if no item of it has been already shipped."
	)
	request {
		method 'DELETE'
		headers {
			header(accept(), applicationJson())
		}
		url '/order/3'
	}
	response {
		status 400
	}
}
