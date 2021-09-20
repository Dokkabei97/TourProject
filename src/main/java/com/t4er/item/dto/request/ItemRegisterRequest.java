package com.t4er.item.dto.request;

import com.t4er.item.domain.Item;
import com.t4er.item.domain.option.ItemOption;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemRegisterRequest {

    // TODO: 2021-09-21 valid 추가
    private String itemName;
    private Long itemPrice;
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
