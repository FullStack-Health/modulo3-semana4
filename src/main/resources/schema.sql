
CREATE TABLE IF NOT EXISTS public.reminders (
  id bigserial PRIMARY KEY,
  title varchar(50) NOT NULL,
  description varchar(255) NULL,
  remind_at timestamp(6) NOT NULL,
  priority varchar(10) NOT NULL,
  status varchar(10) NOT NULL
);
