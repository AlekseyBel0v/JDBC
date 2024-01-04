select lower(c.name), o.product_name
from netology.customers c
         join netology.orders o on c.id = o.customer_id
where c.name ILIKE (?)
group by o.product_name, lower(c.name);