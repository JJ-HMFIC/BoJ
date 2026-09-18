-- 코드를 입력하세요
SELECT m.member_name, r.REVIEW_TEXT , DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
from MEMBER_PROFILE m join REST_REVIEW r
on m.MEMBER_ID = r.MEMBER_ID

where m.member_id in (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    having count(*) = (
        select count(*)
        from REST_REVIEW
        group by MEMBER_ID 
        order by count(*) desc
        limit 1
    )
)

order by REVIEW_DATE asc, r.REVIEW_TEXT asc

