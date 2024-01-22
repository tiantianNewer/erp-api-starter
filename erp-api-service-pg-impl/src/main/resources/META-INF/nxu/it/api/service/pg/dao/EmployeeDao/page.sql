SELECT tem.id, name, birth_date, hire_date, title, region, phone
    FROM t_employee tem
WHERE
/*%if @isNotBlank(name) */
tem.name ILIKE '%' || /* name */'马' || '%'
/*%end*/
/*%if @isNotBlank(gender) */
AND tem.gender ILIKE '%' || /* gender */'男' || '%'
/*%end*/
/*%if @isNotBlank(region) */
  AND tem.region ILIKE '%' || /* region */'北' || '%'
/*%end*/
/*%if @isNotBlank(title) */
  AND tem.title ILIKE '%' || /* title */'代表' || '%'
/*%end*/