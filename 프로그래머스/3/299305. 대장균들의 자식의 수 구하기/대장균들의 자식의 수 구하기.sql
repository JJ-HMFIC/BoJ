-- 코드를 작성해주세요
select a.id, ifnull(count(b.id),0) as 'child_count'
from ECOLI_DATA a left join ECOLI_DATA b
on a.id = b.parent_id
group by a.id

# SELECT 
#     A.ID, 
#     COUNT(B.ID) AS CHILD_COUNT  -- COUNT(컬럼명)은 NULL을 0으로 세주기 때문에 IFNULL이 필수는 아니에요!
# FROM ECOLI_DATA A 
# LEFT JOIN ECOLI_DATA B          -- 모든 A(부모 후보)를 다 살리기 위해 LEFT JOIN 사용
#     ON A.ID = B.PARENT_ID
# GROUP BY A.ID
# ORDER BY A.ID;                  -- 마지막에 ID 기준 정렬도 잊지 마세요!
