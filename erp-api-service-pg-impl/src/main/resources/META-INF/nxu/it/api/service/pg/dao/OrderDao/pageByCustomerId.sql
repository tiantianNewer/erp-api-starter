SELECT tor.id, tor.order_date, tor.ship_date, tor.arrival_date, tor.freight, tor.ship_address, tor.ship_province, tor.ship_city, tor.ship_region,tor.contact,
       tcu.id AS customer_id, tcu.name AS customer_name, tcu.contact AS customer_contact, tcu.phone AS customer_phone,
       tem.id AS employee_id, tem.name AS employee_name, tem.phone AS employee_phone,
       tsh.id AS shipper_id, tsh.name AS shipper_name, tsh.phone AS shipper_phone
FROM t_order tor
         left join t_customer tcu on tor.customer_id = tcu.id
         left join t_employee tem on tor.employee_id = tem.id
         left join t_shipper tsh on tor.shipper_id = tsh.id
WHERE
    tor.customer_id = /* customerId */78
    /*%if startDate != null || endDate != null */
    AND tor.order_date BETWEEN /* startDate */'2019-07-03 10:08:00.000000' AND /* endDate */'2022-12-01 00:00:01.000000'
    /*%end*/
    /*%if @isNotBlank(customerName) */
    AND tor.customer_id IN (SELECT id FROM t_customer tc WHERE tc.contact LIKE '%' || /* customerName */'吴' || '%')
    /*%end*/
    /*%if @isNotBlank(shipperName) */
    AND tor.shipper_id IN (SELECT id FROM t_shipper ts WHERE ts.name LIKE '%' || /* shipperName */'顺丰' || '%')
    /*%end*/
    /*%if @isNotBlank(shipProvince) */
    AND tor.ship_province ILIKE '%' || /* shipProvince */'吉林' || '%'
    /*%end*/
    /*%if @isNotBlank(shipCity) */
    AND tor.ship_city ILIKE '%' || /* shipCity */'通' || '%'
    /*%end*/
    /*%if @isNotBlank(shipRegion) */
    AND tor.ship_region ILIKE '%' || /* shipRegion */'华' || '%'
    /*%end*/