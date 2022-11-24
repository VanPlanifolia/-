## Java高级

今天开始我们就开始Java高级篇的内容了，所谓java的高级篇也就是来学习我们在java基础中遗漏的那些晦涩难懂但是却十分重要的内容，比如jdk中的线程进程，jvm虚拟机，内存区域等等。还有在各个jdk的重大版本升级中加入的那些新特性等等，大概也是要需要一周左右的学习时间。

### 一.泛型



- 今天我们就先来学习一下java中的泛型，其实我们在平时使用泛型的频率还是很高的，就比如我们创建一个List的时候就会用到泛型去约束这个List中的内容，泛型就是用来约束(规范)一个 类/方法/接口 中的属性。方法返回值，方法参数的类型而出现的。所以泛型可以加在类上，加在接口上，加在方法上。

#### 1.泛型类

- 泛型可以加在类上使用<T>来定义一个类的泛型这种泛型可以去约束类的属性类型，可以约束类中方法的参数类型，可以约束类中方法的返回值。我们下面就用坐标类来演示一下泛型在类上面的使用，要求这个点坐标类可以容纳String，Integer，Double等等合理的坐标点数据类型，并且两个参数的数据类型要一致。

- 显然我们的需求是不确定的，我们不确定这个Point类需要的参数到底是什么所以我们可以使用Object来作为Point类中属性的类型，但是这样又不符合第二个要求，它又要求Point类的两个属性类型是一致的所以我们就只能使用泛型来实现。我们在定义这个类的时候去给他加上一个泛型 T 例如 class Point<T>这样我们就能在创建这个Point对象的时候为它指定具体的类型并且去约束Point类中的属性类型。

  > Point类
  >
  > ~~~java
  > public class Point<T> {
  >     private T xPoint;
  >     private T yPoint;
  > 
  >     public Point(T xPoint, T yPoint) {
  >         this.xPoint = xPoint;
  >         this.yPoint = yPoint;
  >     }
  > 
  >     public Point() {
  >     }
  > 
  >     public T getxPoint() {
  >         return xPoint;
  >     }
  > 
  >     public void setxPoint(T xPoint) {
  >         this.xPoint = xPoint;
  >     }
  > 
  >     public T getyPoint() {
  >         return yPoint;
  >     }
  > 
  >     public void setyPoint(T yPoint) {
  >         this.yPoint = yPoint;
  >     }
  > 
  >     @Override
  >     public String toString() {
  >         return "Point{" +
  >                 "xPoint=" + xPoint +
  >                 ", yPoint=" + yPoint +
  >                 '}';
  >     }
  > }
  > 
  > ~~~
  >
  > 编写一个测试类来进行测试
  >
  > ~~~java
  > public class PointTest {
  >     @Test
  >     public void test01(){
  >         Point<String> point1 = new Point<>();
  >         point1.setxPoint("东经223");
  >         point1.setyPoint("北纬112");
  >         System.out.println(point1);
  >     }
  >     @Test
  >     public void test02(){
  >         Point<Double> point2 = new Point<>();
  >         point2.setxPoint(123.6);
  >         point2.setyPoint(233.3);
  >         System.out.println(point2);
  >     }
  > }
  > ~~~
  >
  > 运行结果,显然我们发现我们确实在创建point1/point2的时候使用了两个不同的数据类型，并且运行结果也确实没有问题。
  >
  > ![1666686342781](java%E9%AB%98%E7%BA%A7.assets/1666686342781.png)

#### 2.泛型通配符

- 我们在Java中常常会通过方法的参数来传对象的引用，就好比我们要去写一个方法，这个方法会去调用传入对象中的show方法，但是传入的对象它的泛型是不确定的，但是我们这个工具方法是预先写死的我们当然不可能去在每传入一次对象引用都去修改一次工具方法来指定传入参数的泛型，我们就可以使用泛型的通配符从而去接受任意类型的泛型参数。

- 下面我们就简单的写一个Demo来演示泛型通配符。

  > 首先我们创建一个类这个类用来存放用户发送消息，这个消息类有两个属性一个是消息的码一个是消息正文，并且有一个方法来打印消息
  >
  > ~~~java
  > public class Message<T,E> {
  >     /**
  >      * messageContext 消息正文
  >      * messageCode 消息码
  >      */
  >     private final T messageContext;
  >     private final E messageCode;
  > 
  >     public Message(T messageContext, E messageCode) {
  >         this.messageContext = messageContext;
  >         this.messageCode = messageCode;
  >     }
  > 
  >     /**
  >      * 消息打印方法
  >      */
  >     public void print(){
  >         System.out.println("消息编号为" + messageCode + ",消息正文为" + messageContext);
  >     }
  > 
  >     @Override
  >     public String toString() {
  >         return "Message{" +
  >                 "messageContext=" + messageContext +
  >                 ", messageCode=" + messageCode +
  >                 '}';
  >     }
  > }
  > 
  > ~~~
  >
  > 然后我们创建测试类，测试类中有一个用来调用消息类中print方法的工具方法show，所以我们需要在show方法中使用泛型通配符。
  >
  > 可以发现使用泛型通配符的引入让我们可以传入不同泛型约束的Message类并且没有报编译错误
  >
  > ~~~java
  > public class MessageTest {
  >     /**
  >      * 测试Message泛型为String和Integer
  >      */
  >     @Test
  >     public void test01(){
  >         Message<String,Integer> message1 = new Message<>("你好世界", 1);
  >         this.show(message1);
  >     }
  > 
  >     /**
  >      * 测试Message泛型为List和Integer
  >      */
  >     @Test
  >     public void test02(){
  >         List<String> messageContext = new ArrayList<>();
  >         messageContext.add("123");
  >         messageContext.add("你好code");
  >         Message<List<String>,Integer> message2 = new Message<>(messageContext,2);
  >         this.show(message2);
  >     }
  >     /**
  >      * 调取Message类中的print方法的工具方法
  >      * @param message Message类对象的引用
  >      */
  >     private void show(Message<?,?> message){
  >         message.print();
  >     }
  > }
  > ~~~
  >
  > 运行结果
  >
  > ![1666687801745](java%E9%AB%98%E7%BA%A7.assets/1666687801745.png)

#### 3.泛型上下限约束

- 有时候我们虽然需要使用泛型通配符，但是却又并不希望所有的泛型都能够传入，泛型的上下限就出现了，我们可以使用 ？extends 类 来约束泛型必须继承于谁，或者使用 ？super 类 来约束泛型必须是谁的父类，这点我们可以根本用不到但是在jdk的源码中却常常出现。下面我们就来用代码演示一下。

- 下面我们还以上一个Message作为基础类来写一个测试类，不过这个测试用上了泛型通配符的上下限

  > 我们分别约束Message中的第一个泛型为String或者String的父类，第二个泛型为Number或者Number的子类。
  >
  > ~~~java
  > public class MessageTestSp {
  > 
  >     @Test
  >     public void test01(){
  >         Message<String,Integer> message = new Message<>("你好Planifolia",123);
  >         this.show(message);
  >     }
  > 
  >     @Test
  >     public void test02(){
  >         Message<Object,Double> message = new Message<>(new Object(),1.23);
  >         this.show(message);
  >     }
  > 
  >     /**
  >      * 工具方法，要求传入的message的第一个泛型必须为String或者是String的父类，第二个泛型必须为Number子类或者为Number
  >      * 如果传入其他泛型的Message对象就会报编译时异常
  >      * @param message 传入的Message对象
  >      */
  >     private void show(Message<? super String,? extends Number> message){
  >         message.print();
  >     }
  > ~~~
  >
  > 运行结果如下，显然我们上面两个测试都是满足需求的都正确的打印出来结果并且没有报错
  >
  > ![1666688833642](java%E9%AB%98%E7%BA%A7.assets/1666688833642.png)

#### 4.泛型接口

- 泛型接口的使用方式基本上是和泛型类在接口名后面添加上一个<T>来约束接口中的方法，属性等等，但是在类实现接口的时候要么也是去定义一个泛型，要么就是去直接声明接口的泛型类型。

- 下面我们还是使用一个例子来展示泛型接口,因为这个涉及到多个类之间的继承关系我就把他们写到一个类中了。

  > ~~~java
  > /**
  >  * 泛型接口食物
  >  * @param <T>
  >  */
  > public interface Food<T> {
  >     /**
  >      * 获取食物的名字
  >      * @param name
  >      */
  >     void  getName(T name);
  > }
  > 
  > /**
  >  * 苹果类实现食物接口并且直接声明泛型的类型
  >  */
  > class Apple implements Food<String>{
  >     @Override
  >     public void getName(String name) {
  >         System.out.println("我的名字是:" + name);
  >     }
  > }
  > 
  > /**
  >  * 桃子类实现了事务接口，并没有声明泛型的类型而是继续定义了一个泛型。
  >  * @param <T>
  >  */
  > class Peach<T> implements Food<T>{
  > 
  >     @Override
  >     public void getName(T name) {
  >         System.out.println("我的名字是:" + name);
  >     }
  > }
  > class Test{
  >     public static void main(String[] args) {
  >         // 因为Peach类在实现的时候没有声明接口的类型所以要在创建对象的时候给他进行泛型约束
  >         Peach<Integer> peach = new Peach<>();
  >         peach.getName(123);
  >         // 因为在实现的时候就已经声明了接口的泛型所以就不用在声明泛型了
  >         Apple apple = new Apple();
  >         apple.getName("苹果");
  >     }
  > }
  > ~~~
  >
  > 运行结果
  >
  > ![1666689956155](java%E9%AB%98%E7%BA%A7.assets/1666689956155.png)

#### 5.泛型方法

- 泛型方法，一般是用来静态方法中的在工具方法中比较常见，我们可以根据泛型来约束这个方法中的参数返回值等等。

- 那么就拿我之前写过的一个Mybatis工具类来说吧，这个工具类能够根据传递过来的Dao接口的Class对象然后生成Dao接口的实现类，然后我们就可以根据这个方法返回的实现类来调取Dao接口中定义的一些方法了，而且对于静态泛型方法他可以根据我们传递进来的参数类型自动的推断出泛型的类型从而返回出对应的我们传入的Dao接口对应的代理实现类供我们使用。

  > 工具类代码
  >
  > ~~~java
  > 
  > /**
  >  * Created by Intellij IDEA<br>
  >  * 工具类获取dao接口对应的实现类
  >  * @author Planifolia.Van
  >  * @version 1.0
  >  * @date 2022/9/23 16:13
  >  */
  > public class MyBatisUtil<T> {
  >     public SqlSession sqlSession=null;
  >     static SqlSessionFactory sessionFactory =null;
  > 
  >     /*
  >       获取sqlSession,加载mybatis.xml核心文件,因为这一块只要执行一次所以我直接把他写在静态代码块中
  >      */
  >     static {
  >         try {
  >             Reader reader = Resources.getResourceAsReader("mybatis.xml");
  >             sessionFactory=new SqlSessionFactoryBuilder().build(reader);
  > 
  >         } catch (IOException e) {
  >             e.printStackTrace();
  >         }
  >     }
  > 
  >     /**
  >      * 此方法用于打开一个SqlSession,每一个涉及到 增 删 改的 SqlSession都对应一个事务,像这种事务都需要去调用下面的事务提交
  >      * @param aClass dao接口的class对象
  >      * @return 返回的接口实现类对象
  >      */
  >     public T getDao(Class<T> aClass){
  >         sqlSession=sessionFactory.openSession();
  >         return sqlSession.getMapper(aClass);
  >     }
  > 
  >     /**
  >      * sqlSession的提交与关闭
  >      */
  >     public  void sqlSessionCommit(){
  >         sqlSession.commit();
  >         sqlSession.close();
  >     }
  > }
  > ~~~
  >
  > 我们编写一个测试类，看使用这个方法是否能够真正的拿到接口对应的测试类，我们通过控制台发现确实可以拿到对应接口的代理实现类
  >
  > ~~~java
  > 
  > public class Test {
  >     public static void main(String[] args) {
  >         MyBatisUtil<DeptDao> deptDaoUtil = new MyBatisUtil<>();
  >         DeptDao dao = deptDaoUtil.getDao(DeptDao.class);
  >         System.out.println(dao);
  >     }
  > }
  > ~~~
  >
  > ![1666691932769](java%E9%AB%98%E7%BA%A7.assets/1666691932769.png)

### 二.注解

- 今天我们就来了解一下Java中的注解，其实但看注解的话并没有什么特殊的含义他和注释一样都是起到注明的功能不过注释是给程序员，以及其他人看的。而注解是给jvm看的，jvm能解析注释中的信息。

#### 1.注解的类型

- 注解大致可分为两种预定义注解，自定义注解。其中顾名思义预定义注解也就是Java预先帮我们定义好的注解。我们常见的有如下几种

  > @Override 重写注解，加载方法上面用来检测这个方法是否是被重写的如果不是则会编译时报错
  >
  > @Deprecated 方法过时注解，用来标注这个方法已经过时了不推荐使用了，我们在TIme类以及Calendar类中会经常发现被此注解标注的方法。
  >
  > @SuppressWarnings 压制警告注解，加上这个注解之后编辑器则不会在给我们爆出警告的提示。
  >
  > @FunctionInterface 函数式接口注解，在接口上添加这个注解则会标注这个接口是函数式接口，只允许有一个方法。这种接口我们在后面会经常遇见。 

- 我们在下面就使用代码来简单的展示一下这些注解的使用

  ~~~java
  // 压制警告注解，这个注解会让代码中应该提示的警告信息不在提示
  @SuppressWarnings("all")
  public class AnnotationDemo {
      private String name;
  
      // 首先是 @Override注解他标注着一个方法是否被重写
      @Override
      public String toString() {
          return "AnnotationDemo{" +
                  "name='" + name + '\'' +
                  '}';
      }
      // 这个注解是注明这个方法已经过时了不推荐使用了
      @Deprecated
      public boolean equal(String name){
          // 就如同这行代码，本来我们对字符串使用==进行比较是必然会爆出警告的但是，因为我们使用了SuppressWarnings他就不会爆出异常
          return this.name == name;
      }
  }
  // 函数式接口注解，标注这个接口是函数式接口只允许有一个抽象方法
  @FunctionalInterface
  interface Fun{
      int run();
  }
  class Run{
      public static void main(String[] args) {
          AnnotationDemo annotationDemo = new AnnotationDemo();
          // 看我们在这调用这个方法的时候就会被画上横线表示这个方法已经过时了
          annotationDemo.equal("123");
          
          // 使用拉姆得表达式可以很优雅的实现函数式接口是实现
          Fun fun = ()->{
            int a = 10;
            return a*a;
          };
          System.out.println(fun.run());
      }
  }
  ~~~

- 然后就是自定义注解了，自定义注解也就是我们自己创建的注解，我们在Java中可以使用@interface关键字来创建一个注解，这个注解在我们使用反射之前可以说是没有任何意义，只是做语法演示。

  ~~~ java
  //创建注解的语法格式
  @interface 注解名字{
      
  }
  ~~~

  代码如下

  ~~~java
  @My
  public class MyAnnotation {
      //默认的自定义注解可以加载字段上
      @My
      private String name;
      // 默认的自定义注解可以加载方法上面
      @My
      // 默认的自定义注解可以加载方法的参数上
      public boolean equals(@My MyAnnotation myAnnotation){
          return this.name!=null && this.name.equals(myAnnotation.name);
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  }
  //就可以使用这种方式去创建一个注解，默认创建的注解是可以加载任何地方的，虽然目前没有任何意义
  @interface My{
  
  }
  class Run{
      public static void main(String[] args) {
          MyAnnotation myAnnotation = new MyAnnotation();
          myAnnotation.setName("12s3");
          MyAnnotation myAnnotation1 = new MyAnnotation();
          myAnnotation1.setName("123");
          System.out.println(myAnnotation.equals(myAnnotation1));
      }
  }
  ~~~

- 其实我们自定义注解是没什么意义的，但是我们在后面学习了反射之后就能通过类的反射对象去获取标注在类以及类的成员们身上的注解信息，此时自定义注解才有了意义，所以在几乎所有的框架上都用到了自定义注解，因为他实在是太好用了，只要我们添加一个注解信息框架就知道我们想要配置什么。

  > 一些非常常用的框架自定义注解
  >
  > @Autowired 自动注入，可以自动注入我们配置在spring中的bean
  >
  > @RequestMapping 写在Controller类中的控制器方法上或者类上，标注这个类/方法的请求路径
  >
  > @ResponseBody 加在Controller类的控制器方法上将java中的对象转化为Json对象
  >
  > @RequestBody 和上面的类似只不过是把前端传递过来的json对象转化为Java对象
  >
  > @RestController ResponseBody 和Controller注解的结合体。

  

#### 2.元注解

- 元注解被称为注解的注解，他是java预先定义好的一些可以加载注解上面的注解，他通常标注了我们自定义的注解的一些配置信息等等。元注解一共只有四个并且常用的只有两个。

  > @Target 用来标注这个注解可以标注在那,他必须要填写()内容中的属性,并且填写的属性是一个枚举类, 'ElementType' 具体内容如下
  >
  > ~~~java
  > 	/** 可以用在类、接口（包括注释类型）或枚举声明 */
  >   	TYPE,
  >     /** 可以用在类的字段上面 */
  >     FIELD,
  > 
  >     /** 可以用在方法上面*/
  >     METHOD,
  > 
  >     /** 可以用在方法的参数上面 */
  >     PARAMETER,
  > 
  >     /** 可以用在构造方法上面 */
  >     CONSTRUCTOR,
  > 
  >     /** 可以用在方法的局部变量上面 */
  >     LOCAL_VARIABLE,
  > 
  >     /** 可以标注在一个注解上面 */
  >     ANNOTATION_TYPE,
  > 
  >     /** 可以标注在包上面 */
  >     PACKAGE,
  > 
  >     /**
  >      * 可以标注在泛型声明上面
  >      *
  >      * @since 1.8
  >      */
  >     TYPE_PARAMETER,
  > 
  >     /**
  >      * 可以标注任意一个类型上面
  >      *
  >      * @since 1.8
  >      */
  >     TYPE_USE
  > ~~~
  >
  > @Documented 用来表示生成文档时候带上注解
  >
  > @Retention 标注这个注解在什么时候生效。有三个属性
  >
  > ~~~
  > RetentionPolicy.SOURCE 在源码阶段生效
  > RetentionPolicy.CLASS 在Class文件阶段生效
  > RetentionPolicy.RUNTIME 在运行阶段生效
  > ~~~
  >
  > @Inherited 标注这个注解是否可以继承

- 演示代码如下

  ~~~java
  @My
  //甚至可以加在类泛型上
  public class MyAnnotationDemo02<@My T> {
      //可以加在字段上
      @My
      private String name;
      //可以加在方法上面
      @My
      //可以加在参数上
      public void show(@My String arg){
          //可以加在局部变量上
          @My
          int a;
          System.out.println("show");
      }
  
  
  }
  // 用来标注一个注解可以用在那些上面
  @Target({ElementType.TYPE,ElementType.TYPE_PARAMETER,ElementType.FIELD,ElementType.METHOD
          ,ElementType.PARAMETER,ElementType.LOCAL_VARIABLE,ElementType.ANNOTATION_TYPE
          })
  // 用来标注生成文档是否显示
  @Documented
  //标注注解在哪个阶段生效，分别为源码阶段，class阶段，运行阶段，
  @Retention(RetentionPolicy.CLASS)
  //@Retention(RetentionPolicy.SOURCE)
  //@Retention(RetentionPolicy.RUNTIME)
  //标注这个注解是否可以继承
  @Inherited
  @interface My{
  
  }
  //甚至可以加在注解上
  @My
  @interface MySP{
  
  }
  ~~~

#### 3.注解的属性

- 我们在上面元注解以及框架的自定义注解中可以看到注解的()中可以填写一些信息这些信息也就是注解的属性,注解的属性其实是和类的属性/字段类似的都是 数据类型+名字 不过注解中的属性还要带上(),而且注解中的属性可以设置默认值 使用 'default' 关键字即可设置默认值.

  注解属性的语法格式如下

  ~~~java
  @interface My{
      String name() default "张三";
  }
  ~~~

- 那么我们下面就写一段代码来展示如何编写注解的属性.

  ~~~java
  //所有没被设置默认值的注解都要在使用的时候写在()里面并且要标注上这个注解属性的名字 例如 名字=值，
  // 并且有一个特性如果是数组只有一个值的话可以省略{}，若数组有多个则必须写{}
  @My(nubs = 1)
  public class MyAnnotationDemo03 {
      @My(nubs={1,2})
      private String name;
      // 第二个特性，如果在注解中只有一个value必须要填写，那么可以省略 ‘value=’，若有多个属性要写则不能省略
      @My(value = MyEnum.LS,nubs = 1)
      public void show(){
          System.out.println("show");
      }
  
  }
  @interface My{
      //注解的属性可以为 字符串，基本数据类型，数组，注解类型，枚举
  
      //注解属性为String
      String name() default "张三";
      //注解属性为枚举
      MyEnum value() default MyEnum.ZS;
      //注解属性为基本数据类型
      int nub() default 12;
      //注解数据类型为数组
      int[] nubs();
      //注解数据类型为注解
      Temp temp() default @Temp;
  
  }
  @interface Temp{
  
  }
  enum MyEnum{
      ZS("张三","123456"),
      LS("李四","123456")
      ;
      String key;
      String value;
  
      MyEnum(String key, String value) {
      }
  }
  ~~~

- 注解属性中的一些特性

  > 1. 注解的属性可以为 字符串，基本数据类型，数组，注解类型，枚举
  >
  > 2. 所有没被设置默认值的注解都要在使用的时候写在()里面并且要标注上这个注解属性的名字 
  >
  >    例如 名字=值，
  >
  > 3. 并且如果要填写的数组属性只有一个值的话可以省略{}，若数组有多个则必须写{}
  >
  > 4. 如果在注解中只有一个value必须要填写，那么可以省略 ‘value=’，若有多个属性则必须要写则不能省略

### 三.反射

#### 1.什么是反射

- 反射是Java中的一个比较特殊的特性，首先反射的出现破坏了Java的封装性，对于原本的Java来说被private修饰的变量是不能在外部直接访问以及赋值的，但是通过反射我们就能很容易的获得到他们，并且还能够给他们进行赋值的一系列操作，包括private修饰的方法也是，通过反射对象能够获取到所有方法以及执行。

- 那么反射如此强大，它是怎么做到的呢？我们都知道Java的代码在运行得出结果之前会有如下三个阶段      

  1.源码阶段(我们在编辑器写出的Java文件就是所谓的源码，源码是方便我们程序员看并且理解的，但是jvm并不能理解我们写的源码需要将他编译成 ‘字节码’ 才能被jvm虚拟机理解)

  2.字节码阶段(我们在编译结束后会发现多出了一系列的.class文件，并且打开是完全看不懂的乱码，这就是java的字节码，字节码是jvm方便理解的我们自然看不懂)

  3.运行阶段（随着编译的结束，Java代码开始运行。jvm会把编译好字节码文件加载到jvm虚拟机中，并且逐句的 ’解释‘ 得到执行的结果，并且在载入jvm虚拟机的同时会生成一个class对象，这个对象携带着被加载的类的所有信息我们在后面通过反射获取到的就是这个Class类）

  总结来说 反射就是在运行时，将正在运行着的类中所有信息抽取出来封装成一个新的类。

  ![1666857662953](java%E9%AB%98%E7%BA%A7.assets/1666857662953.png)

#### 2.如何获取反射

- 获取反射对象的方法共有三种，并且非常简单，我们在学习JDBC的时候其实已经接触过一种了 Class.forname("驱动的全限定名")

  1. 使用类名.class的方式获取Class对象

     > 我们可以直接使用类名.class的方式来获取Class对象，没什么好嗦的直接上代码
     >
     > ~~~java
     > Class<Apple> appleClass = Apple.class;
     > ~~~

  2. 使用对象.getClass()来获取反射对象

     > 我们可以使用Object类中定义的.getClass方法来获取反射对象
     >
     > ~~~java
     > Apple apple = new Apple();
     > Class<? extends Apple> aClass1 = apple.getClass();
     > ~~~

  3. 使用Class.forName("类的全限定名")来获取反射对象

     > 我们可以使用Class类中的静态方法.forName来获取反射对象
     >
     > ~~~java
     > Class<?> aClass = Class.forName("van.planifolia.demo01.Apple");
     > ~~~

  4. 当然我们无论同什么方式获取同一个类的Class对象返回过来的都是同一个实例，因为类会被加载一次，同样也只会生成一次Class对象。

     ~~~java
     public class GetReflex {
         public static void main(String[] args) throws ClassNotFoundException {
             // 直接使用类名.class的方法获取
             Class<Apple> appleClass = Apple.class;
             // 使用Class类中的静态方法.forName("要获取类的全限定名")
             Class<?> aClass = Class.forName("van.planifolia.demo01.Apple");
             // 使用Object类提供的方法 对象.getClass()来获取反射对象
             Apple apple = new Apple();
             Class<? extends Apple> aClass1 = apple.getClass();
             // 运行结果均为true，说明无论通过什么方式获取到的Class对象都是同一个，也说明了类只会被加载一次生成一个Class对象
             System.out.println(appleClass == aClass);
             System.out.println(aClass == aClass1);
         }
     }
     class Apple{
     
     }
     ~~~

     

     

#### 3.根据反射对象我们能干什么

- 我们之前已经说了反射是很强大的，可以根据反射对象获取到类中的所有方法，所有属性，那么我们下面就来具体聊聊反射到底能干那些事情。

  1. 首先就是通过反射对象获取被反射类的实例对象。

     > 我们拿到反射对象之后可以通过调用.newInstance()来创建一个被反射类的实例对象，并且每次生成的实例对象都是新的。
     >
     > ~~~ java
     > public class ReflexCreateObject {
     >     public static void main(String[] args) throws InstantiationException, IllegalAccessException {
     > 
     >         Class<Peach> peachClass = Peach.class;
     >         // 通过调用反射对象中的newInstance来创建被反射类的实例化对象。
     >         Peach peach1 = peachClass.newInstance();
     >         // 并且创造粗来的对象与 new的对象没有任何区别
     >         peach1.show();
     >         Peach peach2 = peachClass.newInstance();
     >         // 结果为false，说明每次创建出来的实例对象都是一个 ’新‘ 的。
     >         System.out.println(peach1 == peach2);
     >     }
     > }
     > class Peach{
     >     public void show(){
     >         System.out.println("我是桃子");
     >     }
     > }
     > ~~~

  2. 通过反射可以获取到被反射类中的所有字段。

     > 反射类中有四个获取被反射类字段的方法，分别为：
     >
     > 1.getFields() 可以获取所有的public字段信息，包括父类中的。
     >
     > 2.getFiled("字段名字") 可以获取指定的public字段信息当然也是包括父类中的。但是不能获取private修饰的字段信息否则会报 NoSuchFieldException 异常
     >
     > 3.getDeclaredFields()可以获取当前类的所有的字段信息包括私有的字段。
     >
     > 4.getgetDeclaredField("字段名字") 可以获取当前类的指定字段信息，当然可以获取私有的字段，如果字段名字 填写了当前类没有的字段名字同样也是会爆出 NoSuchFieldException  异常。
     >
     > ~~~java
     > public class ReflexGetFields {
     >     public static void main(String[] args) throws NoSuchFieldException {
     >         Class<People> peopleClass = People.class;
     >         Class<Doctor> doctorClass = Doctor.class;
     >         // getFields可以获取到所有的public字段，包括父类中的public字段
     >         Field[] fields = doctorClass.getFields();
     >         Arrays.stream(fields).forEach(System.out::println);
     >         System.out.println("======================================");
     > 
     >         // getField可以获取指定名字的public字段当然包括父类中的
     >         Field phoneNub = doctorClass.getField("phoneNub");
     >         System.out.println(phoneNub);
     >         System.out.println("======================================");
     > 
     >         // getDeclaredFields可以获取到当前类的所有字段包括private修饰的,但是不能获取父类的
     >         Field[] declaredFields = peopleClass.getDeclaredFields();
     >         Arrays.stream(declaredFields).forEach(System.out::println);
     >         System.out.println("======================================");
     > 
     >         // getDeclaredField可以获取指定的字段信息可以是本类的私有字段但是不能为父类
     >         Field name = peopleClass.getDeclaredField("name");
     >         System.out.println(name);
     > 
     >     }
     > }
     > 
     > class People{
     >     private String name;
     >     public String age;
     > }
     > class Doctor extends People{
     >     private String address;
     >     public String phoneNub;
     > }
     > ~~~

  3.  通过反射获取到的Filed对象可以执行set与get方法来操作他们的值。

     > 我们在上一步中获取出来的Filed对象，可以通过调用他们的.get() .set()方法来获取或者设置指定对象的属性值。
     >
     > 1. Filed.get(Object object)，用来获取指定字段的指定对象中的属性值。
     >
     > 2. Filed.set(Object object,Object valuie),用来设置指定字段的指定对象的属性值
     >
     >    如果我们获取的是public字段的话那还好，但是如果我们操作的是private字段这样直接用这俩方法就不行了，我们需要开启操作私有属性的权限方法为 FIled.setAccessible(true)来开启权限才能继续进行操作否则则会报出 IllegalAccessException 异常
     >
     > ~~~java
     > public class ReflexOperationFields {
     >     public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
     >         // 分别创建实例对象与反射对象
     >         Pig pig = new Pig("120KG","彼阁");
     >         Class<? extends Pig> aClass = pig.getClass();
     >         // 获取Pig类的字段weight
     >         Field weight = aClass.getDeclaredField("weight");
     >         // 获取Pig类的字段name
     >         Field name = aClass.getDeclaredField("name");
     >         // 开启允许操作私有属性的权限
     >         weight.setAccessible(true);
     >         name.setAccessible(true);
     > 
     >         // 获取pig对象的属性weight
     >         System.out.println(weight.get(pig));
     >         // 设置pig对象的属性name
     >         name.set(pig,"pig");
     > 
     >         //最后打印查看结果
     >         System.out.println(pig);
     >     }
     > }
     > class Pig{
     >     private String weight;
     >     private String name;
     > 
     >     public Pig(String weight, String name) {
     >         this.weight = weight;
     >         this.name = name;
     >     }
     > 
     >     public String getWeight() {
     >         return weight;
     >     }
     > 
     >     public void setWeight(String weight) {
     >         this.weight = weight;
     >     }
     > 
     >     public String getName() {
     >         return name;
     >     }
     > 
     >     public void setName(String name) {
     >         this.name = name;
     >     }
     > 
     >     @Override
     >     public String toString() {
     >         return "Pig{" +
     >                 "weight='" + weight + '\'' +
     >                 ", name='" + name + '\'' +
     >                 '}';
     >     }
     > }
     > ~~~

  4. 最后一个就是反射获取方法以及操作方法了，我在这就把他们写成一个类里面了。

     > 首先是反射获取类中的方法，和获取字段一样也是提供了四种获取的方法，甚至这四种方法的特性也是一毛一样。
     >
     > 1.getMethods（）用于当前类以及父类中的全部public方法
     >
     > 2.getMethod（String name,Class<?> ... args） 用于获取当前类以及父类中的指定public方法，指定条件为方法名与方法的参数列表的数据类型反射对象
     >
     > 3.getDeclaredMethod（String name,Class<?> ... args）用于获取当前类中的指定方法可以为私有，指定条件为方法名与方法的参数列表的数据类型反射对象
     >
     > 4.getDeclaredMethods（）用于当前类中的全部方法可以为私有
     >
     > 上面这些就是获取方法的四种方法了，那么还有一个就是执行我们刚才获取到的方法的一个方法.invoke()
     >
     > 5.invoke(Object object,Object ... args) 方法的回调方法，这个方法可以执行我们在上一步获取到的方法，不过我们要给他指定回调的是哪个对象的方法，如果回调方法有参数的话要给它具体的参数，如果有返回值的话我们可以使用一个Object对象来接受invoke方法的返回值，并且可以根据方法的实际返回信息来进行强转。当然我们在执行私有方法的时候同样也是要使用getShow.setAccessible(true);方法来开启操作权限的。
     >
     > 具体的代码如下
     >
     > ~~~ java
     > public class ReflexOperationMethods {
     > 
     >     public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
     > //        getMethods();
     >         operationMethods();
     >     }
     > 
     >     public static void getMethods() throws NoSuchMethodException{
     >         // 分别获取他们的实例对象与反射对象
     >         Animal animal = new Animal();
     >         Neko neko = new Neko();
     >         Class<? extends Animal> animalClass = animal.getClass();
     >         Class<? extends Neko> nekoClass = neko.getClass();
     > 
     >         // 使用getMethod可以获取指定的自己类或者父类中的public方法，指定条件为方法的参数列表+方法名字
     >         System.out.println("Animal类中的show方法");
     >         System.out.println(animalClass.getMethod("show"));
     >         // 使用getMethods可以获取自己类以及父类中全部的public方法
     >         System.out.println("Neko类以及父类中的所有public方法");
     >         Arrays.stream(nekoClass.getMethods()).forEach(System.out::println);
     > 
     >         // 使用getDeclaredMethod可以获取指定自己类中的任意方法包括私有方法。指定条件为方法的参数列表+方法名字
     >         System.out.println("Animal类中的私有方法getShow");
     >         System.out.println(animalClass.getDeclaredMethod("getShow", String.class));
     >         // 使用getDeclaredMethods可以获取自己类中的所有方法包括私有方法
     >         System.out.println("Neko自己类中的所有方法，包括private方法");
     >         Arrays.stream(nekoClass.getDeclaredMethods()).forEach(System.out::println);
     >     }
     > 
     >     public static void operationMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
     >         // 分别获取他们的实例对象与反射对象
     >         Animal animal = new Animal();
     >         Neko neko = new Neko();
     >         Class<? extends Animal> animalClass = animal.getClass();
     >         Class<? extends Neko> nekoClass = neko.getClass();
     > 
     >         // 获取一个Animal中的show（无返回值无参数方法）方法并且执行
     >         Method show = animalClass.getMethod("show");
     >         show.invoke(animal);
     >         // 获取一个Animal中的私有方法getShow（有参数有返回值的方法） 方法并且执行
     >         Method getShow = animalClass.getDeclaredMethod("getShow", String.class);
     >         // 开启私有的访问权限
     >         getShow.setAccessible(true);
     >         Object result = getShow.invoke(animal, "长颈鹿");
     >         System.out.println(result);
     > 
     > 
     >     }
     > }
     > class Animal{
     >     public void show(){
     >         System.out.println("动物类");
     >     }
     >     private String getShow(String name){
     >         System.out.println("动物类"+name);
     >         return "动物类";
     >     }
     > }
     > class Neko{
     >     public void run(){
     >         System.out.println("小猫跑");
     >     }
     >     private String getName(String name){
     >         System.out.println("我是小猫" + name);
     >         return "我是小猫"+name;
     >     }
     > }
     > 
     > ~~~


### 四.进程与线程

#### 1.什么是进程/线程

- 进程通俗点讲就是一个程序运行的实体，它是操作系统进行资源调配的最小单位，在早期的单核机中其实只能真正意义上的并行运行一款程序(因为cpu在同一时刻只能被一个进程所独占)但是因为cpu切换运行的速度非常之快让你感觉同时在处理多个程序(并发)，到后来多核处理器出现了才真正意义上实现了并行。

- 后来线程出现了，刚开始的线程也叫轻量级进程，进程是分配资源的最小单位，线程就是任务执行的最小单位。在一个进程中可以拥有多个线程，这些线程共享进程中的资源(cpu，内存空间)。

  就拿Java中的进程与线程来说吧。一个进程代表一个程序那么我们启动的jvm虚拟机就会占用一个进程(它会占用内存空间，占有cpu的资源)，这个进程中有若干个线程，线程也就是我们编写的程序。这些线程们共享进程中的资源( 堆[`*存放对象实例 伊甸区 老年区 元空间*`]，方法区/元空间[`存放类中的类信息，方法信息，常量，静态变量`] )但是他们也有自己独占的东西(虚拟机栈[`虚拟机栈是用来进行方法调用的，一个方法代表一个栈帧栈帧中携带着这个方法的各种信息，执行完毕后会弹出栈帧结束方法的调用`]，本地方法栈[与虚拟机栈类似不过这个是专门用来执行本地 'native' 方法的]，程序计数器[`用来标记当前执行到那里了`])。

  按照我们传统的编程方式，程序都是自上而下执行，就算我们将两个功能写到了一个业务里代码仍然是严格按照从上往下依次执行的这样对我们需要并发执行的任务非常的不友好，Java就为我们提供了多线程技术，多线程允许我们打破传统的代码执行方式运行多个线程同时执行这样我们就能在一个程序中同时干许多件事情。

  Java中的多线程并不是真正意义上的同时执行(并行)而是让jvm去调配当前的线程让其分时间片去占用cpu资源来实现同时执行的效果也就是(并发)。所以多线程并不是提高了程序的运行效率而是提高了资源的利用率。

#### 2.如何在java中创建线程

- Java中创建线程有四种方式，分别是继承Thread类，实现Runnable接口，实现Callable接口，使用线程池创建线程，我们会逐一学习这些内容。

  1. 继承Thread类来创建线程，这个方法要求我们去继承Thread类并且重写其中的.run方法在里面实现我们要在子线程中完成的任务，当然我们也可以通过使用匿名内部类的方法来创建一个子线程，并且我们在临时需要使用一个子线程的时候通常都会采用匿名内部类的方法来创建。

     代码案例如下

     ~~~java
     public class CreateThread01 {
         public static void main(String[] args) {
             // 启动线程务必要用.start方法否则只是调用MyThread中的run方法并不算是启动一个新线程
             new MyThread("线程A").start();
             // 我们可以使用匿名内部类的方法来临时的创建一个线程完成业务
             new Thread("线程B"){
                 @Override
                 public void run() {
                     for (int i = 0; i < 10; i++) {
                         System.out.println("线程:" + Thread.currentThread().getName() + "->"+i);
                     }
                 }
             }.start();
         }
     }
     class MyThread extends Thread{
         /**
          * 我们可以在构造方法中去调用Thread中的构造方法来给线程设置名字
          * @param name 线程的名字
          */
         public MyThread(String name){
             super(name);
         }
         /**
          * 重写run方法在方法体中实现我们要写的业务
          */
         @Override
         public void run() {
             for (int i = 0; i < 10; i++) {
                 System.out.println("线程:" + Thread.currentThread().getName() + "->"+i);
             }
         }
     }
     ~~~

  2. 实现Runnable接口来创建线程，其实Thread类就是JDK官网帮我们实现Runnable接口创建的一个实现类，但是在Java中是单继承我们都知道，所以继承Thread类并不利于我们拓展所以我们通常使用这种方法实现Runnable接口来创建线程，Runnable接口是一个典型的函数式接口，也就意味着我们可以使用拉姆得表达式更加优雅的创建线程实例。

     使用Runnable创建线程的案例

     ~~~java
     public class CreateThread02 {
         public static void main(String[] args) {
             // 显然我们发现无论是Runnable还是MyThreadSp中都没有.start方法，所以我们想要启动线程还是要把它交给Thread类来启动线程
             // 我们先创建一个实现了Runnable接口的类，然后将这个类交给Thread类并且调用.start()方法来启动线程
             MyThreadSp myThreadSp = new MyThreadSp();
             new Thread(myThreadSp,"线程A").start();
             // 当然对于函数式接口我们更喜欢使用拉姆得表达式来创建它的实例
             new Thread( ()->{
                 for (int i = 0; i < 20; i++) {
                     System.out.println("线程:" + Thread.currentThread().getName() + "->"+i);
                 }
             } ,"线程B").start();
         }
     }
     class MyThreadSp implements Runnable{
         @Override
         public void run() {
             for (int i = 0; i < 20; i++) {
                 System.out.println("线程:" + Thread.currentThread().getName() + "->"+i);
             }
         }
     }
     ~~~

- 现在我们先根据这两个例子来简单的写一下两个经典的案例 ‘ 车站买票 ’  ‘ 存钱取钱 ‘

  1.  首先是车站买票例子，我们现在有三个窗口要卖100张票，请你使用线程来模拟这个流程。

     > 车站共有100张票，我们要通过三个窗口去卖它，显然三个窗口就代表三个线程并且这三个线程干的是同一个业务买票所以我们要写一个线程类，类里面有100张票，让后通过Thread启动三个线程来同时买票。
     >
     > ~~~java
     > public class SellTicket {
     >     public static void main(String[] args) {
     >         // 首先要有一个售卖实体，继承Runnable接口并且重写run方法
     >         Sell sell = new Sell();
     >         // 根据这个售卖实体来启动三个线程，同时卖票，同时操作 ticketNub
     >         new Thread(sell, "窗口A").start();
     >         new Thread(sell, "窗口B").start();
     >         new Thread(sell, "窗口C").start();
     > 
     >     }
     > }
     > 
     > class Sell implements Runnable {
     >     //总票数
     >     int ticketNub = 100;
     >     // 卖票的业务
     >     @Override
     >     public void run() {
     >         while (true) {
     >             if (ticketNub > 0) {
     >                 System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩下" + --ticketNub);
     >             }else {
     >                 break;
     >             }
     >         }
     >     }
     > }
     > ~~~
     >
     > 当然这种方法是安全的吗？并不是！我们不妨让线程卖票的时候延迟一点时间，就会发现它会出现，重复卖，当票数变成负数还在卖！这是因为cpu调度是看jvm心情的(随机)它不管你到底是是否真正的完成买票随时都会停止你的cpu使用权力交给其他线程，这样就会导致我们其中的一个线程虽然已经进入方法了但是还没有进行票数减一，此时jvm说：“ 哎，那谁你先歇会让你旁边的人去干活 ”。然后隔壁老王线程也进入了卖票方法，然后jvm又说：“ 哎，刚才的你继续干吧然后票数减一 ”。但是此时隔壁老王线程拿到的局部变量可没减一，所以当老王完成时就出现了重复卖的情况。当然对于超卖也是这种情况。不过发生的时机不同。所以我们在后面的线程安全章节就要解决这个问题。

  2. 存钱取钱问题，现在有两个人分别是小明与小红，这俩人小明会一直往银行卡里存钱，存20次，小红则会一直取钱也是取20次。

     > 显然这个问题我们就不能写一个线程业务了，分别要写一个存钱业务一个取钱业务，并且还要有一个银行卡类，来实现金额的加减。
     >
     > ~~~java
     > public class BankingBusiness {
     >     public static void main(String[] args) {
     >         // 创建银行账号实例
     >         Bank bank = new Bank();
     >         // 模拟小明存钱
     >         new Thread( ()->{
     >             for (int i = 0; i < 20; i++) {
     >                 bank.save(1000);
     >                 System.out.println(Thread.currentThread().getName() + "存了1000元，现在余钱为->" + bank.getDeposit());
     >             }
     >         } ,"小明").start();
     >         // 模拟小红取钱
     >         new Thread( ()->{
     >             for (int i = 0; i < 20; i++) {
     >                 bank.take(1000);
     >                 System.out.println(Thread.currentThread().getName() + "取了1000元，现在余钱为->" + bank.getDeposit());
     >             }
     >         } ,"小红").start();
     >     }
     > 
     > }
     > 
     > class Bank {
     >     // 余钱
     >     private double deposit = 0;
     > 
     >     // 存款方法
     >     public void save(double saveMoney) {
     >         deposit = deposit + saveMoney;
     >     }
     > 
     >     // 取款方法
     >     public void take(double takeMoney) {
     >         deposit = deposit - takeMoney;
     >     }
     > 
     >     public double getDeposit() {
     >         return this.deposit;
     >     }
     > }
     > ~~~
     >
     > 显然这个也不是安全的，我们在执行的时候很容易发现小明存了钱还是0元或者小红取了钱金额却没变。

#### 3.线程中的常用方法

- 在Thread类中为我们提供了一些列的常用线程方法，具体内容如下

  > 1.  sleep(时间长度) 让当前线程休眠一段时间，时间单位为毫秒(静态方法)
  >
  > 2. yield() 让当前线程放弃正在占用的cpu资源转变为就就绪状态重新和其他线程竞争资源
  >
  > 3. join() 允许线程插队，在join方法后的线程都会等调用join方法的线程执行完毕后再去执行
  >
  > 4. setPriority() 设置线程的优先级，优先级越高的线程更加容易得到cpu的资源，当然真正的调度还是要看jvm的心情这个方法只是提高概率。默认创建的线程优先级为五最低为1最高为10
  >
  > 5. setDaemon(boolean)设置线程为守护线程，守护线程会在所有线程执行完毕之后自己结束。经典的gc线程就是守护线程
  >
  >    Java代码中最少会有两个线程分别是main线程与gc线程。
  >
  > 演示代码如下，我们会发现线程B优先执行的概率确实高了并且C线程只会在AB两个线程执行完毕之后才会执行，并且守护线程即使是while死循环仍然会在所有线程执行完毕之后停止运行。
  >
  > ~~~ java
  > public class ThreadMethods {
  >     public static void main(String[] args) throws InterruptedException {
  >         // 我们创建三个线程t1 ，t2
  >         Thread t1 = new Thread(new MyThread(), "线程A");
  >         Thread t2 = new Thread(new MyThread(), "线程B");
  >         Thread t3 = new Thread(new MyThread(), "线程C");
  > 
  >         // 分别设置线程t1 t2的优先级为1，10，尝试让线程2优先执行，并且让t1，t2插队到t3线程前面
  >         t1.setPriority(1);
  >         t2.setPriority(10);
  >         t1.start();
  >         t2.start();
  >         // 创建一个守护线程守护到所有线程执行完毕
  >         Thread thread = new Thread(() -> {
  >             while (true){
  >                 try {
  >                     Thread.sleep(1);
  >                 } catch (InterruptedException e) {
  >                     e.printStackTrace();
  >                 }
  >                 System.out.println(Thread.currentThread().getName() + "说：守护");
  >             }
  >         }, "守护");
  >         thread.setDaemon(true);
  >         thread.start();
  >         // t1 t2 插队
  >         t1.join();
  >         t2.join();
  >         // t3执行
  >         t3.start();
  >     }
  > }
  > class MyThread implements Runnable {
  >     @Override
  >     public void run() {
  >         for (int i = 0; i < 20; i++) {
  >             // 我们让线程没休眠0.1s打印依次
  >             try {
  >                 Thread.sleep(1);
  >             } catch (InterruptedException e) {
  >                 e.printStackTrace();
  >             }
  >             System.out.println(Thread.currentThread().getName() + "说：" + i);
  >         }
  >     }
  > }
  > ~~~

#### 4.线程安全问题

- 我们在昨天的卖票问题以及存钱演示中确实发现了线程安全的问题，比如重复卖，超卖的问题这都是会在多线程中出现的问题，我们今天就要用Java中提供的一个工具来解决这个线程不安全问题。也就是我们常说的锁。

  > 在Java中的锁最常用的莫过于synchronized锁了，这个锁不仅可以锁代码块，而且还可以锁住方法并且这个锁在锁代码块的时候锁住的是当前这个类，而锁住方法的时候又会根据当前的方法的种类不同来锁的对象不同，当锁的方法是静态方法时锁住的是这个类当锁住的方法为普通方法时锁住的则是当前对象。关于synchronized锁有比较经典的八锁问题，具体可以去看一下我之前写过的一篇synchronized八锁问题详解。还有一种锁是Lock锁，这个锁被称为手动锁，这个锁要求我们必须手动上锁解锁。并且Lock锁是一个接口它有三个具体的实现类
  >
  > * @see ReentrantLock----互斥锁 它的作用和synchronized类似
  >
  > * @see Condition ---
  >
  > * @see ReadWriteLock-- 读写锁，当进行的为读操作则不会上锁，当进行的为写操作则进行上。
  >
  >   下面我们就会根据这两种锁来实现线程安全的数组添加问题。
  >
  > 案例 使用synchronized以及Lock锁来解决数组/集合在添加过程中的线程不安全问题。
  >
  > ~~~java
  > // 使用synchronized锁
  > public class SafeArrayAddSource {
  >     static String[] stringSp = new String[2];
  >     static final Object object = new Object();
  >     static int index = 0;
  > 
  >     public static void main(String[] args) throws InterruptedException {
  >         // 创建一个String数组来作为存放数据的容器
  >         //然后创建两个线程让这两个线程分别给这个数组添加数据
  >         Thread t2 = new Thread(() -> {
  >             // 想要解决线程不安全的问题我们要在这使用synchronized锁来保证当前修改的对象只能被一个线程修改，其他人想进入得排队
  >             synchronized (stringSp) {
  >                 if (stringSp[index] == null) {
  >                     stringSp[index] = "hello";
  >                     index++;
  >                 }
  >             }
  > 
  >         }, "线程A");
  >         Thread t1 = new Thread(() -> {
  >             synchronized (stringSp) {
  >                 if (stringSp[index] == null) {
  >                     stringSp[index] = "word";
  >                     index++;
  >                 }
  >             }
  >         }, "线程B");
  >         t2.start();
  >         t1.start();
  >         t2.join();
  >         t1.join();
  >         // 首先我们要保证这条打印语句要在上面两个赋值操作执行完毕之后在执行，所以我们要让t1，t2线程插队到Main线程的前面
  >         // 然后我们执行代码会发现 当我们打印的时候小概率的情况下会发现某一个变量可能会是null，这种就是出现了线程不安全的问题
  >         // 两个线程本应该分别修改两个数组位置的
  >         // 但是他们因为线程切换的问题操作了同一个字符串，所以我们需要使用锁来解决这种线程不安全的问题
  > 
  >         System.out.println(Arrays.toString(stringSp));
  >     }
  > }
  > //使用Lock锁
  >   public static void lockTest() throws InterruptedException {
  >         // 同样也是创建一个数组来作为存放的容器
  >         String[] strings = new String[2];
  >         // 不过我们要在这创建一个Lock锁的实现类
  >         Lock lock = new ReentrantLock();
  >         //启动俩线程来分别插入
  >         Thread t1 = new Thread( ()->{
  >             //进入判断钱上锁
  >             lock.lock();
  >             try {
  >                 if (strings[index] == null) {
  >                     strings[index] = "hello";
  >                     index++;
  >                 }
  >             }finally {
  >                 //解锁一定要放在finally中
  >                 lock.unlock();
  >             }
  > 
  >         } ,"线程A");
  >         Thread t2 = new Thread( ()->{
  >             //进入判断钱上锁
  >             lock.lock();
  >             try {
  >                 if (strings[index] == null) {
  >                     strings[index] = "word";
  >                     index++;
  >                 }
  >             }finally {
  >                 //解锁一定要放在finally中
  >                 lock.unlock();
  >             }
  > 
  >         } ,"线程B");
  >         t1.start();
  >         t2.start();
  >         t1.join();
  >         t2.join();
  >         System.out.println(Arrays.toString(strings));
  >     }
  >     
  > }
  > ~~~

- 测试：尝试使用Lock锁来解决昨天的卖票问题,显然卖票问题是和上面我们写的数组问题一样都是线程切换导致的所以我们只需要给卖票的业务代码中每次判断之前加上锁即可。

  ~~~java
  public class SafeSellTrick {
      public static void main(String[] args) {
          // 创建三个线程分别来卖票
          Sell sell = new Sell();
          new Thread(sell,"窗口A").start();
          new Thread(sell,"窗口B").start();
          new Thread(sell,"窗口C").start();
  
      }
  }
  class Sell implements Runnable{
      // 共计100张票
      private int tickNub = 100;
      private boolean flag = true;
      Lock lock = new ReentrantLock();
      @Override
      public void run() {
          while (flag){
              try {
                  //进入判断之前上锁
                  lock.lock();
                  if (tickNub<=0){
                      flag=false;
                  }else {
                      System.out.println(Thread.currentThread().getName() + "卖出了一张票还剩下" + --tickNub + "张");
                  }
              }finally {
                  // finally中解锁
                  lock.unlock();
              }
          }
      }
  }
  ~~~

#### 5.线程中的死锁问题

- 我们既然已经使用了锁了就难免会发生死锁问题，其实死锁是什么呢？通俗点讲就是两个线程现在彼此占用一个锁并且需要对方手里的锁才能完成剩下的业务，但是彼此又不愿意放开自己手里的锁就导致了死锁。死锁是非常严重的问题往往会导致程序卡死，所以在开发中我们要尽量避免死锁，解决方案有如下几种。

  多个线程尽量不使用同一把锁，尽量使用线程安全类而不是使用锁，避免锁的嵌套。

  下面我们就举一个比较生动的例子来演示死锁:女生化妆，女生化妆需要镜子与口红，但是现在女生A占用口号想要镜子，另外一个女生占用镜子想要口红，导致死锁。

  代码演示如下:

  ~~~java
  public class DeadLock {
      public static void main(String[] args) {
          // 分别创建口红类与镜子类对象
          Lipstick lipstick = new Lipstick();
          Mirror mirror = new Mirror();
          //然后起两个线程代表两个女生
          new Thread(()->{
              // 小红刚开始占有口红
              synchronized (lipstick){
                  System.out.println("小红拿到了口红");
                  // 需要另一间物品才能化妆
                  synchronized (mirror){
                      System.out.println("小红拿到了镜子");
                      System.out.println("小红化妆完毕，归还物品");
                  }
              }
          },"小红").start();
          new Thread(()->{
              // 小玉刚开始占有镜子
              synchronized (mirror){
                  System.out.println("小玉拿到了镜子");
                  // 需要另一间物品才能化妆
                  synchronized (lipstick){
                      System.out.println("小玉拿到了口红");
                      System.out.println("小玉化妆完毕，归还物品");
                  }
              }
          },"小红").start();
      }
  }
  class Lipstick{}
  class Mirror{}
  ~~~

  当然这个也不是一定会发生死锁，当小红刚开始速度够快即占用了口红又占用了镜子那么小玉就会等待小红画完装然后正常执行，但是当小红拿到口红还没来得及拿镜子的时候镜子被小玉占用那么俩门俩就会陷入死锁中谁也画不了装。

#### 6.线程中的通信

- 有时候我们希望线程是交替执行的比如说存钱取钱，厨师与顾客，当线程a放入一个物品就通知线程c来消费，每当线程a发现已经有物品了就等待，当线程c发现没物品了也等待并且通知线程a来生产。这就是最经典的生产者与消费者的案例。在Java中为我们提供了两个方法，并且这两个方法是写在Object类中的，她的重要性可想而知，分别是wait与notify，wait是等待的意思会停止当前的线程让出锁等待其他线程唤醒它，而notify的意思是幻想是用来唤醒其他线程的。我们今天就拿交替存钱取钱的例子来实现生产者消费者案例。

  ~~~java
  public class AlternateAccess {
      public static void main(String[] args) {
          Bank bank = new Bank();
          new Thread(()->{
              for (int i = 0; i < 10; i++) {
                  try {
                      bank.save();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          },"小明").start();
  
          new Thread(()->{
              for (int i = 0; i < 10; i++) {
                  try {
                      bank.take();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          },"小红").start();
      }
  }
  
  /**
   * 这个代表银行账户
   */
  class Bank {
      private int money = 0;
  
      /**
       * 取钱同步方法，并且每次取1000
       */
      public synchronized void take() throws InterruptedException {
          // 当余额小于等于0的时候当前线程通知其他线程存钱，然后等待被其他线程唤醒
          if (money <= 0) {
              notify();
              System.out.println(Thread.currentThread().getName()+"在等待其他人存钱");
          }
          wait();
          // 当被唤醒之后就执行取钱业务减去1000元
          money = money - 1000;
          System.out.println(Thread.currentThread().getName() + "取走了1000元，还剩下" + money);
          // 取走之后通知存钱
          notify();
      }
      /**
       * 存钱同步方法，每次存1000元
       */
      public synchronized void save() throws InterruptedException {
          // 当金额大于0通知其他线程来取钱，并且等待其他线程唤醒
          if (money > 0) {
              notify();
              System.out.println(Thread.currentThread().getName()+"在等待其他人取钱");
          }
          wait();
          // 被唤醒了就执行业务增加1000元
          money = money + 1000;
          System.out.println(Thread.currentThread().getName() + "存入了1000元，还剩下" + money);
          // 存完之后通知取钱
          notify();
      }
  }
  ~~~


### 五.线程高级篇(JUC)

- 我们在上一节已经讲了Java中基础的线程，Thread类，Runnable接口，并且学习了Thread类中的一些常用的方法。探究了线程中的安全问题，线程的死锁，线程之间的通信，这些都是线程中的基础内容。今天我们就要来开始学习Java线程的高级篇（juc包）。

#### 1. 什么是juc

- juc包中是java核心中比较难的部分，里面内容都是关于Java并发编程的工具，里面大多数jdk1.5/jdk1.8加入的新特新，里面就有我们今天要学习的线程池，Callable接口，线程安全集合类等等。

#### 2.什么是线程池

- 在很多地方我们都会看到 “xxx池” 比如数据库连接池，线程池。池化技术是一个非常常见的一个优化技术，使用池化可以避免资源的重复创建和关闭，就拿数据库连接来说吧。我们写原生jdbc的时候每次执行sql操作的时候都要创建一次连接然后执行完毕还要关闭这个资源，这样无疑把大量时间放到了建立连接和关闭连接上面了，而且使用池化技术也能去限制无限制的创建资源，我们可以预先设定好池中的容量想要资源的只能去池中获取，若池中没有空闲资源就让它等待或者不让他去执行。使用线程池也是这个原理。

- 在Java中的线程池的代码体系如下。

  > 顶级接口 Executor，这个接口只有一个方法方法execute(Runnable x)，我们指定Runnable是Thread的父接口那么这个方法的功能就很显然了，用来执行线程任务的。
  >
  > 接口 ExecutorService，这个接口是Executor的子接口它继承了接口Executor并且对它的功能进行进一步的拓展，我们使用Executors工具类创建出来的线程池都是这个类型的。他的常用方法如下
  >
  > 1. void shutdown(); 这个方法是用来关闭线程池的，他是会等待所有的线程执行完毕之后才回去关闭线池。
  >
  > 2. List<Runnable> shutdownNow(); 这个方法也是用来关闭线程池的，但是它与上面的方法不同之处为它会尝试关闭当前正在执行的线程(虽然大概率都会失败，但是它真的尝试了)然后拒绝还没获取到线程池资源的线程，然后关闭线程池。
  >
  > 3. boolean isShutdown(); 判断线程池是否已关闭，注意线程池虽然已经关闭但是不代表所有线程已经执行完毕了。
  >
  > 4. boolean isTerminated(); 判断所有线程是否已经终止
  >
  > 5. <T> Future<T> submit(Callable<T> task);用来执行一个Callable类型任务，当然这个方法也会有重载也可以执行Runnable类型任务
  >
  > 6. <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)；用来执行一个Callable类型以及它的子类任务的List并且会返回一个Futuer的List用来 存放返回值
  >
  > 7. <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,long timeout, TimeUnit unit)； 这个是上个方法的重载方法是用来批量执行Callable任务但是它可以设置任务时间段，当超时的时候会抛出异常。
  >
  >    这些方法我们在这只做了解在后面会逐一演示
  >
  > 工具类Exectors，这个工具类提供了若干关于任务执行以及线程池相关的方法，我们后面在创建线程池的时候会讲到。
  >
  > 剩下的就是四种线程池了分别为
  >
  > 1. FixedThreadPool：定长线程池，拥有固定长度就算有多个任务等待执行也不会开辟新的线程来执行任务
  >
  > 2. SingleThreadExecutor：单个线程执行器，这个线程池只会开辟一个线程，就算再多的任务也只是用这一个线程，所以叫他单个线程执行器
  >
  > 3. CachedThreadPool：缓冲线程池，它会随着我们任务的数量来开辟线程，适合短期任务量较大的服务
  >
  > 4. ScheduledThreadPool：延迟执行线程池，我们可以给他设置线程创建并且执行的延迟时间，感觉有点用不到
  >
  > 5. 自定义线程池，模仿官方的线程池创建方法来创建一个线程池。
  >
  >    同样我们在这只做介绍，具体的实现我们还是交给后面一小节来演示。
  >
  > 

#### 3.如何创建线程池

- Java中的线程池我们在上面已经见到那的介绍过了，那么创建线程池我们可以使用官方提供的线程池工具（Executors）来创建。

  > 上面的四种线程池创建方式如出一辙，都是调用Executors中的方法来创建具体代码如下
  >
  > FixedThreadPool，这个线程池无论有多少任务都之会开辟我们预先设定好的线程数量
  >
  > ~~~java
  > public class ManyThreadPool {
  >     public static void main(String[] args) {
  >         // 创建定长线程池
  >         ExecutorService executorService = Executors.newFixedThreadPool(3);
  >          // 使用这个线程池执行十个任务
  >         for (int i = 0; i < 10; i++) {
  >             executorService.submit(()->{
  >                 System.out.println(Thread.currentThread().getName() + "：你好");
  >             });
  >         }
  >     }
  > }
  > ~~~
  >
  > SingleThreadExecutor，这个线程池就会开辟一个线程来执行任务
  >
  > ~~~java
  > public class ManyThreadPool {
  >     public static void main(String[] args) {
  > ExecutorService executorService = Executors.newSingleThreadExecutor();
  >         // 使用这个线程池执行十个任务
  >         for (int i = 0; i < 10; i++) {
  >             executorService.submit(()->{
  >                 System.out.println(Thread.currentThread().getName() + "：你好");
  >             });
  >         }
  > 
  >     }
  > }
  > ~~~
  >
  > CachedThreadPool，这个线程池会根据当前条件动态的创建线程资源来执行任务
  >
  > ~~~java
  > public class ManyThreadPool {
  >     public static void main(String[] args) {
  >          // 创建缓冲线程池
  >         ExecutorService executorService = Executors.newCachedThreadPool();
  >         // 使用这个线程池执行十个任务
  >         for (int i = 0; i < 26; i++) {
  >             executorService.submit(()->{
  >                 System.out.println(Thread.currentThread().getName() + "：你好");
  >             });
  >         }
  >     }
  > }
  > ~~~
  >
  > ScheduledThreadPool，这个线程池在执行任务的时候可以指定时间长度来设为延迟执行
  >
  > ~~~java
  > public class ManyThreadPool {
  >     public static void main(String[] args) {
  >          // 创建延迟线程池
  >         ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
  >         for (int i = 0; i < 5; i++) {
  >             scheduledExecutorService.schedule(()->{
  >                 System.out.println(Thread.currentThread().getName() + "：你好");
  >             },5000, TimeUnit.MILLISECONDS);
  >         }
  >     }
  > }
  > ~~~

#### 4.线程池中的常用方法

- 我们在上面的介绍中也简单的介绍了一下线程池接口ExecutorService中的常用方法，我们下面就简单的介绍演示一下这些方法的用法。

  > 我在这个案例中演示了我们在上面介绍的所有方法，并且对于关键方法我都进行了大量的代码注释，敬请读者仔细阅读下面的源码，并且进行调试。当然我们在这里使用到了Callable的方法创建线程，Callable的接口创建线程我放在下个章节来讲解。
  >
  > ~~~java
  > public class ThreadPoolMethods {
  >     public static void main(String[] args) throws Exception {
  >         // 我们就拿定长线程池来做方法的演示吧
  >         ExecutorService executorService = Executors.newFixedThreadPool(6);
  >         // 首先就是最基础的execute方法老祖宗传下来的用来执行一个Runnable类型任务。当然在线程池中我们常常用submit方法来执行线程任务
  >         executorService.execute(()->{
  >             System.out.println("你好，我是通过execute执行的Runnable线程任务");
  >         });
  >         // 然后是submit方法，它不仅可以执行Runnable类型任务还可以执行Callable类型任务
  >         executorService.submit(()->{
  >             System.out.println("你好，我是通过submit执行的Runnable线程任务");
  >         });
  >         Future<Integer> submit = executorService.submit(() -> {
  >             System.out.println("我是通过submit执行的Callable任务，我可以返回数值");
  >             return 123;
  >         });
  >         System.out.println("我是执行的结果：" + submit.get());
  > 
  >         // 然后是shutdown()方法与isShutdown()，isTerminated()方法
  >         // 这三个方法分别是关闭线程池，判断线程池是否关闭，判断线程池任务是否执行完毕的
  >         // 我们创建20个任务然并且延迟执行后执行上面三个方法看看效果
  >         for (int i = 0; i < 20; i++) {
  >             int finalI = i;
  >             executorService.submit(()->{
  >                 System.out.println(Thread.currentThread().getName() +":"+ finalI);
  >             });
  >         }
  >         // 创建一个存放callable任务的List，然后通过invokeAll来执行
  >         List<Callable<Object>> callables = new ArrayList<>();
  >         callables.add( () -> 123);
  >         callables.add( () -> 456);
  >         callables.add( () -> 789);
  >         callables.add( () -> 901);
  >         // 便利出来执行的结果
  >         executorService.invokeAll(callables,1,TimeUnit.MILLISECONDS).forEach(objectFuture -> {
  >             try {
  >                 System.out.println("invokeAll执行结果：" + objectFuture.get());
  >             } catch (InterruptedException | ExecutionException e) {
  >                 e.printStackTrace();
  >             }
  >         });
  >         executorService.shutdown();
  >         // 那么如果我们将shouted换成shutdownNow呢？这个是立即停止线程
  > //        executorService.shutdownNow();
  >         // 显然我们可以看到线程池虽然被关闭了但是线程仍然在跑着，并且线程池中的任务也没有执行完毕，这也佐证了我们翻阅源码中所说的内容
  >         // 我们在使用shutdownNow方法的时候它出现了报错，sleep中断，按照我自己的理解结合shutdownNow的方法描述可以得出下面的结论
  >         // 当我们执行shutdownNow他会尽量将正在执行的任务终止，因为要保证安全让线程任务执行完毕自然结束是最安全的所以，他会停止那些
  >         /*
  >             还没获取到线程池资源的任务，然后会尽量终止正在执行的任务并且等待无法终止的已经获取到线程池资源的线程任务执行完毕去
  >          关掉线程池,对于那些还没获取到线程资源的任务则直接拒绝，然后关掉线程池。对于使用sleep阻塞的线程它自然也是不愿意等直接就给
  >          抛出了异常
  >          */
  >         System.out.println("线程池被关闭了吗：" + executorService.isShutdown());
  >         System.out.println("线程池中的任务执行完毕了吗：" + executorService.isTerminated());
  >     }
  > }
  > 
  > ~~~
  >
  > 

#### 5.更优雅的创建线程Callable

- 我们在之前的创建线程任务的时候要么是继承Thread类要么是实现Runnable接口这两种其实都是一种，都不能抛出异常，都不能返回执行结果，那么我们如果想开辟一个线程去进行一些计算并且将执行的结果返回过来，这时候就不能在使用传统的线程创建方式了，要使用Callable来创建线程。

- 使用Callable创建的线程我们有一点要注意的是，Thread类好像并不接受Callable类型的任务，它只能接受Runnable类型的任务，但是我们Callable是一个接口无法执行，所以我们就得去让Callable给Runnable勾搭上关系。我们都知道Runnable是所有线程任务相关的老父亲，必然亲戚满天下，我们不妨就去找一找Runnable下面的实现类或者子接口。

  我们开始翻阅源码先是找Runnable的实现类，然后我们发现了一个叫RunnableFuture的接口，照着他往下点发现了一个叫FutureTask，嗯这个一看就很可疑，我们发现它的一个构造方法竟然可以传入Callable类型的对象，好家伙这不就勾搭上了吗。我们可以创建FutureTask对象，然后传入Callable接口的实现类，然后将FutureTask交给Thread类这样由于它是实现了Runnable接口就可以被Thread类所接纳那么我们就可以执行Callable任务了，而且我们在继续翻阅的时候发现FutureTask就是对Callable量身制作的它封装了Callable的执行结果返回值。我们可以通过get方法来取到这个Callable中的call方法返回的结果。

  ![1667384295253](java%E9%AB%98%E7%BA%A7.assets/1667384295253.png)

  执行代码如下:

  ~~~java
  public class CallableCreateThread {
      public static void main(String[] args) {
          // 创建一个Callable的实现类然后交给FutureTask包装一下
          FutureTask<Integer> futureTask = new FutureTask<>(() -> {
              System.out.println("123");
              return 123;
          });
          // 将futureTask交给Thread执行，然后通过futureTask中的get方法取到返回值并且打印
          new Thread(futureTask).start();
          try {
              System.out.println(futureTask.get());
          } catch (InterruptedException | ExecutionException e) {
              e.printStackTrace();
          }
      }
  }
  ~~~

- 你有没有发现这样超级麻烦哎，先要创建Callable接口实现类，还有创建FutureTask类，然后还要创建Thread类，然后再start。但是我们再上一节线程池的时候直接使用线程池的.submit方法就能直接执行Callable接口的实现类，所以说juc包中的Callable官方都用这种方式推荐(强迫)我们使用线程池来执行Callable任务。

#### 6.线程安全的集合类

- 我们都知道Collection中的集合类大多数都是线程不安全的，比如ArrayList，LinkList，比如HashMap等等。这些在多线程中都会出现种种问题。但是他们也是有线程安全的集合类的比如Vector，是线程安全的List，比如HashTable是线程安全的HashMap，但是我们会发现一个诡异的问题Vector与Hashtable均是jdk1.0出现的List与HashMap均是jdk1.2出现的？这是为啥呢？明明已经有比较好用的线程安全集合了为啥子还要创建线程不安全的集合类。因为你翻阅源码就可以知道Vector，Hashtable都是在方法上加了syn锁来实现的线程安全，这样虽然解决了但是这样的效率非常的低，所以今天我们就不在讲这些古老的线程安全类来讲一下juc包中的线程安全类。

  > 首先我们来演示一波集合的线程不安全，就拿List并发情况下读写数据吧
  >
  > ~~~java
  > public class UnSafeCollection {
  >     public static void main(String[] args) {
  >         List<String> list = new ArrayList<>();
  >         // 创建20个线程循环读写
  >         for (int i = 0; i < 20; i++) {
  >             new Thread(()->{
  >                 list.add(Thread.currentThread().getName());
  >                 System.out.println(list);
  >             }).start();
  >         }
  >     }
  > }
  > ~~~
  >
  > 显然第一次就出现了错误，这个报错就代表着线程读写不安全具体原因大家可以去查询一下资料不然这样讲篇幅太长了
  >
  > ![1667385448799](java%E9%AB%98%E7%BA%A7.assets/1667385448799.png)
  >
  > 然后我们来讲一下线程安全的List，这个List叫CopyOnWriteArrayList它是读写分离List对于写操作会上锁，而对于读操作则不会上锁，这样即保证了效率又保证了线程安全
  >
  > ~~~java
  > public class SafeCollection {
  >     public static void main(String[] args) {
  >         // 创建线程安全的List
  >         CopyOnWriteArrayList<String> safeList = new CopyOnWriteArrayList<>();
  >         // 创建20个线程来进行读写操作，最后发现并没有任何的线程安全错误
  >         for (int i = 0; i < 20; i++) {
  >             new Thread(()->{
  >                 safeList.add(Thread.currentThread().getName());
  >                 System.out.println(safeList);
  >             }).start();
  >         }
  >     }
  > }
  > 
  > ~~~
  >
  > 我们发现juc包下的CopyOnWriteArrayList并没有出现任何的线程安全问题，并且它的用法是和原生的List一毛一样，当然对于Set和Map在Juc包下均有对应的线程安全类而且使用的方法也是和原生的一样，这就是面向对象编程的魅力！
  >
  > 三个线程安全的集合类分别为，上面俩的原理为在每次修改，添加，删除之前都会给原子数组上锁然后拷贝出一个副本对其进行修改，然后讲修改后的内容赋给原子数组。
  >
  > CopyOnWriteArrayList（写前拷贝的List）
  >
  > CopyOnWriteArraySet（写前拷贝的Set）
  >
  > ConcurrentHashMap（并发的哈希Map）
  >
  > 当然在Collections工具类中提供了一系列的转化成线程安全的集合 方法，但是效率肯定是不如juc包中的，但是也不失为一种方法，大家酌情使用。
  >
  > ![1667386228939](java%E9%AB%98%E7%BA%A7.assets/1667386228939.png)

#### 7.自定义线程池

- 在阿里巴巴编程手册中标注推荐自定义线程池来保证灵活度，那么我们就来自定义一个线程池,代码以及详解都写在这里面了

  ~~~java
  public class MyThreadPool {
      public static void main(String[] args) {
          // 当然在阿里编程手册中不推荐使用工具类创建线程池，他们认为这样不够灵活，好吧那么我们就自定义一波线程池
          // 当然模仿线程池还是要按照jdk官方的例子来创建
          // 参数列表分别如下
          /*
              1.核心线程数量
              2.最大线程数量
              3.超时等待时间
              4.时间单位
              5.阻塞队列
           */
          ExecutorService executorService = new ThreadPoolExecutor(
                  2,
                  5,
                  100,
                  TimeUnit.SECONDS
                  , new LinkedBlockingQueue<Runnable>(3) {
          });
          for (int i = 0; i < 20; i++) {
              executorService.submit(()->{
                  System.out.println(Thread.currentThread().getName());
              });
          }
      }
  }
  ~~~


### 六.jdk8新特性

- 我们今天开始到未来两到三天要开始学习jdk8中的新特性，大致可以分为一下几种，lambda表达式，函数式接口，方法引用，Stream流计算等等内容。

#### 1.lambda表达式

- 什么是lambda表达式，他是用来干啥的？lambda表达式是jdk8中引入的新特性，它目的是用来简化匿名内部类的编写。并且使用lambda来代替匿名内部类会简化jvm的编译操作会少生成一个匿名内部类的class字节码文件，并且我们在idea中编写匿名内部类的时候，他也会提醒我们推荐将匿名内部类写成lambda的编写方式，所以我们在写代码的时候要多注意编辑器的警告信息，可以帮助我们学习java中的新特性。 

- 匿名内部类与lambda表达式的对比

  > 我们也在上面说了lambda是用来简化匿名内部类的编写的，所以我们不妨编写一段代码来对比一下他的简便之处。
  >
  > ~~~java
  > public class Lambda1 {
  >     public static void main(String[] args) {
  >         // 我们就拿使用Runnable接口创建线程任务的例子来演示两者之间的区别之处
  > 
  >         // 首先是通过匿名内部类的方法创建,我们要在线程的内部创建一个Runnable类型的对象，冰鞋重写run方法
  >         new Thread(new Runnable() {
  >             @Override
  >             public void run() {
  >                 System.out.println("你好我是" + Thread.currentThread().getName());
  >             }
  >         }, "线程A").start();
  >         // 使用匿名内部类的形式来实现，你会发现我们直接省略了重写run方法的步骤只需要专注于编写Runnable要进行的任务代码就可以了
  >         new Thread(
  >                 () -> System.out.println("你好我是" + Thread.currentThread().getName())
  >                 , "线程B")
  >                 .start();
  >     }
  > }
  > 
  > ~~~
  >
  > 显然我们对别上面俩段代码可以得知使用lambda表达式确实大幅度的简化了编码形式，但是我们如果是第一次接触lambda的话看上面的代码确实是有点晦涩难懂，我们就在下一节来对lambda的具体语法格式来做一下讲解。

#### 2.lambda的语法格式

- 我们在上一节说lambda是为了简化匿名内部类的，但是并不是非常的准确，使用lambda的前提是要被实现的接口必须是函数式接口才行，因为函数式接口有且只有一个抽象方法是在等待被实现的，所以我们无需考虑我们到底要实现的是那个方法，只需要关注这个方法的传入参数，返回值，以及内部的业务逻辑即可。显然根据这些我们就大致能总结出lambda的语法格式了。具体如下几条。

  > 1. 想要使用lambda来简化匿名内部类必须要求被实现接口为函数式接口
  >
  > 2. lambda的编写格式为，并且我们无需担心传入的参数列表的数据类型，只需要给他一个变量明供我们在实现的方法体中使用。他的数据类型会根据被实现接口中的方法参数列表自动推断类型。
  >
  >    ~~~java
  >    被实现的接口 t = (要传入的参数列表)->{
  >        被实现的方法体;
  >        retrun 要返回的数据;
  >    }
  >    ~~~
  >
  > 3. 特性1，如果参数列表为空的话我们还是要保留()，如果只有一个参数我们可以直接省略() ,可以使用`参数 -> { 方法体 }`的方式来编写lambda表达式
  >
  > 4. 特性2，如果方法体中只有一条语句我们可以省略{} 直接使用 `()-> 语句`的方式来编写lambda表达式
  >
  > 5. 特性3，若方法体中只有一句返回值我们可以省略{}以及retrun，直接`() -> 返回值`来编写lambda表达式，但是若我们加上了return就必须加上{}
  >
  > 6. 特性4，使用lambda表达式不仅能简化我们的代码编写还能减少一个class文件的生成。

#### 3.演示Lambda表达式使用

- 我们在上一节分别讲了lambda的语法格式以及lambda中的各个特性，所以我们在这一节分别编写一些代码来验证上面的特性与内容。

  > 首先是创建一个普通的lambda表达式(无参数无返回值)，首先我们要创建一个函数式接口。
  >
  > ~~~java
  > public class Lambda2 {
  >     public static void main(String[] args) {
  >         // 显然我们要执行这个方法必须要传入一个接口类型的对象，并且这个接口是函数式接口符合使用lambda表达式的前提
  >         // 并且是作为无参数无返回值的函数式接口，而且实现方法中只有一句表达式，直接可以省略了{}
  >         test(()-> System.out.println("你好世界"));
  >     }
  > 
  >     /**
  >      * 通常我们在使用匿名内部类的时候大多都是有这样一个方法要求我们传入一个接口类型的对象
  >      * @param sout Sout接口对象
  >      */
  >     public static void test(Sout sout){
  >         sout.print();
  >     }
  > }
  > /**
  >  * 创建一个函数式接口，来做创建匿名内部类前提。
  >  */
  > @FunctionalInterface
  > interface Sout{
  >     void print();
  > }
  > ~~~
  >
  > 然后我们要创建一个有参数有返回值的lambda表达式，还是要创建函数式子接口，这次我们就来实现一下计算数组中的数据的和并且返回结果。
  >
  > ~~~java
  > public class Lambda3 {
  >     public static void main(String[] args) {
  >         // 准备数据
  >         Integer[] integers = {1, 2, 13, 19};
  >         // 使用lambda实现有参数有返回值的函数式接口，切记items并不是我们我们在上面定义的源数据，而是只是一个标记，你可以理解为
  >         // 它只是一个形参，用来接受调用方法处传过来的参数，也就是我们在下面test方法中传过来的integers
  >         test(items -> {
  >             int sum = 0;
  >             for (Integer integer : items) {
  >                 sum=sum+integer;
  >             }
  >             return sum;
  >         }, integers);
  >     }
  >     /**
  >      * 还是创建一个测试方法来调用求和方法
  >      *
  >      * @param match    被实现的函数式接口
  >      * @param integers 被计算的数组
  >      */
  >     public static void test(Match match, Integer[] integers) {
  >         System.out.println("数组的和为:" + match.sum(integers));
  >     }
  > }
  > /**
  >  * 函数式接口计算数组和
  >  */
  > @FunctionalInterface
  > interface Match {
  >     Integer sum(Integer[] integers);
  > }
  > ~~~
  >
  > 其实总的来说lambda表达式的使用方式以及语法格式就这么多，我们在后面使用函数式接口以及stream流计算的时候会大量用到lambda表达式。

#### 4.四大函数式接口

- 在Java中提供了四大函数式接口，分别是生产者函数式接口 `Supplier<T>`  消费者函数式接口 `Consumer<T>` 函数(计算)函数式接口`Funcation<T,R>`断言者函数式接口`Predicate<T>`，这四种分别实现了Java代码中的四大功能，消费，生产，判断，计算。我们在下面会逐一讲解这四种函数式接口。

  > 首先是生产者函数接口，我们根据这个名字都能大致猜测出来生产者是用来生产数据的显然这个函数式接口大致是一个没有传入值但是有返回值的方法。我们下面就编写代码来验证一下。
  >
  > ~~~java
  > public class Function1 {
  >     public static void main(String[] args) {
  >         // 调用test方法的同时 使用lambda实现生产者函数式接口
  >         test(() -> "你好世界");
  >     }
  >     /**
  >      * 编写一个测试方法来模拟jdk中的一些需要使用函数式接口的方法
  >      * @param supplier 生产者函数式接口的实现类对象
  >      */
  >     public static void test(Supplier<String> supplier){
  >         System.out.println(supplier.get());
  >     }
  > }
  > ~~~
  >
  > 然后是消费者函数式接口，类比法消费者是只使用但不生产显然这个接口大概是让我们去实现一个有传入参数但是没有返回值的抽象方法。上代码验证
  >
  > ~~~java
  > public class Function2 {
  >     public static void main(String[] args) {
  >         List<String> strings = new ArrayList<>();
  >         strings.add("你好世界");
  >         strings.add("哈哈");
  >         strings.add("呵呵");
  >         strings.add("1111");
  >         // 调用test方法的同时 使用lambda实现生产者函数式接口，然后我们要模拟Stream流中的foreach方法不仅打印出元素还要打印出下标
  >         test(items->{
  >             for (int i = 1; i <= items.size(); i++) {
  >                 System.out.println("下标为 "+i+" 的List元素为->"+items.get(i-1));
  >             }
  >         },strings);
  >     }
  >     /**
  >      * 编写一个测试方法来模拟jdk中的一些需要使用函数式接口的方法
  >      * @param consumer 消费者函数式接口的实现类
  >      * @param list 要被消费的数组
  >      */
  >     public static void test(Consumer<? super List<String>> consumer, List<String> list){
  >         consumer.accept(list);
  >     }
  > }
  > ~~~
  >
  > 然后是计算者函数式接口，这个方法不仅有返回值还有传入参数，显然是想让我们将传递过来的参数经过一番计算之后返回过去。
  >
  > ~~~java
  > public class Function3 {
  >     public static void main(String[] args) {
  >         Integer[] integers = {1, 99, 361, 4, 9, 100, 3};
  >         // 我们要使用这个计算者函数式接口完成数组的冒泡排序
  >         test(items -> {
  >             int temp;
  >             for (int i = 0; i < items.length; i++) {
  >                 for (int j = 1; j < items.length - i; j++) {
  >                     if (items[j - 1] > items[j]) {
  >                         {
  >                             temp = items[j];
  >                             items[j] = items[j - 1];
  >                             items[j - 1] = temp;
  >                         }
  >                     }
  >                 }
  >             }
  >             return items;
  >         }, integers);
  >     }
  > 
  >     /**
  >      * 编写一个测试方法来模拟jdk中的一些需要使用函数式接口的方法
  >      *
  >      * @param function 计算者函数式接口的实现类
  >      * @param integers 要被计算的数组
  >      */
  >     public static void test(Function<Integer[], Integer[]> function, Integer[] integers) {
  >         for (Integer integer : function.apply(integers)) {
  >             System.out.println(integer);
  >         }
  >     }
  > }
  > ~~~
  >
  > 还剩最后一个函数式接口了，就是断言者函数接口。它是有一个传入值，然后返回一个布尔类型的数据，是让我们判断传入的内容然后是否符合某种规则然后将判断结果返回给我们。
  >
  > ~~~java
  > public class Function4 {
  >     public static void main(String[] args) {
  >         // 我们想要判断最后一个字符串是否为只当内容，显然我们这个lambda表达式因为只有一个参数一个语句所以省略了(),{}，以及return语句
  >         String str = "hellos";
  >         test(e -> "s".equals(e.substring(str.length() - 1, str.length())), str);
  >     }
  >     /**
  >      * 编写一个测试方法来模拟jdk中的一些需要使用函数式接口的方法
  >      * @param predicate 断言者函数式接口的实现类
  >      * @param str       要被判断的数组
  >      */
  >     public static void test(Predicate<String> predicate, String str) {
  >         if (predicate.test(str)) {
  >             System.out.println("最后一个字符串内容确实为s");
  >         } else {
  >             System.out.println("最后一个字符串内容不为s");
  >         }
  >     }
  > }
  > ~~~
  >
  > 至此基本上Java内置的四大函数式接口已经讲解完毕，我们在实际开发中自己创建需要函数式接口的工具方法是非常非常之少，但是在jdk内部特别是stream流中定义了大量的这四种类型的函数式接口，所以我们要掌握他们的使用方式以及能看懂函数式接口。我们下面就简单的举个jdk官方定义使用函数式接口的例子。
  >
  > ~~~java
  > public class ListSort {
  >     public static void main(String[] args) {
  >         // 我们要实现对象自定义排序，可以直接使用Collections提供的排序方法
  >         List<Student> students = new ArrayList<>();
  >         students.add(new Student("zs",18));
  >         students.add(new Student("ls",12));
  >         students.add(new Student("ww",46));
  >         students.add(new Student("zl",9));
  >         // 我们根据数组中的对象的age属性进行排序，显然我们会发现这个sort中的参数即使函数式接口Comparator比较者
  >         students.sort(((o1, o2) -> o1.age - o2.age));
  >         // 我们再使用forEach方法来实现List的便利，当然我们点入forEach方法可以看出来这给方法需要的是一个Consumer 消费者
  >         students.forEach(student -> System.out.println(student));
  >     }
  > }
  > class Student{
  >     String name;
  >     Integer age;
  > 
  >     public Student(String name, Integer age) {
  >         this.name = name;
  >         this.age = age;
  >     }
  > 
  >     public String getName() {
  >         return name;
  >     }
  > 
  >     public void setName(String name) {
  >         this.name = name;
  >     }
  > 
  >     public Integer getAge() {
  >         return age;
  >     }
  > 
  >     public void setAge(Integer age) {
  >         this.age = age;
  >     }
  > 
  >     @Override
  >     public String toString() {
  >         return "Student{" +
  >                 "name='" + name + '\'' +
  >                 ", age=" + age +
  >                 '}';
  >     }
  > }
  > ~~~
  >

#### 5.方法引用

- 虽然lambda表达式已经十分简洁了，但是我们写的时候会出现一个lambda表达式只是去调用一个已经存在的方法，并且lambda的参数正好为要调用方法的参数，亦或是参数作为类对象的引用来调用类中的某一个方法来做使用。在Java中共有四种这样的方法引用可以替代传统的lambda表达式。我们在下面分别对这四种进行逐一讲解

  > 1. 静态方法引用，它的替换格式大概为 `(args)-> {类名.静态方法(args)}` 替换为`类名::方法名`，只要是满足这个格式的lambda表达式均可以换成右边的这种方法引用
  >
  >    ~~~java
  >    public class MethodRef1 {
  >        public static void main(String[] args) {
  >            //想要使用lambda或者方法引用我们必须要有一个函数式接口，因为我们下面定义的是一个有参数有返回值的，我们就使用
  >            // Fun型的函数式接口
  >            // 因为这里我们只是去调用了我们预先定义好的方法，并且符合静态方法引用的替换规范所以可以直接将传统的lambda替换成静态方法引用
  >    //        Function<Integer[],Integer> function = integers -> MethodRef1.sum(integers);
  >            Function<Integer[],Integer> function = MethodRef1::sum;
  >            Integer[] arr = {1,2,3,4,5};
  >            // 将数组传入我们上面重写的方法中并且打印返回值
  >            System.out.println(function.apply(arr));
  >        }
  >    
  >        /**
  >         * 模拟一个静态方法，计算数组之合
  >         * @param integers 要被计算的数组
  >         * @return 数组内容的和
  >         */
  >        public static Integer sum(Integer[] integers) {
  >            int sum = 0;
  >            for (Integer integer : integers) {
  >                sum = sum + integer;
  >            }
  >            return sum;
  >        }
  >    }
  >    ~~~
  >
  > 2. 实例方法引用，根据名字我们就能猜出七七八八，无非是使用实例对象去调用类中的方法，替换格式为：`(args)->{实例对象.方法名(args)}`替换为`实例对象::方法名`只要是满足这个格式的lambda表达式均可以换成右边的这种方法引用
  >
  >    ```java
  >    public class MethodsRef2 {
  >        public static void main(String[] args) {
  >            // 先构建一个实例对象
  >            People people = new People("向晚");
  >            // 因为这个是没参数有返回值的我们不妨使用生产者函数式接口
  >    //        Supplier<String> supplier = ()->people.getName();
  >            Supplier<String> supplier = people::getName;
  >            System.out.println(supplier.get());
  >        }
  >    }
  >    class People{
  >        String name;
  >        public People(String name) { this.name = name; }
  >        public String getName(){ return this.name; }
  >    }
  >    ```
  >
  > 3. 对象方法引用，其实这个方法引用和上面的似乎没撒子区别不过这个方法的调用对象是传过来的参数。替换方式如下 `(对象引用,参数)->{对象引用.实例方法名(参数)}`替换为 `类名::实例方法名`这种调用方式甚至和上面的静态方法引用类似，不过这里确实是对象方法引用。
  >
  >    ~~~java
  >    public class MethodRef3 {
  >        public static void main(String[] args) {
  >            // 创建两个实例对象
  >            Food food1 = new Food("苹果");
  >            Food food2 = new Food("小平果");
  >            // 显然对于一个即有传入值又有返回值的并且返回值为布尔类型我们直接使用断言者函数式接口
  >    //      BiPredicate<Food,Food> biPredicate = (f1,f2)->f1.equals(f2);
  >            BiPredicate<Food,Food> biPredicate = Food::equals;
  >            System.out.println(biPredicate.test(food1, food2));
  >        }
  >    }
  >    class Food{
  >        String name;
  >        public Food(String name) {
  >            this.name = name;
  >        }
  >        /**
  >         * 重写一个equals方法，来作为对象的比较让两个对象只比较name属性
  >         * @param obj 传入的对象
  >         * @return 是否相等
  >         */
  >        public boolean equals(Food obj) {
  >            return this.name.equals(obj.name);
  >        }
  >    }
  >    ~~~
  >
  > 4. 最后一个即为构造方法引用替换格式如下`(args)->{new 类名(args)}`可替换为`类名::new`。这种可以替换构造方法，当然替换的同时要找到合适的函数式接口保证函数式接口的参数列表与函数式接口的被实现方法的参数保持一致。并且jdk内部提供的函数式接口很难满足我们构造器方法引用的条件，所以我们要自己创建一个函数式接口来使用构造方法引用来创建实例对象。
  >
  >    ~~~java
  >    public class MethodRef4 {
  >        public static void main(String[] args) {
  >            // 我们想要模拟动物类的构造方法引用就需要对照着动物类的构造方法创建一个函数式接口，然后才能演示构造方法引用
  >    //        AnimalFactory animalFactory = ((name, age, address) -> new Animal(name,age,address));
  >            AnimalFactory<Animal> animalFactory = Animal::new;
  >            System.out.println(animalFactory.createBean("东北虎", 18, "东北"));
  >        }
  >    }
  >    
  >    /**
  >     * 定义一个创建Animal类对象的函数式接口
  >     */
  >    @FunctionalInterface
  >    interface AnimalFactory<T>{
  >        Animal createBean(String name,Integer age,String address);
  >    }
  >    class Animal{
  >        private String name;
  >        private Integer age;
  >        private String address;
  >    
  >        public Animal(String name, Integer age, String address) {
  >            this.name = name;
  >            this.age = age;
  >            this.address = address;
  >        }
  >        @Override
  >        public String toString() {
  >            return "Animal{" +
  >                    "name='" + name + '\'' +
  >                    ", age=" + age +
  >                    ", address='" + address + '\'' +
  >                    '}';
  >        }
  >    }
  >    ~~~

#### 6.Stream流式计算

- 都说Stream流，lambda表达式，方法引用作为新时代程序员必备的三大法宝。Stream流配合lambda表达式能够极大程度的提高我们对集合类的操作效率。集合用来存储Stream用来运算。

- 我们下面先不讲解Stream流的语法格式以及具体用法我们先来根据一个案例来对比一下Stream流到底方便到那里了。

  > 案例：现有一组集合数据，里面有若干个People对象，要求从中筛选出年龄大于18，国籍为中国，姓刘的人的具体信息并且打印。
  >
  > 如果是对于传统的集合判断方法我们必须要便利三次，做三次判断才能完成这个业务下面我们就来对一下两者之间的差距。
  >
  > ~~~java
  > public class StreamDemo {
  >     public static void main(String[] args) {
  >         List<People> peoples = new ArrayList<>();
  >         peoples.add(new People("刘星",18,"米国"));
  >         peoples.add(new People("刘赞",16,"中国"));
  >         peoples.add(new People("王星",21,"俄国"));
  >         peoples.add(new People("赵星",46,"法国"));
  >         peoples.add(new People("刘参",33,"中国"));
  >         peoples.add(new People("刘忙",19,"霓虹国"));
  >         peoples.add(new People("刘参宿",24,"中国"));
  >         stream(peoples);
  >     }
  > 
  >     /**
  >      * 使用Stream流式计算集合
  >      * @param peoples 被计算的集合
  >      */
  >     public static void stream(List<People> peoples){
  >         peoples.stream()
  >                 .filter(people -> people.getAge()>18)
  >                 .filter(people -> "中国".equals(people.getAddress()))
  >                 .filter(people -> people.getName().startsWith("刘"))
  >                 .forEach(System.out::println);
  >     }
  > 
  >     /**
  >      * 传统的计算集合的方法
  >      * @param peoples 要被计算的集合
  >      */
  >     public static void tradition(List<People> peoples){
  >         List<People> temp1 = new ArrayList<>();
  >         // 第一次便利找到年龄大于18的
  >         for (People people : peoples) {
  >             if (people.getAge()>18){
  >                 temp1.add(people);
  >             }
  >         }
  > 
  >         List<People> temp2 = new ArrayList<>();
  >         // 第二次找到中国的
  >         for (People people : temp1) {
  >             if ("中国".equals(people.getAddress())){
  >                 temp2.add(people);
  >             }
  >         }
  >         List<People> temp3 = new ArrayList<>();
  >         // 第三次找到姓刘的
  >         for (People people : temp2) {
  >             if (people.getName().startsWith("刘")){
  >                 temp3.add(people);
  >             }
  >         }
  >         System.out.println(temp3);
  >     }
  > }
  > 
  > @Data
  > @AllArgsConstructor
  > class People{
  >     private String name;
  >     private Integer age;
  >     private String address;
  > }
  > ~~~
  >
  > 显然你对比之后可以看到，使用传统的方法外面遍历了三次集合对象，甚至还创建了三个临时集合对象来保存每次计算完的集合，这实在是太麻烦了。反观我们使用stream流式计算，搭配上链式编程与拉姆得表达式直接一行代码就解决了所有的问题，所以说使用流式计算加上lambda表达式能大幅度的简化我们的代码整洁度并且看习惯了我们使用也是十分的流畅。

- 上面我们已经简单的演示了Stream的强大之处下面我们就来简单的讲一下它的语法格式与api方法。

  > 首先什么是stream流式计算。
  >
  > Stream流是jdk8引来的新特性，在它出现之前我们操作集合只能通过循环便利然后将计算后结果赋给一个新的对象，这样非常浪费空间，但是在引入stream之后我们可以将集合转化为stream流然后对流进行一系列的运算，过滤等操作。
  >
  > 获取Stream流，获取Stream流的方式有四种创建方式分别为
  >
  > 1. Collection对象中的stream()方法
  >
  > 2. Arrays中的stream()方法
  >
  > 3. Stream接口中的of(),iterate()，generate()方法
  >
  > 4. IntStream中，LongStream，DoubleStream中的of，range，等等方法。
  >
  > 其实这些方法中就前两个比较常用。
  >
  > Stream中的常用Api方法，stream中的方法可以分为两种，中间操作与终止操作，再执行终止操作之前任何的中间操作都不会起作用，这也是Stream中的一个特性。
  >
  > 下面这几条是stream流的中间操作
  >
  > 1. filter()方法这个方法顾名思义是过滤的意思，它需要的是一个比较者函数式接口，会根据重写方法执行的布尔值结果来决定当前的元素是否被保留。
  > 2. map()方法这个方法是用来计算的，它需要的是一个计算者函数式接口，会根据重写方法中的执行结果修改当前被计算的元素的属性值。
  > 3. sort()方法这个方法是用来排序的，它需要的是一个排序者函数式接口，会根据重写方法中的排序规则来对被便利数组进行排序。
  > 4. 静态方法concat(stream1,stream2) 这个方法会合并两个流变为一个新流。
  > 5. distinct() skip() limit() 这些方法都是中间操作不过是做一些去重，跳过，限制等操作的方法。
  >
  > 下面的几个就是stream的终止操作
  >
  > 1. foreach()方法这个方法是用来循环便利的，他需要的是一个消费之函数式接口，会拿到被计算的集合中的每一个元素。
  > 2. find系列方法find系列方法中有如下如下内容，findFirst，findAny。其中findAny是并行流的，获取并行流的方法为.parallelStream()，并行流不保证输出出哪一条流中的的信息。
  > 3. match系列方法 match系列方法同样也是两个 分别为allmatch，anymatch 分别代表全部匹配与任意一个匹配，需要的是断言型函数式接口，也没啥好说的。
  > 4. 规约方法，reduce这个方法用来实现统计规约的，比如我们要对一个集合中的所有信息进行运算操作，这时候就可以使用规约。
  > 5. 聚合系列方法，这里面的方法共有两个分别是max与count。max则是根据比较器来选出其中比较器中条件最大的一条信息，而count则是统计总共多少信息。
  > 6. collect方法，这个方法可以说是集大成者，他主要是依附于Collectors中的工具方法来实现具体业务的主要功能是有两大类分别为搜集计算，以及stream转化为其他集合类。
  >
  > Filter的代码演示，就像上面我们所说想要过滤集合中的一些信息我们可以使用.filter方法
  >
  > ~~~java
  > public class Filter {
  >     public static void main(String[] args) {
  >         System.out.println("过滤前:");
  >         // 过滤出所有姓 刘 的中国人 并且要年龄大于18,首先我们先没过滤前的信息
  >         ListConstant.peoples.forEach(System.out::println);
  >         System.out.println("过滤后:");
  >         // 使用Stream去进行过滤操作我们不妨使用其中的.filter方法，它内部需要的是一个 判断者 函数式接口
  >         ListConstant.peoples.stream()
  >                 // 选出大于18岁的
  >                 .filter(people -> people.getAge() > 18)
  >                 // 选出中国的
  >                 .filter(people -> "CN".equals(people.getAddress()))
  >                 // 选出姓刘的
  >                 .filter(people -> people.getName().startsWith("刘"))
  >                 // 最后打印出来
  >                 .forEach(System.out::println);
  >     }
  > }
  > ~~~
  >
  > Map的代码演示，我们想要计算集合中的某些元素我们就要使用map方法了。
  >
  > ~~~java
  > public class Map {
  >     public static void main(String[] args) {
  >         // 现在我们要将所有人的国籍都修改为CN，这时候我们就要用到Map方法了，并且对于那些原本就是中国的我们就没必要修改了,可以在map里面加一个判断，当然也可以不加
  >         ListConstant.peoples.stream()
  >                 // 它需要的是一个计算者函数式接口，有参数有返回值，显然我们想要的是将原来的修改之后在放到集合里面这样正好，我们传入参数
  >                 // 为people对象，返回结果也是people对象
  >                 // 这里编辑器会推荐我们将map替换为peek，当然我们可以进行替换结果是没有什么区别的
  >                 .peek(people -> {
  >                     if (!"CN".equals(people.getAddress())) {
  >                         people.setAddress("CN");
  >                     }
  >                 })
  >                 .forEach(System.out::println);
  >     }
  > }
  > ~~~
  >
  > Sort的代码展示，sort方法是用来进行排序的，我们使用sort可以对任意可比较的泛型集合进行自定义规则比较
  >
  > ~~~java
  > public class Sort {
  >     public static void main(String[] args) {
  >         // 我们下面要对peoples集合进行按年龄排序，这时我们就要用.sort方法了这个方法需要的是一个比较者函数式接口，我们在里面可以
  >         // 编写自己的比较条件。
  >         ListConstant.peoples.stream()
  >                 // 在这里编辑器会推荐我们将lambda表达式替换为 Comparator.comparingInt,这个玩意是用来比较Int类型的正好
  >                 // 我们要比较的年龄也是int类型，然后我们就可以将每一个people的年龄对象给他它就会对此进行一一比较，效果和上面的方法
  >                 // 一模一样
  > //                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
  >                 .sorted(Comparator.comparingInt(People::getAge))
  >                 .forEach(System.out::println);
  >     }
  > ~~~
  >
  > 在stream中的中间操作中还有一小部分不是太常用的方法，他们通常是用来进行合并/去重/截取等等操作的我们就在这一个例子中将他们展示完得了。
  >
  > ~~~java
  > public class Other {
  >     public static void main(String[] args) {
  >         // 在stream流中有一部分不是太常用的方法，比如有合并流，截取流，跳过部分元素等等操作。
  >         List<String> str1 = new ArrayList<>();
  >         List<String> str2 = new ArrayList<>();
  > 
  >         str1.add("A"); str1.add("B"); str1.add("C"); str1.add("D");str1.add("A");
  > 
  >         str2.add("a"); str2.add("b"); str2.add("c"); str2.add("d");
  >         // 我们先要将str1 str2合并
  >         Stream<String> concat = Stream.concat(str1.stream(), str2.stream());
  >         // 先打印一下
  >         concat.forEach(System.out::print);
  >         System.out.println();
  >         // 去一下重复，并且跳过前两个元素，然后在只截取两个元素，当我们执行这个代码的时候会发现，虽然上面的便利打印出来了但是，
  >         // 下面的却报错了，这是因为stream流的一个特性，也是我们下面要开始讲的stream的终止操作，不过我们现在只要知道被终止的
  >         // 流是无法继续执行任何操作的，想要进行则只能创建一个新流,就比如下面一行的代码
  >         Stream<String> concat1 = Stream.concat(str1.stream(), str2.stream());
  >         concat1.distinct().skip(2).limit(2).forEach(System.out::print);
  >     }
  > }
  > ~~~
  >
  > foreach方法这个太熟悉了呀，我们之前便利流用到的都是这个方法，它内部需要被实现的是一个消费者接口，它可以从集合中取出每一个元素供我们消费，通常都是用它来进行循环便利操作。这个方法就不放代码展示了因为每个案例都有它的身影。
  >
  > find系列方法，这个方法系列中就两个一个findFirst，寻找第一条流信息。findAny，寻找任意一条并行流中的单条流信息，其实这俩也没啥好说的能用到自然就用到了也没啥特殊的语法格式。
  >
  > ~~~java
  > public class Find {
  >     public static void main(String[] args) {
  >         ListConstant.peoples.forEach(System.out::println);
  >         // 打印出这个流信息中的第一条，我们会发现正好就是这个列表中的第一条记录
  >         System.out.println(ListConstant.peoples.stream().findFirst().get());
  >         System.out.println("");
  >         // 但是若我们使用并行流并且调用findAny方法,此时就发现输出的并不是第一条list记录了，因为并行流并不保证你输出的是
  >         // 那一条记录
  >         System.out.println(ListConstant.peoples.parallelStream().findAny().get());
  >         System.out.println("");
  >         // 如果我们在这使用并行流来打印List中的记录，并且打印出当前线程信息我们就会就会发现，确实是不同的线程在打印当前的流信息
  >         // 并且输出的顺序也是随机的
  >         ListConstant.peoples.parallelStream().forEach(e->{
  >             System.out.println("当前线程为："+Thread.currentThread().getName());
  >             System.out.println(e);
  >         });
  >     }
  > }
  > ~~~
  >
  > match系列方法，分别为matchAny 匹配任意，matchAll匹配全部这俩分别代表着匹配任意一条与全部匹配，任意匹配就是但凡有一个满足这个条件就返回true，而匹配全部就要求全部都要满足条件。
  >
  > ~~~java
  > public class Match {
  >     public static void main(String[] args) {
  >         // 判断集合中的年龄是否全部都大于18
  >         System.out.println(ListConstant.peoples.stream().allMatch(people -> people.getAge() > 18));
  >         // 判断集合中的年龄是否有大于18的
  >         System.out.println(ListConstant.peoples.stream().anyMatch(people -> people.getAge() > 18));
  >     }
  > }
  > ~~~
  >
  > 聚合系列方法，count与max。也是没啥好说的分别是统计所有条目信息与按照条件挑选出一条最大的信息
  >
  > ~~~java
  > public class Poly {
  >     public static void main(String[] args) {
  >         // count用来统计共有多少条记录。
  >         System.out.println(ListConstant.peoples.stream().filter(people -> people.getAge()>18).count());
  >         // max则是根据内部的比较条件来判断出来返回最大的流条目信息,我们看定义的信息确实赵灸的年龄是最大的
  >         System.out.println(ListConstant.peoples.stream().max(Comparator.comparingInt(People::getAge)));
  >     }
  > }
  > ~~~
  >
  > Reduce 它的语法规范是有一点点特别。 lambda表达式的参数有两个 t1,t2其中第一次赋值时候会取两个值分别给t1 t2然后我们在计算完毕的时候他会吧返回 值重新赋值给t1 然后在取下一个值给t2然后我们继续拿着之前运算的结果与新取到的值进行运算循环以此知道取到最后一个。所以/这个规约操作比较适合进行和 积运算。
  >
  > ~~~java
  > public class Reduce {
  >     public static void main(String[] args) {
  >         // 规约操作，这个方法是用来实现统计规约的，比如我们要对一个集合中的所有信息进行运算操作，这时候就可以使用规约，它的语法规范是有
  >         // 一点点特别 lambda表达式的参数有两个 t1,t2其中第一次赋值时候会取两个值分别给t1 t2然后我们在计算完毕的时候他会吧返回
  >         //  值重新赋值给t1 然后在取下一个值给t2然后我们继续拿着之前运算的结果与新取到的值进行运算循环以此知道取到最后一个。所以
  >         // 这个规约操作比较适合进行和 积运算
  > 
  >         // 就像下面的操作我们吧所有人的年龄进行了累计操作并且重新放到了第一个人的身上
  >         Stream<People> stream = ListConstant.peoples.stream();
  >         System.out.println(
  >                 stream.reduce((people, people2) -> {
  >                     people.setAge(people.getAge() + people2.getAge());
  >                     return people;
  >                 }).get());
  >     }
  > }
  > ~~~
  >
  > collect方法，这个方法可以说是Stream流操作中的大头方法了，主要是是依赖于Collections工具类    中的方法来进行一系列操作，大致可以分为两类分别是对集合中的元素进行运算操作，以及对流的搜集操作(转化为一个新的集合，    比如 Set，Map，List)等
  >
  > ~~~java
  > public class Collect {
  >     public static void main(String[] args) {
  >         /* 搜集方法这个方法可以说是Stream流操作中的大头方法了，主要是是依赖于Collections工具类
  >             中的方法来进行一系列操作，大致可以分为两类分别是对集合中的元素进行运算操作，以及对流的搜集操作(转化为一个新的集合，
  >             比如 Set，Map，List)等
  >          */
  >         // 首先我们就来先展示一下其中的对集合元素进行的操作
  >         // 比如这个 根据数组中的人们国家进行分组，显然我们在collect中调用了Collectors的分组方法并且根据国家进行分组即得到了分组好的map
  >         Map<String, List<People>> collect = ListConstant.peoples.stream().collect(Collectors.groupingBy(People::getAddress));
  >         collect.forEach((s, people) -> {
  >             System.out.println("国家"+s);
  >             System.out.println(people);
  >         });
  >         // 像这个方法就会根据我们给他的值来计算出平均值
  >         Double collect1 = ListConstant.peoples.stream().collect(Collectors.averagingInt(People::getAge));
  >         System.out.println(collect1);
  >         // 当然这里也有求最值的一系列方法，根据一些条件求最大最小值，其实我们并没有必要使用这个方法因为idea也会提醒我们可以替换为max就行了
  >         System.out.println(ListConstant.peoples.stream().collect(Collectors.maxBy(Comparator.comparingInt(People::getAge))));
  >         // 这里也是没必要用summingInt可以使用mapToInt中的sum方法也是一样的效果
  >         System.out.println(ListConstant.peoples.stream().collect(Collectors.summingInt(People::getAge)));
  >         System.out.println((Integer) ListConstant.peoples.stream().mapToInt(People::getAge).sum());
  >         // 最后剩下的就是讲流转变成另外一种集合了,其实这里转变为map确实 有点难懂，不过我们仔细看一下也就能发现，他这个toMap方法是要两个参数，
  >         // 两个计算型接口分别作为Map的key与Value所以我们就吧people的名字作为key，people对象作为value
  >         Map<String, People> collect2 = ListConstant.peoples.stream().collect(Collectors.toMap(People::getName, people -> people));
  >         System.out.println(collect2);
  >         // 转换为set，List都是一个套路没啥好说的,当然idea也会感觉我们这样的操作十分的冗余推荐我们直接换成List Set  的构造方法
  >         System.out.println(new HashSet<>(ListConstant.peoples));
  >         System.out.println(new ArrayList<>(ListConstant.peoples));
  > 
  >         System.out.println(ListConstant.peoples.stream().collect(Collectors.toSet()));
  >         System.out.println(ListConstant.peoples.stream().collect(Collectors.toList()));
  >     }
  > ~~~
  >

### 七.LocalDate线程安全时间工具类

- 我们在使用传统的时间类的时候会发现他们的规则制定的非常的紊乱以至于我们无论是创建时间对象还是使用其中的工具方法都有很大的缺陷比如并发情况下的线程安全问题。所以在jdk1.8中官方开发人员重构了原本的时间类然后创建了一套新的时间格式化类，就是LocalDate系列类，当然他也提供了时间格式化的工具方法。我们下面就来简单介绍一下这个类的常用api。

  > 首先这个类的创建和常规的类不一样他并不能使用new 调用构造方法的方式去创建而是使用LocalDate.now或者LocalDate.of(年，月，日)的方法来创建出一个LocalDate对象。
  >
  > 然后可以使用其中的一些实例方法来获取时间的具体信息比如今天是周几，今天是几月，今天是本月的那一天等等等等获取细小时间的方法。
  >
  > 剩下的就是时间的格式成字符串以及字符串解析成LocalDate对象的方法了。分别是通过LocalDate的实例方法format传入时间对象以及时间的格式化对象DateTimeFormater，然后对于时间字符串的解析是通过调用LocalDate的静态方法.parse传入时间字符串以及时间格式化对象来解析为时间类。
  >
  > ~~~java
  > public class LocalDateDemo {
  >     public static void main(String[] args) {
  >         // 创建时间类的两种方法
  >         LocalDate localDate = LocalDate.now();
  >         LocalDate localDate1 = LocalDate.of(2022,11,7);
  >         System.out.println(localDate);
  >         System.out.println(localDate1);
  >         // 这三个方法分别是获取年月日的工具方法
  >         System.out.println("年份："+localDate.getYear()+"，月份："+localDate.getMonthValue()+"，日："+localDate.getDayOfMonth());
  >         // 那么剩下的就是日期的格式化转字符串与字符串解析成时间的工具方法了
  >         // 首先我们要创建时间的格式化对象,他和SimpleDateFormat一样都是创建一个格式化地址
  >         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  >         // 然后我们在调用LocalDate中的实例方法传入这个dtf对象就能将时间格式化成字符串
  >         String format = localDate.format(dtf);
  >         System.out.println(format);
  >         // 那么对于时间字符串解析成LocalDate实例则还是需要调用LocalDate的静态方法传入时间字符串然后传入解析格式
  >         LocalDate time = LocalDate.parse("2019/07/13",dtf);
  >         System.out.println(time);
  >         //对于这个方法他还有一个兄弟类LocalDateTime,他相较于LocalDate多出来了时分秒这三个,他的使用方法与localData如出一辙
  >         LocalDateTime localDateTime = LocalDateTime.now();
  >         LocalDateTime localDateTime1 = LocalDateTime.of(2019,7,13,12,30,30);
  >         // 获取时间具体信息
  >         System.out.println(localDateTime.getYear());
  >         System.out.println(localDateTime.getMonth().getValue());
  >         System.out.println("本月的第" + localDateTime.getDayOfMonth() + "天，本周" + localDateTime.getDayOfWeek() + "天，本年的第" + localDateTime.getDayOfYear()+"天");
  >         //  时间的格式化
  >         DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  >         String format1 = localDateTime.format(dtf1);
  >         System.out.println(format1);
  >         System.out.println(LocalDateTime.parse("2001-07-13 12:30:30",dtf1));
  >     }
  > }
  > 
  > ~~~

