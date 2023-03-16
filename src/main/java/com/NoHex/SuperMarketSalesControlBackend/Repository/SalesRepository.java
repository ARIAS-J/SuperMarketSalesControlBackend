package com.NoHex.SuperMarketSalesControlBackend.Repository;

import com.NoHex.SuperMarketSalesControlBackend.Entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Long> {
}
