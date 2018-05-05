CREATE TABLE borrow_event (
   id BIGINT NOT NULL
  ,borrowed_at DATE
  ,borrowed_to VARCHAR(255)
  ,item_id BIGINT NOT NULL
  ,returned_at DATE
  ,PRIMARY KEY (id)
);

CREATE TABLE comment (
   id BIGINT NOT NULL
  ,commenter BIGINT NOT NULL
  ,message VARCHAR(255)
  ,task_id BIGINT
  ,PRIMARY KEY (id)
);

CREATE TABLE item (
   id BIGINT NOT NULL
  ,category VARCHAR(255)
  ,description VARCHAR(255)
  ,name VARCHAR(255)
  ,PRIMARY KEY (id)
);

CREATE TABLE notification (
   id BIGINT NOT NULL
  ,frequency BIGINT
  ,notification_topic INT
  ,recipient BIGINT NOT NULL
  ,sneeze BIGINT
  ,topic_id BIGINT NOT NULL
  ,PRIMARY KEY (id)
);

CREATE TABLE task (
   id BIGINT NOT NULL
  ,archived boolean NOT NULL
  ,assigned_to BIGINT NOT NULL
  ,author_id BIGINT NOT NULL
  ,deadline DATE
  ,description VARCHAR(255)
  ,remind_before BINARY (255)
  ,STATUS INT
  ,PRIMARY KEY (id)
);

CREATE TABLE task_assignable_to (
   task_id BIGINT NOT NULL
  ,assignable_to BIGINT
);

CREATE TABLE task_linked_tasks (
   task_id BIGINT NOT NULL
  ,linked_tasks BIGINT
);

CREATE TABLE task_related_users (
   task_id BIGINT NOT NULL
  ,related_users BIGINT
);

CREATE TABLE task_template (
   id BIGINT NOT NULL
  ,assignee BIGINT
  ,author BIGINT NOT NULL
  ,description VARCHAR(255)
  ,remind_before BINARY (255)
  ,repeat_mode INT
  ,task_status INT
  ,PRIMARY KEY (id)
);

CREATE TABLE task_template_assigned_to (
   task_template_id BIGINT NOT NULL
  ,assigned_to BIGINT
);

CREATE TABLE user (
   id BIGINT NOT NULL
  ,name VARCHAR(25) NOT NULL
  ,password VARCHAR(60) NOT NULL
  ,ROLE INT NOT NULL
  ,PRIMARY KEY (id)
);

CREATE TABLE user_new_comments (
   user_id BIGINT NOT NULL
  ,new_comments BIGINT
);