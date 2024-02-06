package com.varun.ordermicroservice.controller;

import com.varun.ordermicroservice.service.OrderSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderSeq")
public class OrderSequenceController {
    @Autowired
    private OrderSequenceService orderSequenceService;

    @GetMapping("/getSeq")
    public long getSeq(){
        return orderSequenceService.getOrderSequence();
    }
}
