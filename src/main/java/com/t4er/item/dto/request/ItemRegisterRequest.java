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

    private String itemName;
    private Long itemPrice;
//    private ItemOption itemOption;

    @Builder
    public ItemRegisterRequest(String itemName, Long itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Item toEntity() {
        return Item.builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
//                .itemOption(itemOption)
                .build();
    }
}
