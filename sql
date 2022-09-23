CREATE TEMPORARY TABLE boxes_to_restore
(rebillable_id int(10) unsigned,
 bh_id int(10) unsigned,
 billing_frequency tinyint(3) unsigned,
 prev_cycle_status int(10) unsigned,
 unique index (rebillable_id),
 unique index (bh_id));
 
INSERT INTO boxes_to_restore (rebillable_id, bh_id, billing_frequency, prev_cycle_status)
SELECT rs.rebillable_id as rebillable_id, bh2.id as bh_id, rs.billing_frequency as billing_frequency, COALESCE(SUM(ctl.result='success')*100 - SUM(ctl.result='failure'),0) as prev_cycle_status
FROM rebillable_subscriptions rs
JOIN box_history bh ON bh.subscription_id=rs.rebillable_id AND bh.shipping_cycle_id=108
JOIN box_history bh2 ON bh2.subscription_id=rs.rebillable_id AND bh2.shipping_cycle_id=109
LEFT JOIN card_transactions_log ctl ON ctl.box_history_id=bh.id
WHERE rs.billing_status = 2
GROUP BY rs.rebillable_id
HAVING prev_cycle_status >= 0
ORDER BY rs.rebillable_id asc;

-- Query OK, 778 rows affected (0.83 sec)
-- Records: 778  Duplicates: 0  Warnings: 0


--- after the BBB


UPDATE rebillable_subscriptions rs
JOIN boxes_to_restore btr ON btr.rebillable_id=rs.rebillable_id
SET rs.billing_status=2;

UPDATE box_history bh
JOIN boxes_to_restore btr ON btr.bh_id=bh.id
SET bh.is_on_hold = 1, bh.is_reserved = 1;

SELECT *
FROM boxes_to_restore
INTO OUTFILE '/tmp/boxes_to_restore.20151114.csv'
FIELDS TERMINATED BY ',';
