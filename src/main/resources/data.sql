--INSERT INTO patient(full_name,age,gender,blood_group,phone_number,email,address_id,emergency_contact_number,birth_date) VALUES
-- ('Sarbanando Sonowal','33','Male','1123456789' '2000-05-15', 'sarbanonndo@gmail.com','O_POSITIVE'),
-- ('Raghab Chadda', '1977-05-15', 'raghab@gmail.com', 'Male','B_POSITIVE'),
-- ('Amit Shah', '1960-05-15', 'amit@gmail.com', 'Male','AB_POSITIVE'),
-- ('Narendra Modi', '1979-05-15', 'modi@gmail.com', 'Male','A_NEGATIVE'),
-- ('Himanto Biswo Sharma', '1974-05-15', 'himanto@gmail.com', 'Male','A_NEGATIVE');

INSERT INTO patient(
    full_name,
    age,
    gender,
    blood_group,
    phone_number,
    email,
    emergency_contact_number,
    birth_date
) VALUES
(
    'Sarbanando Sonowal',
    33,
    'MALE',
    'O_POSITIVE',
    '1123456789',
    'sarbanonndo@gmail.com',
    '9876543210',
    '2000-05-15'
),
(
    'Raghab Chadda',
    48,
    'MALE',
    'B_POSITIVE',
    '9876543211',
    'raghab@gmail.com',
    '9876543212',
    '1977-05-15'
),
(
    'Amit Shah',
    65,
    'MALE',
    'AB_POSITIVE',
    '9876543213',
    'amit@gmail.com',
    '9876543214',
    '1960-05-15'
),
(
    'Narendra Modi',
    46,
    'MALE',
    'A_NEGATIVE',
    '9876543215',
    'modi@gmail.com',
    '9876543216',
    '1979-05-15'
),
(
    'Himanto Biswo Sharma',
    52,
    'MALE',
    'A_NEGATIVE',
    '9876543217',
    'himanto@gmail.com',
    '9876543218',
    '1974-05-15'
);
