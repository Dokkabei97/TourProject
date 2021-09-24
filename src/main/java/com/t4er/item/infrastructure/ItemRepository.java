package com.t4er.item.infrastructure;

import com.t4er.item.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByItemName(String itemName);

    Optional<Item> findByItemToken(String itemToken);

    Long countByItemName(String itemName);

}
