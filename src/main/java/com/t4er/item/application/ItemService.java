package com.t4er.item.application;

import com.t4er.item.domain.Item;
import com.t4er.item.domain.option.ItemOption;
import com.t4er.item.dto.request.ItemOptionCreateRequest;
import com.t4er.item.dto.request.ItemRegisterRequest;
import com.t4er.item.dto.respones.ItemResponse;
import com.t4er.item.exception.AlreadyRegisterItemException;
import com.t4er.item.exception.NotFoundItemOptionException;
import com.t4er.item.exception.NotFoundItemTokenException;
import com.t4er.item.infrastructure.ItemCustomRepository;
import com.t4er.item.infrastructure.ItemRepository;
import com.t4er.item.infrastructure.option.ItemOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemOptionRepository itemOptionRepository;
    private final ItemCustomRepository itemCustomRepository;

    @Transactional
    public Item registerItem(ItemRegisterRequest itemDto, String optionName) {
        if (itemRepository.countByItemName(itemDto.getItemName()) != 0) {
            throw new AlreadyRegisterItemException();
        }
        ItemOption itemOption = itemOptionRepository.findByOptionName(optionName)
                .orElseThrow(NotFoundItemOptionException::new);

        return itemRepository.save(itemDto.toEntity(itemOption));
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

    @Transactional
    public void deleteItem(String itemToken) {
        var item = itemToken(itemToken);

        itemRepository.delete(item);
    }

    private Item itemToken(String itemToken) {
        return itemRepository.findByItemToken(itemToken)
                .orElseThrow(NotFoundItemTokenException::new);
    }

    // TODO: 2021-09-23 조회 추가
    public ItemResponse test(String itemToken) {
        return itemCustomRepository.itemInfoByItemToken(itemToken);
    }
}
