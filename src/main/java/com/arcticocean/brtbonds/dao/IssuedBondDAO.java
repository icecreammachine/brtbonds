package com.icecreammachine.brtbonds.dao;

import com.icecreammachine.brtbonds.entity.IssuedBond;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedBondDAO extends CrudRepository<IssuedBond, Integer> {
    @Query("from IssuedBond issuedBond where issuedBond.code = :code")
    public IssuedBond findByCode(@Param("code") String code);

    @Query(
        "from IssuedBond issuedBond where issuedBond.bondType.idBondType = :bondType"
    )
    public List<IssuedBond> findByBondType(@Param("bondType") Integer bondType);
}
