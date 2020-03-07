package ru.example.coyul.api.segregation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. По характеру методов сюда можно аналогичных добавить огромное количество, скоро класс может стать огромным и трудно поддерживаемым. Как сохранить его качественным?
 * 2. Не всем клиентам данного класса нужны все публичные методы, да и названия становятся длинными, как сделать класс удобочитаемым?
 * 3. Хотелось бы, что бы те, кто будет пользоваться классом могли получать минимум изменений со временем, как этого достичь?
 */
public class PaymentsProvider {

    private final PaymentsRepository paymentsRepository;

    public PaymentsProvider(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    public List<PaymentEntity> getBlockedTodayPayments() {
        return paymentsRepository
                .findAll()
                .stream()
                .filter(PaymentEntity::isBLocked)
                .filter(this::isBlockedToday)
                .collect(Collectors.toList());
    }

    public List<PaymentEntity> getSuccessfulPayments() {
        return paymentsRepository
                .findAll()
                .stream()
                .filter(PaymentEntity::isTransacted)
                .collect(Collectors.toList());
    }

    private boolean isBlockedToday(PaymentEntity paymentEntity) {
        return LocalDateTime.now().compareTo(paymentEntity.getBlockingDate()) > 0;
    }
}
