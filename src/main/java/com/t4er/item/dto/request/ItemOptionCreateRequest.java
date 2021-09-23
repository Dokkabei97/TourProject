package com.t4er.item.dto.request;

import com.t4er.item.domain.option.ItemOption;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemOptionCreateRequest {

    private String optionName;

    public ItemOptionCreateRequest(String optionName) {
        this.optionName = optionName;
    }

    public ItemOption toEntity() {
        return new ItemOption(optionName);
    }
}
