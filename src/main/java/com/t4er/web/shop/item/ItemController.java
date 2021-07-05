package com.t4er.web.shop.item;

import com.t4er.domain.shop.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository;
}
