package com.t4er.item.application;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.t4er.item.domain.Item;
import com.t4er.item.domain.QItem;
import com.t4er.item.domain.option.ItemOption;
import com.t4er.item.dto.request.ItemOptionCreateRequest;
import com.t4er.item.dto.request.ItemRegisterRequest;
import com.t4er.item.dto.respones.ItemResponse;
import com.t4er.item.infrastructure.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static com.t4er.item.domain.Item.ItemStatus.*;
import static com.t4er.item.domain.Item.SaleStatus.*;
import static com.t4er.item.domain.QItem.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemOptionService itemOptionService;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    EntityManager em;

    private Item itemEx() {
        ItemOptionCreateRequest option = new ItemOptionCreateRequest("테스트옵션");
        itemOptionService.createItemOption(option);

        ItemRegisterRequest dto = ItemRegisterRequest.builder()
                .itemName("테스트")
                .itemPrice(7650L)
                .optionName(option.toEntity())
                .build();
        return itemService.registerItem(dto, option.getOptionName());
    }

    @Test
    void 아이템_추가() throws Exception {
        // given
        Item item = itemEx();

        // then
        assertThat(item.getId()).isNotNull();
        assertThat(item.getItemName()).isEqualTo("테스트");
        assertThat(item.getItemPrice()).isEqualTo(7650);
        assertThat(item.getItemToken()).startsWith("itm_");
        assertThat(item.getSaleStatus()).isEqualTo(PREPARE);
        assertThat(item.getItemStatus()).isEqualTo(NEW);
        assertThat(item.getItemOption().getOptionName()).isEqualTo("테스트옵션");
    }

    @Test
    void 아이템_판매중_전환() throws Exception {
        // given
        Item item = itemEx();

        // when
        item.changeOnSale();

        // then
        assertThat(item.getSaleStatus()).isEqualTo(ON_SALE);
    }

    @Test
    void 아이템_인기_전환() throws Exception {
        // given
        Item item = itemEx();

        // when
        item.changeItemHot();

        // then
        assertThat(item.getItemStatus()).isEqualTo(HOT);
    }

    @Test
    void 아이템_세일() throws Exception {
        // given
        Item item = itemEx();

        // when
        item.changeItemDiscount(1500L);

        // then
        assertThat(item.getItemPrice()).isEqualTo(6150L);
    }

    @Test
    void 아이템_삭제() throws Exception {
        // given
        Item item = itemEx();
        // when
        itemService.deleteItem(item.getItemToken());
        // then
        assertThat(itemRepository.count()).isEqualTo(3);
    }

    @Test
    void 아이템_조회() throws Exception {
        // given
        JPAQueryFactory query = new JPAQueryFactory(em);
        QItem qItem = item;
        // when
        List<ItemResponse> result = query.select(Projections.bean(ItemResponse.class,
                item.itemToken,
                item.itemName,
                item.itemPrice))
                .from(item)
                .fetch();

        for (ItemResponse response : result) {
            System.out.println("response = " + response);
        }
        // then
    }


}