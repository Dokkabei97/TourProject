package com.t4er.item.dto.request;

import com.t4er.item.domain.Item;
import com.t4er.item.domain.option.ItemOption;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemRegisterRequest {

    @NotBlank(message = "상품 이름은 필수 항목입니다!")
    private String itemName;
    @NotNull(message = "상품 가격은 필수 항목입니다!")
    private Long itemPrice;

    private ItemOption optionName;

    @Builder
    public ItemRegisterRequest(String itemName, Long itemPrice, ItemOption optionName) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.optionName = optionName;
    }

    public Item toEntity(ItemOption optionName) {
        return Item.builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
                .itemOption(optionName)
                .build();
    }
}
