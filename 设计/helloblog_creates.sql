use helloblog;

create table if not exists blog_info (
	blog_id bigint(20) not null auto_increment comment '博客文章ID',
    author_id bigint(20) not null comment '作者ID',
    title varchar(40) not null comment '博客文章标题',
    release_time datetime not null comment '博客文章发布时间',
    view_count bigint(20) default '0' comment '浏览量',
    like_count bigint(20) default '0' comment '点赞数',
    primary key (blog_id)
)engine=innodb auto_increment=1 default charset=utf8 comment='博客文章信息表';

create table if not exists user_info (
	user_id bigint(20) not null auto_increment comment '用户ID',
    user_name varchar(40) not null comment '用户账号',
    password varchar(225) not null comment '用户密码',
    nick_name varchar(40) not null comment '用户昵称',
    role_id bigint(20) not null default 1 comment '角色ID',
    create_time datetime not null comment '创建时间',
	primary key(user_id)
)engine=innodb auto_increment=1 default charset=utf8 comment='用户信息表'

-- 插入测试数据 
insert into helloblog.blog_info values (1,1,'这是测试数据title','2018-11-14 14:19:22',1,1);
select * from helloblog.blog_info;
insert into helloblog.user_info values(1,'wupengchoy','123456','youting',1,'2018-11-14 15:19:22');
select * from helloblog.user_info;