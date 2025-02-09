package com.example.receiptprocessor.service;

import com.example.receiptprocessor.dto.ItemDto;
import com.example.receiptprocessor.dto.ReceiptDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

public class ReceiptProcessorServiceTest {
    private ReceiptProcessorService receiptProcessorService;

    @BeforeEach
    public void setup() {
        receiptProcessorService = new ReceiptProcessorService();
    }

    @Test
    void testCalculatePoints_happyPath() {
        ReceiptDto receiptDto = ReceiptDto.builder()
                .retailer("Target")
                .purchaseDate("2022-01-01")
                .purchaseTime("13:01")
                .items(Arrays.asList(
                        ItemDto.builder().shortDescription("Mountain Dew 12PK").price("6.49").build(),
                        ItemDto.builder().shortDescription("Emils Cheese Pizza").price("12.25").build(),
                        ItemDto.builder().shortDescription("Knorr Creamy Chicken").price("1.26").build(),
                        ItemDto.builder().shortDescription("Doritos Nacho Cheese").price("3.35").build(),
                        ItemDto.builder().shortDescription("   Klarbrunn 12-PK 12 FL OZ  ").price("12.00").build()
                ))
                .total("35.35").build();
        assertEquals(28, receiptProcessorService.calculatePoint(receiptDto));
    }

    @Test
    void testCalculatePoints_happyPath2() {
        ReceiptDto receiptDto = ReceiptDto.builder()
                .retailer("M&M Corner Market")
                .purchaseDate("2022-03-20")
                .purchaseTime("14:33")
                .items(Arrays.asList(
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build(),
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build(),
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build(),
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build()
                ))
                .total("9.00").build();
        assertEquals(109, receiptProcessorService.calculatePoint(receiptDto));
    }

    @Test
    void testProcessReceipt() {
        ReceiptDto receiptDto = ReceiptDto.builder()
                .retailer("M&M Corner Market")
                .purchaseDate("2022-03-20")
                .purchaseTime("14:33")
                .items(Arrays.asList(
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build(),
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build(),
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build(),
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build()
                ))
                .total("9.00").build();

        assertNotNull(receiptProcessorService.processReceipt(receiptDto));
    }

    @Test
    void testGetPoints() {
        ReceiptDto receiptDto = ReceiptDto.builder()
                .retailer("M&M Corner Market")
                .purchaseDate("2022-03-20")
                .purchaseTime("14:33")
                .items(Arrays.asList(
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build(),
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build(),
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build(),
                        ItemDto.builder().shortDescription("Gatorade").price("2.25").build()
                ))
                .total("9.00").build();
        String id = receiptProcessorService.processReceipt(receiptDto);
        assertEquals(109, receiptProcessorService.getPoints(id));
    }
}
