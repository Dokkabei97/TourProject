package com.t4er.item.application;

import com.t4er.item.domain.Item;
import com.t4er.item.infrastructure.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void addItem(String itemName, Long itemPrice) {
        itemRepository.findByItemName(itemName)
                .orElseThrow(); // TODO: 2021-09-19  Exception 추가

        itemRepository.save(new Item(itemName, itemPrice));
    }
}
