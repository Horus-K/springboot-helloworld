# SpringBoot HelloWorld

## 环境搭建

`jdk8`  设置环境变量 `java -version` 查看版本

`maven`  `mvn -v` 查看版本

在maven/config/setting.xml中加入

```
<localRepository>D:\Common Files\maven\repository</localRepository>
```

配置镜像

```
<mirrors>
<mirror>
<id>repo2</id>
<mirrorOf>central</mirrorOf>
<name>spring2.0 for this Mirror.</name>
<url>https://repo.spring.io/libs-milestone</url>
</mirror>
...
<mirrors>
```

`idea`

## 新建一个项目

1. 在http://start.spring.io/  中下载
2. 在idea中选择`Spring Initializr `
3. 在idea中选择maven

Group，⼀一般填写公司域名，⽐比如百度公司就会填： com.baidu，演示使⽤用 com.neo。
Artifact，可以理理解为项⽬目的名称了了，可以根据实际情况来填，本次演示填 hello。
Dependencies，在这块添加我们项⽬目所依赖的 Spring Boot 组件，可以多选，本次选择 Web、 Devtools
两个模块。 

## 项目结构

- src/main/java：程序开发以及主程序⼊入⼝口；
- src/main/resources：配置⽂文件；
- src/test/java：测试程序 

```
myproject
	+-src
		+- main
			+- java
				+- com.example.myproject
						+- comm
						+- model
						+- repository
						+- service
						+- web
						+- Application.java
			+- resources
					+- static
					+- templates
					+- application.properties
					+- test
	+-pom.xml
```

- Application.java，建议放到根⽬目录下⾯面，是项⽬目的启动类， Spring Boot 项⽬目只能有⼀一个 main() ⽅方法；
- comm ⽬目录建议放置公共的类，如全局的配置⽂文件、⼯工具类等；
- model ⽬目录主要⽤用于实体（Entity）与数据访问层（Repository）；
- repository 层主要是数据库访问层代码；
- service 层主要是业务类代码；
- web 层负责⻚页⾯面访问控制。
- resources ⽬目录下：
- static ⽬目录存放 web 访问的静态资源，如 js、 css、图⽚片等；
- templates ⽬目录存放⻚页⾯面模板；
- application.properties 存放项⽬目的配置信息。
- test ⽬目录存放单元测试的代码； pom.xml ⽤用于配置项⽬目依赖包，以及其他配置。 

## 配置项目

- groupId，项⽬目的包路路径；
- artifactId，项⽬目名称；
- version，项⽬目版本号；
- packaging，⼀一般有两个值： jar、 war，表示使⽤用 Maven 打包时构建成 Jar 包还是 War 包；
- name，项⽬目名称；
- description，项⽬目描述。 

在POM中加入

```xml
  <!-- web依赖-->
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
<!--启动依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    <!--热更新依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <version>2.1.5.RELEASE</version>
            <optional>true</optional>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <!--设置热更新-->
                <configuration>
                    <fork>true</fork>
                </configuration>
            </plugin>
        </plugins>
    </build>

```

在目录 src\main\java\com\yancy\helloworld\web 下创建 HelloController： 

```java
//Json 输出
@RestController
public class HelloWorldController {
// 匹配路径
    @RequestMapping("/")
    public String sayHello(String name) {
        return "Hello,world!"+name;
    }
}
```

在设置里面开启热更新 

> 选择 File | Settings | Compiler 命令，然后勾选 Build project automatically 复选框 
>

> 使⽤用快捷键 Ctrl + Shift + A，在输⼊入框中输⼊入 Registry，勾选 compile.automake.allow.when.app.running 复
> 选框 

debug 启动 ,可以访问`http://localhost:8080/?name=张三`