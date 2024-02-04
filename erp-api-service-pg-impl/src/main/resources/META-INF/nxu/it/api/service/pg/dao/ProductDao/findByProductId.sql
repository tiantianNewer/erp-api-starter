SELECT tpr.id, tpr.name, tpr.brand, tpr.bar_code, tpr.quantity_per_unit, tpr.unit_price, tpr.units_in_stock, tpr.units_sell, tpr.photo,
       tsu.id AS supplier_id, tsu.name AS supplier_name,
       t3.id AS category_id3, t3.name AS category_name3, t2.id AS category_id2,  t2.name AS category_name2, t1.id AS category_id1, t1.name AS category_name1
FROM t_product tpr
    left join t_purchase tpu on tpr.id = tpu.product_id
    left join t_supplier tsu on tsu.id = tpu.supplier_id
    left join t_category t3 on tpr.category_id = t3.id
    left join t_category t2 on t2.id = t3.parent_id
    left join t_category t1 on t1.id = t2.parent_id
WHERE tpr.id = /* productId */405870