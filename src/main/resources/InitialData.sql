

INSERT INTO user_details (user_id, aadhar_card_number, address, country_code, district, fathers_name, user_name, pan_card_number, phone_number, pincode, hr_id, student_id, teacher_id, address_id)
VALUES
    (501, '3456789012', '789 Oak St', 'UK', 'Village', 'Michael Johnson', 'michaelj', 'LMNOP6789Q', '9871234560', '12333', 501, 511, 521, 531),
    (502, '4567890123', '456 Birch St', 'FR', 'Countryside', 'Sophia Brown', 'sophiabrown', 'QRSTUV1234R', '8765432109', '87654', 502, 512, 522, 532),
    (503, '5678901234', '123 Maple St', 'DE', 'Suburb', 'William White', 'williamw', 'WXYZAB1234S', '7654321098', '76543', 503, 513, 523, 533),
    (504, '6789012345', '567 Pine St', 'AU', 'Hills', 'Emma Davis', 'emmad', 'CDEFG1234T', '6543210987', '65432', 504, 514, 524, 534),
    (505, '7890123456', '890 Cedar St', 'NZ', 'Mountains', 'Daniel Martinez', 'danm', 'DEFGH1234U', '5432109876', '54321', 505, 515, 525, 535),
    (506, '8901234567', '234 Redwood St', 'CA', 'Valley', 'Olivia Jones', 'oliviaj', 'EFGHI1234V', '4321098765', '43210', 506, 516, 526, 536),
    (507, '9012345678', '678 Sequoia St', 'JP', 'Desert', 'Liam Taylor', 'liamt', 'FGHIJ1234W', '3210987654', '32109', 507, 517, 527, 537),
    (508, '0123456789', '789 Palm St', 'BR', 'Beach', 'Ava Wilson', 'avaw', 'GHIJK1234X', '2109876543', '21098', 508, 518, 528, 538),
    (509, '1234567890', '345 Oak St', 'RU', 'Island', 'Noah Lee', 'noahl', 'HIJKL1234Y', '1098765432', '10987', 509, 519, 529, 539),
    (510, '2345678901', '456 Elm St', 'CN', 'City', 'Mia Adams', 'miaa', 'IJKLM1234Z', '0987654321', '09876', 510, 520, 530, 540);



INSERT INTO user_details (user_id, aadhar_card_number, address, country_code, district, fathers_name, user_name, pan_card_number, phone_number, pincode, hr_id, student_id, teacher_id, address_id)
VALUES
    (511, '1234567890', '123 Oak St', 'US', 'City', 'John Smith', 'johns', 'ABCD1234E', '9876543210', '12345', 501, NULL, 521, 531),
    (512, '2345678901', '456 Elm St', 'CA', 'Valley', 'Emily Johnson', 'emilyj', 'BCDE1234F', '8765432109', '23456', 502, NULL, 522, 532),
    (513, '3456789012', '789 Oak St', 'UK', 'Village', 'Michael Brown', 'michaelb', 'CDEF1234G', '7654321098', '34567', 503, NULL, 523, 533),
    (514, '4567890123', '456 Birch St', 'FR', 'Countryside', 'Sophia Davis', 'sophiad', 'DEFG1234H', '6543210987', '45678', 504, NULL, 524, 534),
    (515, '5678901234', '123 Maple St', 'DE', 'Suburb', 'William Martinez', 'williamm', 'EFGH1234I', '5432109876', '56789', 505, NULL, 525, 535),
    (516, '6789012345', '567 Pine St', 'AU', 'Hills', 'Emma Taylor', 'emmat', 'FGHI1234J', '4321098765', '67890', 506, NULL, 526, 536),
    (517, '7890123456', '890 Cedar St', 'NZ', 'Mountains', 'Daniel Wilson', 'danielw', 'GHIJ1234K', '3210987654', '78901', 507, NULL, 527, 537),
    (518, '8901234567', '234 Redwood St', 'CA', 'Valley', 'Olivia Lee', 'olivial', 'HIJK1234L', '2109876543', '89012', 508, NULL, 528, 538),
    (519, '9012345678', '678 Sequoia St', 'JP', 'Desert', 'Liam Adams', 'liama', 'IJKL1234M', '1098765432', '90123', 509, NULL, 529, 539),
    (520, '0123456789', '789 Palm St', 'BR', 'Beach', 'Ava Jones', 'avaj', 'JKLM1234N', '0987654321', '01234', 510, NULL, 530, 540);


INSERT INTO human_resource_team (hr_id, departmant, employee_id, job_title, user_id)
VALUES
    (501, 'HR Department 3', 'EMP001', 'HR Manager', 501),
    (502, 'HR Department 4', 'EMP002', 'HR Coordinator', 502),
    (503, 'HR Department 5', 'EMP003', 'HR Specialist', 503),
    (504, 'HR Department 6', 'EMP004', 'HR Analyst', 504),
    (505, 'HR Department 7', 'EMP005', 'HR Administrator', 505),
    (506, 'HR Department 8', 'EMP006', 'HR Manager', 506),
    (507, 'HR Department 9', 'EMP007', 'HR Coordinator', 507),
    (508, 'HR Department 10', 'EMP008', 'HR Specialist', 508),
    (509, 'HR Department 11', 'EMP009', 'HR Analyst', 509),
    (510, 'HR Department 12', 'EMP010', 'HR Administrator', 510);


INSERT INTO identity_document (user_id)
VALUES
    (501),
    (502),
    (503),
    (504),
    (505),
    (506),
    (507),
    (508),
    (509),
    (510),
    (511),
    (512),
    (513),
    (514),
    (515),
    (516),
    (517),
    (518),
    (519),
    (520);



INSERT INTO leave_application (start_date, end_date, reason, is_approved, student_id)
VALUES
    ('2023-11-01', '2023-11-05', 'Vacation', true, 511),
    ('2023-11-02', '2023-11-06', 'Family Emergency', false, 512),
    ('2023-11-03', '2023-11-07', 'Sick Leave', true, 513),
    ('2023-11-04', '2023-11-08', 'Personal Reasons', false, 514),
    ('2023-11-05', '2023-11-09', 'Vacation', true, 515),
    ('2023-11-06', '2023-11-10', 'Family Emergency', false, 516),
    ('2023-11-07', '2023-11-11', 'Sick Leave', true, 517),
    ('2023-11-08', '2023-11-12', 'Personal Reasons', false, 518),
    ('2023-11-09', '2023-11-13', 'Vacation', true, 519),
    ('2023-11-10', '2023-11-14', 'Family Emergency', false, 520);


INSERT INTO live_class_video (student_id)
VALUES
    (511),
    (512),
    (513),
    (514),
    (515),
    (516),
    (517),
    (518),
    (519),
    (520);


INSERT INTO notification (student_id, message, timestamp)
VALUES
    (511, 'New notification for student 3', '2023-10-15 10:00:00'),
    (512, 'New notification for student 4', '2023-10-16 11:00:00'),
    (513, 'New notification for student 5', '2023-10-17 12:00:00'),
    (514, 'New notification for student 6', '2023-10-18 13:00:00'),
    (515, 'New notification for student 7', '2023-10-19 14:00:00'),
    (516, 'New notification for student 8', '2023-10-20 15:00:00'),
    (517, 'New notification for student 9', '2023-10-21 16:00:00'),
    (518, 'New notification for student 10', '2023-10-22 17:00:00'),
    (519, 'New notification for student 11', '2023-10-23 18:00:00'),
    (520, 'New notification for student 12', '2023-10-24 19:00:00');


INSERT INTO student_table (academic_advisor, batch, major, roll_number, total_credits, student_id, user_id)
VALUES
    ('Advisor 3', 'Batch 3', 'Major 3', 'R0003', 50, 511, 511),
    ('Advisor 4', 'Batch 4', 'Major 4', 'R0004', 60, 512, 512),
    ('Advisor 5', 'Batch 5', 'Major 5', 'R0005', 70, 513, 513),
    ('Advisor 6', 'Batch 6', 'Major 6', 'R0006', 80, 514, 514),
    ('Advisor 7', 'Batch 7', 'Major 7', 'R0007', 90, 515, 515),
    ('Advisor 8', 'Batch 8', 'Major 8', 'R0008', 100, 516, 516),
    ('Advisor 9', 'Batch 9', 'Major 9', 'R0009', 110, 517, 517),
    ('Advisor 10', 'Batch 10', 'Major 10', 'R0010', 120, 518, 518),
    ('Advisor 11', 'Batch 11', 'Major 11', 'R0011', 130, 519, 519),
    ('Advisor 12', 'Batch 12', 'Major 12', 'R0012', 140, 520, 520);



INSERT INTO student_test (test_date, test_description, test_name, total_marks, student_id, test_type_id, test_content)
VALUES
    ('2023-09-15', 'Math Quiz 1', 'Mathematics Quiz', 20, 511, 1, 'Answer the following math problems.'),
    ('2023-09-16', 'Art History Assignment', 'Art History Assignment 1', 15, 512, 2, 'Analyze a famous painting.'),
    ('2023-09-17', 'CS Lab Test', 'Computer Science Lab Test', 30, 513, 3, 'Write a Python program.'),
    ('2023-09-18', 'Physics Exam', 'Physics Midterm Exam', 25, 514, 1, 'Solve physics problems.'),
    ('2023-09-19', 'Literature Essay', 'Literature Essay 1', 20, 515, 2, 'Analyze a novel.'),
    ('2023-09-20', 'Chemistry Lab Report', 'Chemistry Lab Report 2', 30, 516, 3, 'Chemical experiments report.'),
    ('2023-09-21', 'Economics Paper', 'Economics Research Paper', 25, 517, 1, 'Research and analysis.'),
    ('2023-09-22', 'Psychology Project', 'Psychology Group Project', 30, 518, 2, 'Group project presentation.'),
    ('2023-09-23', 'Biology Research Paper', 'Biology Research Paper 1', 20, 519, 1, 'Research on a biological topic.'),
    ('2023-09-24', 'History Exam', 'History Final Exam', 30, 520, 3, 'Answer questions about historical events.');


INSERT INTO user_details (user_id, aadhar_card_number, address, country_code, district, fathers_name, user_name, pan_card_number, phone_number, pincode, hr_id, student_id, teacher_id, address_id)
VALUES
    (521, '1234567890', '123 Oak St', 'US', 'City', 'John Smith', 'johns', 'ABCD1234E', '9876543210', '12345', 521, NULL, 531, 541),
    (522, '2345678901', '456 Elm St', 'CA', 'Valley', 'Emily Johnson', 'emilyj', 'BCDE1234F', '8765432109', '23456', 522, NULL, 532, 542),
    (523, '3456789012', '789 Oak St', 'UK', 'Village', 'Michael Brown', 'michaelb', 'CDEF1234G', '7654321098', '34567', 523, NULL, 533, 543),
    (524, '4567890123', '456 Birch St', 'FR', 'Countryside', 'Sophia Davis', 'sophiad', 'DEFG1234H', '6543210987', '45678', 524, NULL, 534, 544),
    (525, '5678901234', '123 Maple St', 'DE', 'Suburb', 'William Martinez', 'williamm', 'EFGH1234I', '5432109876', '56789', 525, NULL, 535, 545),
    (526, '6789012345', '567 Pine St', 'AU', 'Hills', 'Emma Taylor', 'emmat', 'FGHI1234J', '4321098765', '67890', 526, NULL, 536, 546),
    (527, '7890123456', '890 Cedar St', 'NZ', 'Mountains', 'Daniel Wilson', 'danielw', 'GHIJ1234K', '3210987654', '78901', 527, NULL, 537, 547),
    (528, '8901234567', '234 Redwood St', 'CA', 'Valley', 'Olivia Lee', 'olivial', 'HIJK1234L', '2109876543', '89012', 528, NULL, 538, 548),
    (529, '9012345678', '678 Sequoia St', 'JP', 'Desert', 'Liam Adams', 'liama', 'IJKL1234M', '1098765432', '90123', 529, NULL, 539, 549),
    (530, '0123456789', '789 Palm St', 'BR', 'Beach', 'Ava Jones', 'avaj', 'JKLM1234N', '0987654321', '01234', 530, NULL, 540, 550);


/*INSERT INTO address (address_id, address_line, city, state, country, postal_code)
VALUES
    (541, '123 Oak St', 'New York', 'NY', 'US', '12345'),
    (542, '456 Elm St', 'Los Angeles', 'CA', 'US', '23456'),
    (543, '789 Oak St', 'London', NULL, 'UK', '34567'),
    (544, '456 Birch St', 'Paris', NULL, 'FR', '45678'),
    (545, '123 Maple St', 'Berlin', NULL, 'DE', '56789'),
    (546, '567 Pine St', 'Sydney', 'NSW', 'AU', '67890'),
    (547, '890 Cedar St', 'Auckland', NULL, 'NZ', '78901'),
    (548, '234 Redwood St', 'Los Angeles', 'CA', 'US', '89012'),
    (549, '678 Sequoia St', 'Tokyo', NULL, 'JP', '90123'),
    (550, '789 Palm St', 'Rio de Janeiro', NULL, 'BR', '01234');*/
