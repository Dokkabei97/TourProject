package com.t4er.item.domain.option;

import com.google.common.collect.Lists;
import com.t4er.common.entity.AbstractEntity;
import com.t4er.common.exception.InvalidParamException;
import com.t4er.item.domain.Item;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "item_options")
public class ItemOption extends AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Option optionName; // 음식, 의류, 생활용품 ...

    @Getter
    @RequiredArgsConstructor
    public enum Option {
        NOT_OPTION("미정"),
        FOOD("음식"),
        DRINK("음료");

        private final String description;
    }


    @OneToMany(mappedBy = "itemOption")
    private List<Item> itemList = Lists.newArrayList();

    @Builder
    public ItemOption(Option optionName) {
        if (optionName == null) throw new InvalidParamException("ItemOption.optionName");
        this.optionName = optionName;
    }
}
