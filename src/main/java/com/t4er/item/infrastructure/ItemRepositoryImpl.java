package com.t4er.item.infrastructure;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.t4er.item.domain.QItem;
import com.t4er.item.dto.respones.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

import static com.t4er.item.domain.QItem.item;

@Repository
public class ItemRepositoryImpl implements ItemCustomRepository {

    QItem qItem = QItem.item;
    private final JPAQueryFactory query;

    public ItemRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public ItemResponse itemInfoByItemToken(String itemToken) {
        return query.select(Projections.fields(ItemResponse.class,
                item.itemToken,
                item.itemName,
                item.itemPrice))
                .from(item)
                .where(item.itemToken.eq(itemToken))
                .fetchOne();
    }
}
