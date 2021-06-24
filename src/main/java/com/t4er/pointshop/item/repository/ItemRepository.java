package com.t4er.pointshop.item.repository;

import com.t4er.pointshop.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
