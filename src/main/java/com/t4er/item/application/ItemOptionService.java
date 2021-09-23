package com.t4er.item.application;

import com.t4er.item.domain.option.ItemOption;
import com.t4er.item.dto.request.ItemOptionCreateRequest;
import com.t4er.item.exception.AlreadyCreatedItemOptionException;
import com.t4er.item.infrastructure.option.ItemOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ItemOptionService {

    private final ItemOptionRepository itemOptionRepository;

    @Transactional
    public void createItemOption(ItemOptionCreateRequest optionDto) {
        if (itemOptionRepository.countByOptionName(optionDto.getOptionName()) != 0) {
            throw new AlreadyCreatedItemOptionException();
        }

        itemOptionRepository.save(optionDto.toEntity());
    }
}
