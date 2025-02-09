package com.example.receiptprocessor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiptDto {
    @NotBlank(message = "retailer is required")
    @Pattern(regexp = "^[\\w\\s\\-&]+$", message = "Invalid retailer")
    private String retailer;

    @NotBlank(message = "purchaseDate is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Invalid purchase date")
    private String purchaseDate;

    @NotBlank(message = "purchaseTime is required")
    @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Invalid purchase time")
    private String purchaseTime;

    @Size(min = 1)
    @Valid
    private List<ItemDto> items;

    @NotBlank(message = "total is required")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Invalid total")
    private String total;
}
