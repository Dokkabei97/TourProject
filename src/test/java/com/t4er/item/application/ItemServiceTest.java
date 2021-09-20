package com.t4er.item.application;

import com.t4er.item.domain.Item;
import com.t4er.item.dto.request.ItemRegisterRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    void 아이템_추가() throws Exception {
        // given
        ItemRegisterRequest dto = new ItemRegisterRequest("치킨", 18000L);

        // when
        Item item = itemService.registerItem(dto);

        // then
        assertThat(item.getId()).isNotNull();
        assertThat(item.getItemName()).isEqualTo("치킨");
        assertThat(item.getItemPrice()).isEqualTo(18000);
        assertThat(item.getItemToken()).startsWith("itm_");
        assertThat(item.getStatus()).isEqualTo(Item.Status.PREPARE);
        // TODO: 2021-09-20 itemOption 
    }

}