package ru.example.coyul.api.segregation;

import java.util.List;

public interface PaymentsRepository {
    PaymentEntity find(Long id);
    List<PaymentEntity> findAll();
}
