-- 코드를 작성해주세요
select ii.ITEM_ID, ii.item_name, ii.rarity
from ITEM_INFO ii
where ii.item_id in(
    select it.item_id
    from ITEM_TREE it 
    where it.parent_item_id in ( # rare인 아이템이 부모인 경우, 즉, 'RARE'인 아이템들의 모든 다음 업그레이드 아이템은 rare가 parent인 경우임
        select ii.item_id 
        from ITEM_INFO ii 
        where ii.RARITY = 'RARE')
    )

order by ii.item_id desc

