-- 코드를 입력하세요
SELECT concat("/home/grep/src/",b.board_id,"/",f.file_id,f.FILE_NAME ,f.file_ext) as FILE_PATH
from USED_GOODS_BOARD b join USED_GOODS_FILE f
on b.BOARD_ID = f.BOARD_ID

where b.views >= (
    select max(b.views)
    from USED_GOODS_BOARD b
)

order by f.file_id desc
