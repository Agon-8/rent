alter table customers
add column user_id int,
add constraint fk_user_id foreign key (user_id) references users(user_id)