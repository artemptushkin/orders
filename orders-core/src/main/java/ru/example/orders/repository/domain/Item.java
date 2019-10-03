package ru.example.orders.repository.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Item {
    @Id
    private long id;
    @NotEmpty
    private List<Partition> partitions;
    @NotNull
    private String description;

    public Integer getQuantity() {
        if (partitions == null) {
            partitions = new ArrayList<>();
        }
        return partitions.size();
    }
}
