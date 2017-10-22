# SMIntegrate
## springboot和mybatis整合,使用分页插件和通用mapper
- 整合mybatis(前面的springboot的依赖请看springbootTest)
  * 加入依赖
  ```
    <!-- SpringBoot的Mybatis启动器 -->
    <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter</artifactId>
      <version>1.1.1</version>
    </dependency>
   ```
   * mapper类中需要写的注解
     - 在类上写@Mapper:声明Mapper接口
     - 在方法上写@Select:声明这个接口所需要使用的查询sql(增删改也有注解)
   
           @Mapper
            public interface UserMapper {
              @Select("select * from user where name like '%${value}%'")
              public List<User> queryUserByName(String name);
            }
            
- 整合分页插件和通用Mapper(在这里感谢GitHub的前辈分享的通用分页插件和通用Mapper)
  * 加入依赖
  ```
     <!-- 通用Mapper -->
      <dependency>
        <groupId>com.github.abel533</groupId>
        <artifactId>mapper</artifactId>
        <version>2.3.4</version>
      </dependency>
      <!-- 分页插件 -->
      <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper</artifactId>
        <version>3.7.5</version>
      </dependency>
      <dependency>
        <groupId>com.github.jsqlparser</groupId>
        <artifactId>jsqlparser</artifactId>
        <version>0.9.1</version>
      </dependency>
    ```
    * 在resources下创建一个application.properties并添加配置
    ```
        #加载Mybatis核心配置文件
        mybatis.mapper-locations=classpath:mapper/*Mapper.xml
        mybatis.config-location=classpath:mybatis/SqlMapConfig.xml
    ```
    * 在resources下创建一个mapper目录,并在下面SqlMapConfig.xml配置文件,用来加载分页插件和通用mapper
    (在这里要注意顺序,分页插件一定要配置在通用mapper之前,否则会报错)
    ```
        <?xmlversion="1.0"encoding="UTF-8"?>
        <!DOCTYPEconfiguration
        PUBLIC"-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
        <configuration>
          <!-- 分页助手 -->
          <plugins>
            <plugininterceptor="com.github.pagehelper.PageHelper">
              <propertyname="dialect"value="mysql"/>
              <!-- 该参数默认为false -->
              <!-- 设置为true时，使用RowBounds分页会进行count查询 -->
              <propertyname="rowBoundsWithCount"value="true"/>
            </plugin>

            <!-- 通用Mapper -->
            <plugininterceptor="com.github.abel533.mapperhelper.MapperInterceptor">
              <!--主键自增回写方法,默认值MYSQL,详细说明请看文档 -->
              <propertyname="IDENTITY"value="MYSQL"/>
              <!--通用Mapper接口，多个通用接口用逗号隔开 -->
              <propertyname="mappers"value="com.github.abel533.mapper.Mapper"/>
            </plugin>
          </plugins>
        </configuration>
     ```
     
欢迎加本人QQ(1209211943)讨论java技术.
