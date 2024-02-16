DELETE FROM MyAnswers;
DELETE FROM Answer;
DELETE FROM Question;


ALTER TABLE Answer AUTO_INCREMENT = 1;
ALTER TABLE Question AUTO_INCREMENT = 1;

INSERT INTO Question  (id, name)
VALUES (1, 'What is your favorite color?'),
       (2, 'Do you like this interview?'),
       (3, 'Instagram or TikTok?');

INSERT INTO Answer (questionId, answer_text)
VALUES (1, 'Black'),
       (1, 'White'),
       (1, 'Red'),
       (1, 'Other'),
       (2, 'Yes'),
       (2, 'No'),
       (2, 'Not sure'),
       (3, 'Instagram'),
       (3, 'TikTok'),
       (3, 'Other');