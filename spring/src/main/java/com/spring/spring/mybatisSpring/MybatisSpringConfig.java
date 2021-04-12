package com.spring.spring.mybatisSpring;


import com.spring.spring.mybatisSpring.core.MyFactoryBean;
import com.spring.spring.mybatisSpring.core.MyImportBeanDefinitionRegistrar;
import com.spring.spring.mybatisSpring.core.MyMapperScan;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
//@MapperScan("com.spring.spring.mybatisSpring.dao")
//@Import(MyImportBeanDefinitionRegistrar.class)
@MyMapperScan
public class MybatisSpringConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/aa.test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=Asia/Shanghai&useSSL=false&nullNamePatternMatchesAll=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    /**
     * SqlSessionFactory交给Spring容器
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());//设置数据源
        return factoryBean.getObject();
    }

    /**
     * Mapper接口交给Spring容器管理
     * 缺点：有很多业务mapper时需要创建很多bean,可以使用@MapperScan
     * @return
     * @throws Exception
     */
//    @Bean
//    public MapperFactoryBean<UserMapper> userMapper() throws Exception {
//        MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<>(UserMapper.class);
//        factoryBean.setSqlSessionFactory(sqlSessionFactory());
//        return factoryBean;
//    }

//    @Bean
//    public MyFactoryBean myFactoryBean(){
//        return new MyFactoryBean();
//    }

}
