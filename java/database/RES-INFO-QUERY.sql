select restaurant_name, business_days.days_open, business_hours.hours_open from restaurants r
join business_days ON business_days.day_id = r.open_days
JOIN business_hours ON business_hours.hours_id = r.open_hours;

-- SELECT * FROM restaurants;