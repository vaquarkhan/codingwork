package com.finleash.batch.springdatabatch.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Spring Data JPA repository for the User entity.
 */
public interface MutualFundNavRepository extends JpaRepository<MutualFundNav, Long> {
	
    @Query("SELECT count(*) FROM MutualFundNav t where t.updatedDate = :date")
    public int findByDateAndId(@Param("date") String date);

    @Query("SELECT t.schemeCode FROM MutualFundNav t where t.schemeCode = :schemeCode and  t.updatedDate = :date")
    public MutualFundNav geMutualFundNavRecordsBy(String schemeCode,String date);

  }
