package com.t4er.item.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.t4er.item.application.ItemOptionService;
import com.t4er.item.application.ItemService;
import com.t4er.item.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
class ItemControllerTest {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemOptionService itemOptionService;
    private MockMvc mockMvc;
    private Item item;
    private ObjectMapper objectMapper;

    @Test
    void 아이템_등록() throws Exception {
        // given
        Map<String, String> exJson = new HashMap<>();

        exJson.put("itemName", "테스트");
        exJson.put("itemPrice", "10000");
        // when
        mockMvc.perform(
                post("/api/v1/items/register/FOOD")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(exJson)))
                .andExpect(status().isOk());
        // 실패
    }

}