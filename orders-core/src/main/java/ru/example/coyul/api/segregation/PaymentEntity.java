package ru.example.coyul.api.segregation;

import java.time.LocalDateTime;

public class PaymentEntity {
    private boolean active;
    private String paymentSystem;
    private LocalDateTime blockingDate;
    private boolean transacted;

    public boolean isActive() {
        return active;
    }

    public boolean isBLocked() {
        return !active;
    }

    public String getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(String paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public LocalDateTime getBlockingDate() {
        return blockingDate;
    }

    public void setBlockingDate(LocalDateTime blockingDate) {
        this.blockingDate = blockingDate;
    }

    public boolean isTransacted() {
        return transacted;
    }

    public void setTransacted(boolean transacted) {
        this.transacted = transacted;
    }
}
