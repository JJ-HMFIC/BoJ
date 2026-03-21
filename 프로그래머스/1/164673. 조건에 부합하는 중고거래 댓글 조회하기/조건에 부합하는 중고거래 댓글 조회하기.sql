-- 코드를 입력하세요
SELECT ugd.title, ugd.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, date_format(ugr.created_date, '%Y-%m-%d') as 'CREATED_DATE'
from USED_GOODS_BOARD ugd join USED_GOODS_REPLY ugr
on ugd.BOARD_ID = ugr.BOARD_ID

where year(ugd.created_date) = 2022
and month(ugd.created_date) = 10

order by ugr.created_date asc, title asc