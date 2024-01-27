SELECT tor.quantity, tor.unit_price, tor.actual_unit_price, tor.discount, tor.quantity*tor.actual_unit_price AS total_price,
       tpr.id AS product_id, tpr.name AS product_name, tpr.quantity_per_unit AS product_quantity_per_unit
FROM t_order_detail tor left join t_product tpr on tor.product_id = tpr.id
WHERE tor.order_id = /* orderId */'201907030001'