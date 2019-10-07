package ru.example.orders.repository.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;

import static ru.example.orders.repository.domain.Status.UNKNOWN;

@Data
@Builder
@AllArgsConstructor
public class Partition {
    @NotNull
    private Status status;

    public Partition() {
        this.status = UNKNOWN;
    }
}
