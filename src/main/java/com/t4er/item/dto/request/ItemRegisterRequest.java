package com.t4er.item.dto.request;

import com.t4er.item.domain.Item;
import com.t4er.item.domain.option.ItemOption;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class ItemRegisterRequest {

    @NotBlank(message = "상품 이름은 필수 항목입니다!")
    private String itemName;
    @NotBlank(message = "상품 가격은 필수 항목입니다!")
    private Long itemPrice;
    @NotBlank(message = "상품 종류는 필수 항목입니다!")
    private ItemOption itemOption;

    @Builder
    public ItemRegisterRequest(String itemName, Long itemPrice, ItemOption itemOption) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemOption = itemOption;
    }

    public Item toEntity() {
        return Item.builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
                .itemOption(itemOption)
                .build();
    }
}
