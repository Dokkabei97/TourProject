package com.t4er.item.ui;

import com.t4er.common.exception.InvalidParamException;
import com.t4er.item.application.ItemService;
import com.t4er.item.dto.request.ItemRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/register")
    public ResponseEntity<?> registerItem(@RequestBody @Validated ItemRegisterRequest dto, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidParamException("오류가 있어요");
        }
        itemService.registerItem(dto);

        return ResponseEntity.ok().build();
    }
}
