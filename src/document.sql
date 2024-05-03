create database minitest3;

use minitest3;

CREATE TABLE document (
                          id INT PRIMARY KEY,
                          code VARCHAR(255) NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          year INT NOT NULL,
                          description VARCHAR(255) NOT NULL
);

INSERT INTO document VALUES (1, 'Python', 'Lập trình tự động hóa', 2023, 'tài liệu mật'),
                            (2, 'Java', 'Lập trình web', 2022, 'tài liệu mật'),
                            (3, 'C++', 'Lập trình nhúng', 2022, 'tài liệu mật'),
                            (4, 'JS', 'Thiết kế giao diện', 2024, 'tài liệu công khai'),
                            (5, 'html', 'Văn bản', 2020, 'tài liệu công khai');

select * from document;


