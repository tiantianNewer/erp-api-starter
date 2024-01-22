SELECT tpr.id, tpr.name, tpr.brand, tpr.bar_code, tpr.quantity_per_unit, tpr.unit_price, tpr.units_in_stock, tpr.units_sell, tpr.photo_url,
       t3.id AS category_id3, t3.name AS category_name3, t2.id AS category_id2,  t2.name AS category_name2, t1.id AS category_id1, t1.name AS category_name1
FROM t_product tpr
    left join t_category t3 on tpr.category_id = t3.id
    left join t_category t2 on t2.id = t3.parent_id
    left join t_category t1 on t1.id = t2.parent_id
WHERE
/*%if @isNotBlank(name) */
   tpr.name ILIKE '%' || /* name */'水' || '%'
/*%end*/
/*%if @isNotBlank(brand) */
  AND tpr.brand ILIKE '%' || /* brand */'农' || '%'
/*%end*/
/*%if @isNotBlank(categoryId) */
  AND tpr.category_id LIKE /* categoryId */'01' || '%'
/*%end*/
/*%if minPrice!=null && maxPrice!=null */
  AND tpr.unit_price BETWEEN /* minPrice */20 AND /* maxPrice */40
/*%end*/
/*%if haveProduct!=null */
  /*%if !haveProduct */
    AND tpr.units_in_stock = 0
  /*%else */
    AND tpr.units_in_stock > 0
  /*%end*/
/*%end*/