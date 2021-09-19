package com.t4er.item.domain.option;

import com.google.common.collect.Lists;
import com.t4er.common.entity.AbstractEntity;
import com.t4er.item.domain.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private String optionName;

    @OneToMany(mappedBy = "itemOption")
    private List<Item> itemList = Lists.newArrayList();

    public ItemOption(String optionName) {
        this.optionName = optionName;
    }
}
