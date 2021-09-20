package com.t4er.item.application;

import com.t4er.item.domain.Item;
import com.t4er.item.domain.option.ItemOption;
import com.t4er.item.dto.request.ItemRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    void 아이템_추가() throws Exception {
        // given
        ItemRegisterRequest dto = ItemRegisterRequest.builder()
                .itemName("치킨")
                .itemPrice(7650L)
                .itemOption(new ItemOption(ItemOption.Option.FOOD))
                .build();

        // when
        Item item = itemService.registerItem(dto);

        // then
        assertThat(item.getId()).isNotNull();
        assertThat(item.getItemName()).isEqualTo("치킨");
        assertThat(item.getItemPrice()).isEqualTo(7650);
        assertThat(item.getItemToken()).startsWith("itm_");
        assertThat(item.getSaleStatus()).isEqualTo(Item.SaleStatus.PREPARE);
        assertThat(item.getItemStatus()).isEqualTo(Item.ItemStatus.NEW);
        assertThat(item.getItemOption().getOptionName()).isEqualTo(ItemOption.Option.FOOD);
    }

}