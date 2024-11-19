package com.icecreammachine.brtbonds.dao;

import com.icecreammachine.brtbonds.dao.exception.DataAccessLayerException;
import com.icecreammachine.brtbonds.entity.BondHistoryData;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BondHistoryDataDAO
    extends CrudRepository<BondHistoryData, Integer> {
    @Query(
        "from BondHistoryData bondHistory where bondHistory.issuedBond.code = :code and bondHistory.histDate = :histDate"
    )
    public BondHistoryData findByIssuedBondHistDate(
        @Param("code") String code,
        @Param("histDate") Date histDate
    ) throws DataAccessLayerException;

    @Query(
        "from BondHistoryData bondHistory where bondHistory.issuedBond.code = :code order by bondHistory.idBondHistory desc"
    )
    public List<BondHistoryData> findByIssuedBond(@Param("code") String code)
        throws DataAccessLayerException;
}
