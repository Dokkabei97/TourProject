package com.t4er.item.application;

import com.t4er.item.domain.Item;
import com.t4er.item.dto.request.ItemRegisterRequest;
import com.t4er.item.exception.AlreadyRegisterItemException;
import com.t4er.item.exception.NotFoundItemTokenException;
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
    public Item registerItem(ItemRegisterRequest itemDto) {
        if (itemRepository.countByItemName(itemDto.getItemName()) != 0) {
            throw new AlreadyRegisterItemException();
        }

        return itemRepository.save(itemDto.toEntity());
    }

    @Transactional
    public void changeOnSale(String itemToken) {
        var item = itemToken(itemToken);
        item.changeOnSale();
    }

    @Transactional
    public void changeEndOfSale(String itemToken) {
        var item = itemToken(itemToken);
        item.changeEndOfSale();
    }

    @Transactional
    public void changeItemHot(String itemToken) {
        var item = itemToken(itemToken);

        item.changeItemHot();
    }

    @Transactional
    public void changeItemDiscount(String itemToken, Long itemPrice) {
        var item = itemToken(itemToken);

        item.changeItemDiscount(itemPrice);
    }

    private Item itemToken(String itemToken) {
        return itemRepository.findByItemToken(itemToken)
                .orElseThrow(NotFoundItemTokenException::new);
    }

}
