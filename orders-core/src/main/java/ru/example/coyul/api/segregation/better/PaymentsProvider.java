package ru.example.coyul.api.segregation.better;

import ru.example.coyul.api.segregation.PaymentEntity;

import java.util.List;

/**
 * Интерфейс предоставления плажетей из локального репозитория
 */
public interface PaymentsProvider {
    /**
     * @return все платежи, существующие в локальном репозитории
     */
    List<PaymentEntity> getAll();
}
