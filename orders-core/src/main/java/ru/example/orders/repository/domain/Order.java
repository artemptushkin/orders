package ru.example.orders.repository.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
@Accessors(chain = true)
@Document(collection = "order")
public class Order {
    @Id
    private String id;
    @NotEmpty
    private List<Item> items;
    @Positive
    private Long merchantId;
}
