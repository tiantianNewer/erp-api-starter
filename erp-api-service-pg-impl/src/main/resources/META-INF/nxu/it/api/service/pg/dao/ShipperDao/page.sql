SELECT tsh.id, name, phone
FROM t_shipper tsh
WHERE
/*%if @isNotBlank(name) */
    tsh.name ILIKE '%' || /* name */'通' || '%'
/*%end*/