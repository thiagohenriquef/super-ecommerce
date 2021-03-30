package com.superecommerce.checkout.resources;

import com.superecommerce.checkout.dto.MessageDTO;
import com.superecommerce.checkout.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class MessageResource {

    @Autowired
    private MessageService messageService;

    @PostMapping(path = "/message")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageDTO dto) {
        messageService.sendMessage(dto.getMessage());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
