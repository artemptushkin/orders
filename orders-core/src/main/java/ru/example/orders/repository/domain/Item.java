package ru.example.orders.repository.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Partition> partitions;
    @NotNull
    private String description;

    public Integer getOrderedQuantity() {
        if (partitions == null) {
            partitions = new ArrayList<>();
        }
        return partitions.size();
    }

}
