package com.example.receiptprocessor.controller;

import com.example.receiptprocessor.dto.GetPointResponse;
import com.example.receiptprocessor.dto.ProcessReceiptResponse;
import com.example.receiptprocessor.dto.ReceiptDto;
import com.example.receiptprocessor.service.ReceiptProcessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptProcessorController {
    @Autowired
    private ReceiptProcessorService receiptProcessorService;

    @PostMapping("/process")
    public ResponseEntity<ProcessReceiptResponse> processReceipt(@Valid @RequestBody ReceiptDto receiptIn) {
        String id = receiptProcessorService.processReceipt(receiptIn);
        return ResponseEntity.ok(ProcessReceiptResponse.builder().id(id).build());
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<GetPointResponse> getPoints(@PathVariable("id") String id) {
        Integer points = receiptProcessorService.getPoints(id);
        return ResponseEntity.ok(GetPointResponse.builder().point(points).build());
    }
}
