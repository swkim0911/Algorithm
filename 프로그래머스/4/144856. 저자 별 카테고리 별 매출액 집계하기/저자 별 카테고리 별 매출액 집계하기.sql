
select a.author_id, a.author_name, b.category, sum(bs.sales_count * b.price) as total_sales

from book b
join (select book_id, sum(sales) as sales_count
        from book_sales
        where year(sales_date) = 2022 and month(sales_date) = 1
        group by book_id
     ) bs on b.book_id = bs.book_id
join author a on b.author_id = a.author_id
group by a.author_id, b.category
order by 1 asc, b.category desc