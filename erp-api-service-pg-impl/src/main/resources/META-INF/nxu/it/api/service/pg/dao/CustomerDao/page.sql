SELECT tcu.id, name, contact, province, city, address, region, phone
FROM t_customer tcu
WHERE
/*%if @isNotBlank(name) */
    tcu.name ILIKE '%' || /* name */'广' || '%'
/*%end*/
/*%if @isNotBlank(region) */
  AND tcu.region ILIKE '%' || /* region */'东' || '%'
/*%end*/
/*%if @isNotBlank(province) */
  AND tcu.province ILIKE '%' || /* province */'东' || '%'
/*%end*/
/*%if @isNotBlank(city) */
  AND tcu.city ILIKE '%' || /* city */'广' || '%'
/*%end*/