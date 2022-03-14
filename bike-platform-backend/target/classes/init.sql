    create table `admin` (
        `id` int  AUTO_INCREMENT PRIMARY KEY,
        `name` varchar(255) ,
        `password` varchar(255) 
    );

    create table `user` (
        `id` int  AUTO_INCREMENT PRIMARY KEY,
        `name` varchar(255) ,
        `password` varchar(255) ,
        `img_url` varchar(255) ,
        `status` int
    );

    create table `order` (
        `id` int  AUTO_INCREMENT PRIMARY KEY,
        `rent_id` int ,
        `user_id` int ,
        `status` int 
    );

    create table `rent` (
        `id` int  AUTO_INCREMENT PRIMARY KEY,
        `user_id` int ,
        `title` varchar(255) ,
        `start_at` datetime ,
        `end_at` datetime ,
        `need_money` int 
    );

    create table `message` (
        `id` int  AUTO_INCREMENT PRIMARY KEY,
        `user_id` int ,
        `target_id` int ,
        `content` varchar(255) ,
    );



