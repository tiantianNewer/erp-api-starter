SELECT tsu.id, name, phone
FROM t_supplier tsu
WHERE
/*%if @isNotBlank(name) */
    tsu.name ILIKE '%' || /* name */'广西' || '%'
/*%end*/