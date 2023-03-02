-- Entity description: User represents the individuals who interact with the system, including administrators, teachers, students and attendants.
CREATE TABLE "user" (
  user_id SERIAL PRIMARY KEY,
  first_name VARCHAR(50),
  second_name VARCHAR(50),
  last_name VARCHAR(50),
  second_last_name VARCHAR(50),
  email_address VARCHAR(100),
  identification_type VARCHAR(5),
  identification_number VARCHAR(20),
  phone_number VARCHAR(20),
  role VARCHAR(20),
  username VARCHAR(50),
  password TEXT
);

-- Entity description: Area represents the academic areas or departments that organize the courses in the school, such as Mathematics, Science, or Social Studies.
CREATE TABLE area (
  area_id SERIAL PRIMARY KEY,
  area_name VARCHAR(50)
);

-- Entity description: Course represents the academic courses offered by the school, including the course name, level, description, prerequisites, and the academic area to which it belongs.
CREATE TABLE course (
  course_id SERIAL PRIMARY KEY,
  course_name VARCHAR(100),
  description TEXT,
  area_id INTEGER REFERENCES area(area_id)
);

-- Entity description: level represents a level for a course
CREATE TABLE level (
  level_id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT
);

CREATE TABLE course_level (
  id SERIAL PRIMARY KEY,
  course_id INTEGER REFERENCES course(course_id),
  level_id INTEGER REFERENCES level(level_id),
  UNIQUE (course_id, level_id)
);


-- Entity description: Grade represents the grade records for a specific course and student, including the grade, the date it was issued, and any comments.
CREATE TABLE grade (
  grade_id SERIAL PRIMARY KEY,
  course_level_id INTEGER REFERENCES course_level(id),
  user_id INTEGER REFERENCES "user"(user_id),
  date_of_grade DATE,
  grade FLOAT,
  comments TEXT
);

-- Entity description: Classroom represents the physical classrooms where courses are held, including the classroom number, capacity, and location.
CREATE TABLE classroom (
  classroom_id SERIAL PRIMARY KEY,
  classroom_number VARCHAR(10),
  capacity INTEGER,
  location VARCHAR(50)
);

-- Entity description: Schedule represents the course schedule for a specific teacher, including the course, the teacher, the classroom, start time, end time, and day of the week.
CREATE TABLE schedule (
  schedule_id SERIAL PRIMARY KEY,
  course_level_id INTEGER REFERENCES course_level(id),
  user_id INTEGER REFERENCES "user"(user_id),
  classroom_id INTEGER REFERENCES classroom(classroom_id),
  start_time TIME,
  end_time TIME,
  day_of_week VARCHAR(20)
);

-- Entity description: Enrolled represents the course enrollments for a specific student, including the course and the student.
CREATE TABLE enrolled (
  enrolled_id SERIAL PRIMARY KEY,
  course_level_id INTEGER REFERENCES course_level(id),
  user_id INTEGER REFERENCES "user"(user_id)
);

-- Entity description: Teaches represents the course assignments for a specific teacher, including the course and the teacher.
CREATE TABLE teaches (
  teaches_id SERIAL PRIMARY KEY,
  course_level_id INTEGER REFERENCES course_level(id),
  user_id INTEGER REFERENCES "user"(user_id)
);

-- Entity description: Room represents the non-classroom rooms in the school, such as offices, labs, or libraries.
CREATE TABLE room (
  room_id SERIAL PRIMARY KEY,
  room_number VARCHAR(10)
);

-- Entity description: Assigned represents the room assignments for a specific course, including the course and the room assigned to it.
CREATE TABLE assigned (
  assigned_id SERIAL PRIMARY KEY,
  course_level_id INTEGER REFERENCES course_level(id),
  room_id INTEGER REFERENCES room(room_id)
);

CREATE TABLE attendant (
  attendant_id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES "user"(user_id)
);

CREATE TABLE student (
  student_id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES "user"(user_id),
  attendant_id INTEGER REFERENCES attendant(attendant_id) NOT NULL
);

-- Relationships
ALTER TABLE grade ADD CONSTRAINT FK_Grade_User FOREIGN KEY (user_id) REFERENCES "user"(user_id);
ALTER TABLE grade ADD CONSTRAINT FK_Grade_Course FOREIGN KEY (course_level_id) REFERENCES course_level(id);
ALTER TABLE schedule ADD CONSTRAINT FK_Schedule_User FOREIGN KEY (user_id) REFERENCES "user"(user_id);
ALTER TABLE schedule ADD CONSTRAINT FK_Schedule_Course FOREIGN KEY (course_level_id) REFERENCES course_level(id);
ALTER TABLE schedule ADD CONSTRAINT FK_Schedule_Classroom FOREIGN KEY (classroom_id) REFERENCES classroom(classroom_id);
ALTER TABLE enrolled ADD CONSTRAINT FK_Enrolled_User FOREIGN KEY (user_id) REFERENCES "user"(user_id);
ALTER TABLE enrolled ADD CONSTRAINT FK_Enrolled_Course FOREIGN KEY (course_level_id) REFERENCES course_level(id);
ALTER TABLE teaches ADD CONSTRAINT FK_Teaches_User FOREIGN KEY (user_id) REFERENCES "user"(user_id);
ALTER TABLE teaches ADD CONSTRAINT FK_Teaches_Course FOREIGN KEY (course_level_id) REFERENCES course_level(id);
ALTER TABLE assigned ADD CONSTRAINT FK_Assigned_Room FOREIGN KEY (room_id) REFERENCES room(room_id);
ALTER TABLE assigned ADD CONSTRAINT FK_Assigned_Course FOREIGN KEY (course_level_id) REFERENCES course_level(id);
ALTER TABLE student ADD CONSTRAINT FK_Student_User FOREIGN KEY (user_id) REFERENCES "user"(user_id);
ALTER TABLE student ADD CONSTRAINT FK_Student_Attendant FOREIGN KEY (attendant_id) REFERENCES attendant(attendant_id);
ALTER TABLE course_level ADD CONSTRAINT FK_course_level_course_id FOREIGN KEY (course_id) REFERENCES course(course_id);
ALTER TABLE course_level ADD CONSTRAINT FK_course_level_level_id FOREIGN KEY (level_id) REFERENCES level(level_id);
