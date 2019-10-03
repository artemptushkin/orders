package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'DELETE'
		headers {
			header(accept(), applicationJson())
		}
		url '/order/1'
	}
	response {
		status 204
	}
}
