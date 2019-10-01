package ru.example.orders.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
@Document(collection = "order")
public class Order {
    @Id
    private String id;
    @Indexed(unique = true)
    private Long orderId;
    @NotEmpty
    private List<Item> items;
    @Positive
    private Long merchantId;
}
