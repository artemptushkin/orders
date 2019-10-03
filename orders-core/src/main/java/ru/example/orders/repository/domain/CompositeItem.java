package ru.example.orders.repository.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.function.Consumer;

@Data
@Builder
public class CompositeItem extends Item {
    @Id
    private long id;
    @NotEmpty
    @JsonIgnore
    private List<Item> partitions;
    @NotNull
    private String description;

    @Override
    public @NotNull Status getStatus() {
        if (partitions == null) {
            partitions = new ArrayList<>();
        }
        StatusDto statusDto = new StatusDto();
        partitions
            .forEach(item -> {
                Status status = item.getStatus();
                Integer counter = statusDto.counter.getOrDefault(item.getStatus(), 0);
                statusDto.counter.put(status, ++counter);
            });

    }

    public Integer getQuantity() {
        if (partitions == null) {
            partitions = new ArrayList<>();
        }
        return partitions.size();
    }

    private static class StatusDto {
        private Map<Status, Integer> counter = new EnumMap<>(Status.class);
    }
}
