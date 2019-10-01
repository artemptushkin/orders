package ru.example.orders.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Partition {
    @Id
    private String id;
    @NotNull
    private Status status;
}
