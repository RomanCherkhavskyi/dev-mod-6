select id, datediff(m, start_date, finish_date) as project_time from project
where datediff(m, start_date, finish_date) =
select (max(datediff(m, start_date, finish_date))) from project;