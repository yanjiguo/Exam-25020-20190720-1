1，软件的基本功能
       软件主要的功能：实现了将功能链接全部显示在index.jsp页面（包括登录、查看电影列表、添加新的电影）。
   实现了登录的判断并将First_name保存在session中，实现了电影信息列表的展示（同时进行了分页，每页显示10条数据）
   和电影信息的添加、删除、编辑。实现了登录过滤的处理，在没有登录之前所有的链接访问之后都跳转到index.jsp页面。
   但是对于含有login的和登录请求的LoginServlet以及静态资源不拦截。
2，运行代码的方法：安装环境，启动命令等
   项目使用的数据库：mysql5.0  用户名  root 密码  123456
   在项目的resources文件夹中的db.properties中关于数据库的配置文件
   整个项目使用的是tomcat7的插件在maven中配置： 
     <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-compiler-plugin</artifactId>
               <version>3.6.1</version>
               <configuration>
               <source>1.8</source>
               <target>1.8</target>
               </configuration>
               </plugin>
     <!--配置tomcat插件 -->
     <plugin>
               <groupId>org.apache.tomcat.maven</groupId>
               <artifactId>tomcat7-maven-plugin</artifactId>
               <version>2.2</version>
               <configuration>
               <path>/film</path>
               <port>8080</port>
               </configuration>
     </plugin>
     
   Idea中使用maven中tomcat插件来启动服务器配置tomcat点击：Edit Configurations ——》“点击+”  ——》Maven
   ——》"填写Name”<内容为tomcat7：run>——》“填写command line”<内容为：clean tomcat7：run>
   
   项目的启动：点击Maven中的Run Configurations下面的tomcat7：run             
3，简要的使用说明
       项目启动成功之后：浏览器中输入：http://localhost:8080/film，显示首页index.jsp中的功能，点击登录输入姓名：MARY
   点击登录按钮，如果不输入或者输入错误会提示你输入的姓名错误,请从新输入；登录成功之后返回首页点击电影信息列表的展示
   显示列表信息可以点击删除和编辑，删除后页面刷新点击编辑跳转到编辑界面，编辑成功后会提示失败也会提示。在首页点击添加
   新的电影跳转到添加页面，添加成功会显示添加成功失败会显示添加失败。
             
4，代码目录结构说明，更详细点可以说明软件的基本原理
   com.yjg.bean--包含对对应数据库中的表的封装
   com.yjg.dao--包含对数据库操作的接口
   com.yjg.dao.impl--包含对dao接口的具体实现
   com.yjg.servlet--包含对前端jsp页面请求的处理使用了@WebServlet
   com.yjg.utils--包含了对一些公共方法的封装
   com.yjg.vo--包含了对前端一些字段的封装
   webapp目录下面包含了所有的页面和web.xml
   pom.xml--包含了一些插件和一些使用的jar包
 