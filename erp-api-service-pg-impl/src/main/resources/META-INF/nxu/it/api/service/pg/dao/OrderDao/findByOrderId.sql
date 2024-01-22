SELECT tor.id, tor.order_date, tor.ship_date, tor.arrival_date, tor.freight, tor.ship_address, tor.ship_province, tor.ship_city, tor.ship_region,tor.contact,
        tcu.id AS customer_id, tcu.name AS customer_name, tcu.contact AS customer_contact, tcu.phone AS customer_phone,
        tem.id AS employee_id, tem.name AS employee_name, tem.phone AS employee_phone,
        tsh.id AS shipper_id, tsh.name AS shipper_name, tsh.phone AS shipper_phone
FROM t_order tor
    left join t_customer tcu on tor.customer_id = tcu.id
    left join t_employee tem on tor.employee_id = tem.id
    left join t_shipper tsh on tor.shipper_id = tsh.id
-- WHERE tor.id = /* orderId */'201907030001'
WHERE tor.id = /* orderId */'202001190001'