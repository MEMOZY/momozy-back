package com.memozy.memozy_back.domain.memory.dto;


import com.memozy.memozy_back.domain.memory.domain.Memory;
import com.memozy.memozy_back.domain.memory.constant.MemoryCategory;
import com.memozy.memozy_back.domain.memory.domain.MemoryItem;
import com.memozy.memozy_back.domain.memory.domain.MemoryShared;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record MemoryDto(
        @NotNull Long id,
        @NotBlank String title,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        @NotNull MemoryCategory category,
        @NotNull List<MemoryItem> memoryItems,
        @NotNull List<Long> sharedUserIds
) {
    public static MemoryDto from(Memory memory) {
        return new MemoryDto(
                memory.getId(),
                memory.getTitle(),
                memory.getStartDate(),
                memory.getEndDate(),
                memory.getCategory(),
                memory.getMemoryItems(),
                memory.getSharedUsers().stream()
                        .map(MemoryShared::getId)
                        .toList()
        );
    }
}
