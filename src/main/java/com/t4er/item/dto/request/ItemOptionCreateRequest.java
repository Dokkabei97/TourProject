package com.t4er.item.dto.request;

import com.t4er.item.domain.option.ItemOption;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemOptionCreateRequest {

    @NotBlank(message = "옵션 이름은 필수 입니다!")
    private String optionName;

    public ItemOptionCreateRequest(String optionName) {
        this.optionName = optionName;
    }

    public ItemOption toEntity() {
        return new ItemOption(optionName);
    }
}
