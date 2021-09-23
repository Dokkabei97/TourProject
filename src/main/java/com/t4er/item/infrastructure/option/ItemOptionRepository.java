package com.t4er.item.infrastructure.option;

import com.t4er.item.domain.option.ItemOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {

    Optional<ItemOption> findByOptionName(String optionName);

    Long countByOptionName(String optionName);
}
