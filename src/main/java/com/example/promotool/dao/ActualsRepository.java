package com.example.promotool.dao;

import com.example.promotool.model.Actuals;
import com.example.promotool.model.ActualsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActualsRepository extends JpaRepository<Actuals, Integer> {

    @Query(value = "select * from Actuals a join Price p on a.chain_name = p.chain_name and a.material_no = p.material_no " +
            "where (a.actual_sales_value / a.volume_units) < p.regular_price",
            nativeQuery = true)
    List<Actuals> getPromo();

    @Query(value = "select * from Actuals a join Price p on a.chain_name = p.chain_name and a.material_no = p.material_no " +
            "where (a.actual_sales_value / a.volume_units) >= p.regular_price",
            nativeQuery = true)
    List<Actuals> getRegular();

    List<Actuals> findAllByChainInAndMaterialIdIn(Iterable<String> chain, Iterable<Integer> materialId);

    @Query(value = "select date_part('month', a.record_date) as date, " +
            "a.chain_name as chain, " +
            "sum(case when a.promo = 'regular' then 1 else 0 end) as regular, " +
            "sum(case when a.promo = 'promo' then 1 else 0 end) as promo, " +
            "count(a.material_no) as materials, " +
            "p.category_name as category " +
            "from Actuals a join products p on a.material_no = p.material_id group by date, chain, category", nativeQuery = true)
    List<ActualsProjection> getAnalyzeTable();


}
