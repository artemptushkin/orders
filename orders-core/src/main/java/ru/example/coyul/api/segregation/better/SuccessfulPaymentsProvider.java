package ru.example.coyul.api.segregation.better;

import ru.example.coyul.api.segregation.PaymentEntity;
import ru.example.coyul.api.segregation.PaymentsRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SuccessfulPaymentsProvider implements PaymentsProvider {
    private final PaymentsRepository paymentsRepository;

    public SuccessfulPaymentsProvider(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @Override
    public List<PaymentEntity> getAll() {
        return paymentsRepository
                .findAll()
                .stream()
                .filter(PaymentEntity::isTransacted)
                .collect(Collectors.toList());
    }
}
