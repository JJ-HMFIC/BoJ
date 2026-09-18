-- 코드를 입력하세요
SELECT b.BOOK_ID , a.AUTHOR_NAME, b.PUBLISHED_DATE
from BOOK b join AUTHOR a
on b.author_id = a.author_id
where b.CATEGORY = '경제'

order by b.PUBLISHED_DATE asc
