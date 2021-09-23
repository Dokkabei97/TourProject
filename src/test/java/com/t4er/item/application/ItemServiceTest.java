package com.t4er.item.application;

import com.t4er.item.domain.Item;
import com.t4er.item.domain.option.ItemOption;
import com.t4er.item.dto.request.ItemOptionCreateRequest;
import com.t4er.item.dto.request.ItemRegisterRequest;
import com.t4er.item.infrastructure.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static com.t4er.item.domain.Item.ItemStatus.*;
import static com.t4er.item.domain.Item.SaleStatus.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemOptionService itemOptionService;

    @Test
    void 아이템_추가() throws Exception {
        // given
        ItemOptionCreateRequest option = new ItemOptionCreateRequest("FOOD");
        itemOptionService.createItemOption(option);

        // when
        ItemRegisterRequest dto = ItemRegisterRequest.builder()
                .itemName("치킨")
                .itemPrice(7650L)
                .optionName(option.toEntity())
                .build();
        Item item = itemService.registerItem(dto, option.getOptionName());

        // then
        assertThat(item.getId()).isNotNull();
        assertThat(item.getItemName()).isEqualTo("치킨");
        assertThat(item.getItemPrice()).isEqualTo(7650);
        assertThat(item.getItemToken()).startsWith("itm_");
        assertThat(item.getSaleStatus()).isEqualTo(PREPARE);
        assertThat(item.getItemStatus()).isEqualTo(NEW);
        assertThat(item.getItemOption().getOptionName()).isEqualTo("FOOD");
    }

    @Test
    void 아이템_판매중_전환() throws Exception {
        // given
        ItemOptionCreateRequest option = new ItemOptionCreateRequest("FOOD");
        itemOptionService.createItemOption(option);

        ItemRegisterRequest dto = ItemRegisterRequest.builder()
                .itemName("치킨")
                .itemPrice(7650L)
                .optionName(option.toEntity())
                .build();
        Item item = itemService.registerItem(dto, option.getOptionName());

        // when
        item.changeOnSale();

        // then
        assertThat(item.getSaleStatus()).isEqualTo(ON_SALE);
    }

    @Test
    void 아이템_인기_전환() throws Exception {
        // given
        ItemOptionCreateRequest option = new ItemOptionCreateRequest("FOOD");
        itemOptionService.createItemOption(option);

        ItemRegisterRequest dto = ItemRegisterRequest.builder()
                .itemName("치킨")
                .itemPrice(7650L)
                .optionName(option.toEntity())
                .build();
        Item item = itemService.registerItem(dto, option.getOptionName());

        // when
        item.changeItemHot();

        // then
        assertThat(item.getItemStatus()).isEqualTo(HOT);
    }

    @Test
    void 아이템_세일() throws Exception {
        // given
        ItemOptionCreateRequest option = new ItemOptionCreateRequest("FOOD");
        itemOptionService.createItemOption(option);

        ItemRegisterRequest dto = ItemRegisterRequest.builder()
                .itemName("치킨")
                .itemPrice(7650L)
                .optionName(option.toEntity())
                .build();
        Item item = itemService.registerItem(dto, option.getOptionName());

        // when
        item.changeItemDiscount(1500L);

        // then
        assertThat(item.getItemPrice()).isEqualTo(6150L);
    }

}