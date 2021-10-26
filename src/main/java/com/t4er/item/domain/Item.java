package com.t4er.item.domain;

import com.t4er.common.entity.AbstractEntity;
import com.t4er.common.exception.InvalidParamException;
import com.t4er.common.util.TokenGenerator;
import com.t4er.item.domain.option.ItemOption;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "items")
public class Item extends AbstractEntity {

    private final static String ITEM_PREFIX = "itm_";

    @Id @GeneratedValue
    @Column(name = "items_id")
    private Long id;
    @Column(updatable = false)
    private String itemToken;
    private String itemName;
    private Long itemPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "item_options_id")
    private ItemOption itemOption;

    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    @Getter
    @RequiredArgsConstructor
    public enum SaleStatus {
        PREPARE("판매준비중"),
        ON_SALE("판매중"),
        END_OF_SALE("판매종료");

        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum ItemStatus {
        NEW("신상"),
        HOT("인기"),
        DISCOUNT("할인");

        private final String description;
    }
/*

    @Builder
    public Item(String itemName, Long itemPrice, ItemOption itemOption) {
        if (StringUtils.isBlank(itemName)) throw new InvalidParamException("Item.itemName");
        if (itemPrice == null) throw new InvalidParamException("Item.itemPrice");
        if (itemOption == null) throw new InvalidParamException("Item.itemOption");

        this.itemToken = TokenGenerator.randomCharacterWithPrefix(ITEM_PREFIX);
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemOption = itemOption;
        this.saleStatus = SaleStatus.PREPARE;
        this.itemStatus = ItemStatus.NEW;
    }
*/

    public static Item create(String itemName, Long itemPrice, ItemOption itemOption) {
        return new Item(null,
                TokenGenerator.randomCharacterWithPrefix(ITEM_PREFIX),
                itemName,
                itemPrice,
                itemOption,
                SaleStatus.PREPARE, 
                ItemStatus.NEW
        );
    }

    public void changeOnSale() {
        this.saleStatus = SaleStatus.ON_SALE;
    }

    public void changeEndOfSale() {
        this.saleStatus = SaleStatus.END_OF_SALE;
    }

    public void changeItemHot() {
        this.itemStatus = ItemStatus.HOT;
    }

    public void changeItemDiscount(Long itemPrice) { // 정책에 따라 결정
//        this.itemPrice = itemPrice;
        this.itemPrice = this.itemPrice - itemPrice;
        this.itemStatus = ItemStatus.DISCOUNT;
    }

}
