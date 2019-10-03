package ru.example.orders.repository.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Item {
    @NotNull
    private Status status;
}
