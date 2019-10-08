package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		headers {
			header(accept(), applicationJson())
		}
		url '/merchant/4/orders'
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
			    ],
				[
					id: 6,
					items: [
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
						],
						[
							id: 4,
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
				]
			]
		)
	}
}

