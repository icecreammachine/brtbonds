package com.icecreammachine.brtbonds.dao;

import com.icecreammachine.brtbonds.dao.exception.DataAccessLayerException;
import com.icecreammachine.brtbonds.entity.BondHistoryLink;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BondHistoryLinkDAO
    extends CrudRepository<BondHistoryLink, Integer> {
    @Query("from BondHistoryLink histLink where histLink.year = :year")
    public List<BondHistoryLink> findByYear(@Param("year") Integer year)
        throws DataAccessLayerException;
}
