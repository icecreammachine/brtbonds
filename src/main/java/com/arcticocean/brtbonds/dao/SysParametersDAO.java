package com.icecreammachine.brtbonds.dao;

import com.icecreammachine.brtbonds.entity.SysParameters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysParametersDAO
    extends CrudRepository<SysParameters, String> {}
