SELECT tpr.id, tpr.name, tpr.quantity_per_unit,
       tpu.purchase_unit_price, tpu.amount AS purchase_amount,
       tsu.id AS supplier_id, tsu.name AS supplier_name
FROM t_purchase tpu
    left join t_product tpr on tpu.product_id = tpr.id
    left join t_supplier tsu on tpu.supplier_id = tsu.id
WHERE
    /*%if @isNotBlank(name) */
        tpr.name ILIKE '%' || /* name */'巾' || '%'
    /*%end*/
    /*%if @isNotBlank(supplierName) */
        AND tsu.name ILIKE '%' || /* supplierName */'周' || '%'
    /*%end*/
    /*%if startDate!=null && endDate!=null */
      AND tpu.purchase_date BETWEEN /* startDate */'2018-01-01' AND /* endDate */'2022-01-01'
    /*%end*/
