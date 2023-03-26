SELECT 'eldest' AS TYPE, NAME, BIRTHDAY
FROM worker
WHERE BIRTHDAY = (SELECT MIN(BIRTHDAY) FROM worker)
UNION ALL
SELECT 'youngest' AS TYPE, NAME, BIRTHDAY
FROM worker
WHERE BIRTHDAY = (SELECT MAX(BIRTHDAY) FROM worker)