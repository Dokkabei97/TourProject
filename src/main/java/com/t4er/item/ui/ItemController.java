package com.t4er.item.ui;

import com.t4er.common.exception.InvalidParamException;
import com.t4er.item.application.ItemOptionService;
import com.t4er.item.application.ItemService;
import com.t4er.item.domain.option.ItemOption;
import com.t4er.item.dto.request.ItemChangeStatusRequest;
import com.t4er.item.dto.request.ItemOptionCreateRequest;
import com.t4er.item.dto.request.ItemRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService itemService;
    private final ItemOptionService itemOptionService;

    @PostMapping("/register/{optionName}")
    public ResponseEntity<Void> registerItem(@RequestBody @Validated ItemRegisterRequest itemDto,
                                             @PathVariable String optionName,
                                             BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidParamException("오류가 있어요");
        }
        itemService.registerItem(itemDto, optionName);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createItemOption(@RequestBody ItemOptionCreateRequest optionDto) {
        itemOptionService.createItemOption(optionDto);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/change-on-sale")
    public ResponseEntity<Void> changeOnSale(@RequestBody ItemChangeStatusRequest request) {
        String itemToken = request.getItemToken();
        itemService.changeOnSale(itemToken);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/change-end-sale")
    public ResponseEntity<Void> changeEndSale(@RequestBody ItemChangeStatusRequest request) {
        String itemToken = request.getItemToken();
        itemService.changeEndOfSale(itemToken);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/change-item-discount/{discountPrice}")
    public ResponseEntity<Void> changeItemDiscount(@RequestBody ItemChangeStatusRequest request,
                                                   @PathVariable Long discountPrice) {
        String itemToken = request.getItemToken();
        itemService.changeItemDiscount(itemToken, discountPrice);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/change-item-hot")
    public ResponseEntity<Void> changeItemHot(@RequestBody ItemChangeStatusRequest request) {
        String itemToken = request.getItemToken();
        itemService.changeItemHot(itemToken);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-item")
    public ResponseEntity<Void> deleteItem(@RequestBody ItemChangeStatusRequest request) {
        String itemToken = request.getItemToken();
        itemService.deleteItem(itemToken);
        return ResponseEntity.ok().build();
    }

    // TODO: 2021-09-23 조회 + valid
}
