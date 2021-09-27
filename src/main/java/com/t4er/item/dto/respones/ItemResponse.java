package com.t4er.item.dto.respones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemResponse {

    private String itemToken;
    private String itemName;
    private Long itemPrice;

}
