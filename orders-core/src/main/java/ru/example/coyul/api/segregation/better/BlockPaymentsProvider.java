package ru.example.coyul.api.segregation.better;

import ru.example.coyul.api.segregation.PaymentEntity;
import ru.example.coyul.api.segregation.PaymentsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Изначально методы возвращал заблокированные сегодня платежи, данный же класс работает с любыми датами,
 * что позволяет его протестировать независимо от конкретной даты.
 * В случае изменения даты сравнения в дальнейшем:
 *     * В первом случае необходимо будет изменить название метода, а значит и код клиентов класса, код в private методе и тесты
 *     * В текущем случае будет необходимо лишь изменить параметр на стороне клиента передаваемый в конструктор текущего класса
 */
public class BlockPaymentsProvider implements PaymentsProvider {
    private final PaymentsRepository paymentsRepository;
    private final LocalDateTime comparativeDate;

    public BlockPaymentsProvider(PaymentsRepository paymentsRepository, LocalDateTime comparativeDate) {
        this.paymentsRepository = paymentsRepository;
        this.comparativeDate = comparativeDate;
    }

    @Override
    public List<PaymentEntity> getAll() {
        return paymentsRepository
                .findAll()
                .stream()
                .filter(PaymentEntity::isBLocked)
                .filter(this::isBlockedOnComparativeDate)
                .collect(Collectors.toList());
    }

    private boolean isBlockedOnComparativeDate(PaymentEntity paymentEntity) {
        return comparativeDate.compareTo(paymentEntity.getBlockingDate()) > 0;
    }
}
