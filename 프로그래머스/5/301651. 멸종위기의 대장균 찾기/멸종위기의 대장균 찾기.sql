WITH RECURSIVE ecoli_tree AS (
    -- 1. 루트 (1세대)
    SELECT 
        ID,
        PARENT_ID,
        1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL

    -- 2. 자식으로 확장
    SELECT 
        e.ID,
        e.PARENT_ID,
        t.GENERATION + 1
    FROM ECOLI_DATA e
    JOIN ecoli_tree t
        ON e.PARENT_ID = t.ID
)

-- 3. leaf만 필터링 + 세대별 집계
SELECT 
    COUNT(*) AS COUNT,
    t.GENERATION
FROM ecoli_tree t
LEFT JOIN ECOLI_DATA c
    ON t.ID = c.PARENT_ID
WHERE c.ID IS NULL   -- 자식 없는 애들
GROUP BY t.GENERATION
ORDER BY t.GENERATION;