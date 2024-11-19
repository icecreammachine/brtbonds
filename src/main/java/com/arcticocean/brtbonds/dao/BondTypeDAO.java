package com.icecreammachine.brtbonds.dao;

import com.icecreammachine.brtbonds.entity.BondType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BondTypeDAO extends CrudRepository<BondType, Integer> {}
