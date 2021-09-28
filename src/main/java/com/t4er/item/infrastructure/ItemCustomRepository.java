package com.t4er.item.infrastructure;

import com.t4er.item.domain.Item;
import com.t4er.item.dto.respones.ItemResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemCustomRepository {

    ItemResponse itemInfoByItemToken(String itemToken);
}
