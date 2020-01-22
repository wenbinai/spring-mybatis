# 简单易懂的Springboot-Mybatis入门篇

> 工具
>
> maven:  3.6.1
>
> jdk: 1.8
>
> IDEA 2019.02
>
> SpringBoot: 2.2.2
>
> Mybatis:  2.1.1

## 配置Mysql

```xml
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## 测试Mysql是否连接成功

```java
@SpringBootTest
class LearningApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

}
```

## 构建实体类

```java
package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;
}
```

## 配置Mybatis

```xml
mybatis.type-aliases-package=com.example.pojo
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
```

## 构建Mapper接口

```java
@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
```

## 配置相关Sql语句

```
<?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE mapper
                PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
                "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.mapper.UserMapper">
<select id="queryUserList" resultType="User">
        select * from user
    </select>

<select id="selectUserById" resultType="User">
        select * from user where id = #{id}
    </select>

<select id="addUser" parameterType="User">
        insert into user (id, name, pwd) values (#{id}, #{name}, #{pwd})
    </select>
</mapper>
```

> 源码: https://github.com/wenbinai/spring-mybatis
