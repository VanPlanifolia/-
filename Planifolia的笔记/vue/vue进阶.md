### 序

- vue相关的基础知识我们之前已经学习过了，不过之前学习vue仅仅是为了写ssm项目而学的，仅仅学习了如何使用vue来展示后端传递过来的数据，替代掉传统的jsp页面。从而实现基础的前后端分离。但是现在的开发趋势更加注重的是纯粹的前后端分离，也就是前端项目和后端项目不在同一个服务器运行，前端只管展示数据，后端只管提供数据，那么我们之前学习的内容就有点不够用了，所以从今天开始我们对vue进行更近一步的学习。

### 第一章 快速搭建Vue项目

- 虽然说起来是要快速搭建vue项目，但是我们目前是没有运行环境的所以我们先是要准备运行环境的，就像我们后端服务的运行环境是tomcat，前端的就是node.js。首先我们就要先把vue项目所需要的运行环境搭建好。

#### 1.安装vue项目所需要的环境

- 按照常理来说我们的前端代码其实是只能运行再浏览器中的，因为浏览器中内置的引擎才能解析html/js代码，但是后来有一个人把chrome浏览器中的内核引擎移植了过来并且对其进行了优化，让js代码能够脱离浏览器运行。所以我们想要让js代码脱离浏览器运行首先就是要安装node.js。

  > node.js安装并不复杂我们只要去官网下载对应的安装包并且一路next就ok了它甚至会自动帮我们配置环境变量，让我们安装了就能直接使用。
  >
  > 官网地址:https://nodejs.org/zh-cn/
  >
  > 然后我们选择长期维护版本下载就ok了
  >
  > ![1669017120936](vue%E8%BF%9B%E9%98%B6.assets/1669017120936.png)
  >
  > 下载完毕之后，就双击打开一直下一步就能完成安装了。想要检验你是否安装成功可以打开cmd，输入node，若成功进入node控制台并且输出了版本就证明我们安装成功了。
  >
  > ![1669017526785](vue%E8%BF%9B%E9%98%B6.assets/1669017526785.png)

- 我们现在仅仅只是安装了一个node.js运行环境，如果想要再node上面安装其他的插件还需要一个东西，npm，这个玩意其实就和我们之前用的maven差不多用来管理插件以及依赖信息的，需要注意的是现在安装完毕node.js之后会自动带上nmp，只需要cmd中输入npm -v 若输出了版本信息就证明安装成功。

  ![1669017582177](vue%E8%BF%9B%E9%98%B6.assets/1669017582177.png)

- 我们有了运行环境，那么就要开始创建项目了。但是vue项目非常的复杂我们肯定不可能手动去创建项目，vue官方自然为我们提供了一个创建项目的脚手架 “vuecli” 我们只要再电脑上安装vuecli，它就会给我们提供一个创建项目的工具，我们只要做简单的配置就可以生产一个vue项目了。

  安装的流程也很简单打开cmd，输入 然后等待即可

  npm install -g @vue/cli

  但是因为源的原因这个安装可能非常的缓慢，若有条件的可以打开代理并且设置全局模式然后等待下载完毕，或者设置下载源为淘宝的 依次执行下面俩命令即可

  npm config set registry https://registry.npm.taobao.org

  npm install -g @vue/cli

  同样安装完毕之后cmd输入 vue --version 即可检验是否安装成功

  ![1669018196991](vue%E8%BF%9B%E9%98%B6.assets/1669018196991.png)

- 然后我们输入vue ui，看是否能启动vuecli创建项目的工具界面，若可以就证明所有准备工作已经完成可以创建项目了。

#### 2.使用vuecli脚手架创建一个项目

- 上一小节我们已经搭建好了vue脚手架并且进入了创建项目的页面，下面我们就使用这个工具来创建一个vue项目。

  > 首先我们进入页面之后进入创建模块，此时我们会看到它是可以选择文件夹的我们在第一行输入要创建的根目录然后回车，就相当于选择了要创建项目的文件夹，选择完毕之后点击最下面的在此处创建新项目即可。
  >
  > ![1669019342991](vue%E8%BF%9B%E9%98%B6.assets/1669019342991.png)
  >
  > 然后进入到下面这个页面，我们在这可以选择使用git进行管理，没啥好说的继续下一步。
  >
  > ![1669019421668](vue%E8%BF%9B%E9%98%B6.assets/1669019421668.png)
  >
  > 下一步这个页面我们就要注意了我们在这要选择，手动配置项目预设，使用这个创建一次项目之后就会保存到vue中了，我们下次只要选择这个即可。
  >
  > ![1669019714997](vue%E8%BF%9B%E9%98%B6.assets/1669019714997.png)
  >
  > 继续来到下一步，这页需要我们打开两个按钮关闭一个按钮，打开的是Router，以及使用配置文件这俩，需要关闭的是Linter/Format。然后就可以下一步了
  >
  > ![1669019922319](vue%E8%BF%9B%E9%98%B6.assets/1669019922319.png)
  >
  > 还有要注意的是我们下一步中一定要选中vue2，vue3更新了大量的新语法，我也不会所以只能使用vue2
  >
  > ![1669020408576](vue%E8%BF%9B%E9%98%B6.assets/1669020408576.png)
  >
  > 然后它会让你保存你的新预设，你可以给他设置一个预设名字以方便下次直接使用。然后当你点击创建项目之后，你又要等挺长一段时间这取决于你的网速以及你电脑的性能，然后当他创建完毕之后会回到首页，你可以在首页中安装插件以及依赖等等信息。
  >
  > ![1669020457201](vue%E8%BF%9B%E9%98%B6.assets/1669020457201.png)
  >
  > 因为我们element以及axios是后面必用的所以在这就作为示例来安装这两个插件以及依赖。
  >
  > 首先是element-ui它是一个插件我们进入插件市场直接搜索并且安装就行了，点击左上角的添加新的插件，然后在这搜索element然后安装第一个即可，然后下个页面不做任何改动直接点下一步等待安装完毕即可。
  >
  > ![1669020724017](vue%E8%BF%9B%E9%98%B6.assets/1669020724017.png)
  >
  > 然后就是axios依赖，和element一样不过这里是进入依赖安装页面然后搜索axios运行依赖并且点击安装即可。
  >
  > ![1669020821893](vue%E8%BF%9B%E9%98%B6.assets/1669020821893.png)
  >
  > 到此处就算是完整的创建完毕了一个vue项目，但是虽然vuecli能创建项目但是无法在项目上做编辑操作，此时就需要我们另外一个工具了，前端代码编辑器。

#### 3.使用webstrom管理Vue项目

- 前端编辑器工具有许多，但是毕竟我们是搞后端的没必要使用专业的前端工具vscode，再加上hbuilderx这个软件它的难用大家是有目共睹。所以我们也不打算使用hbuilder。我们采用的是JetBrains公司提供的webstrom这个软件，这个软件界面和idea几乎完全一样更加容易我们上手。

  > 首先是通过webstrom打开刚才创建的vue项目，具体用法和idea一摸一样我在这就不多赘述了，左上角文件打开文件夹即可。
  >
  > 打开之后界面如下，左边一大堆文件夹我们放到下面在讲，首先我们要配置一下npm，虽然大概率会帮我们自动配置好。还是看一下吧
  >
  > ![1669021524752](vue%E8%BF%9B%E9%98%B6.assets/1669021524752.png)
  >
  > 在这个界面如下图片一样对照着选择你自己刚才安装好的node以及npm即可
  >
  > ![1669021631255](vue%E8%BF%9B%E9%98%B6.assets/1669021631255.png)
  >
  > 配置完了我们就来简单说一下左侧的项目列表到底代表着什么吧。其实我们能够使用得到的无外乎这四个文件夹。
  >
  > 1. 代表着vue项目的库文件夹，这个文件夹携带着所有需要的库资源，我们项目依赖的资源都在这里面，也就相当于我们Java中的外部依赖库。
  > 2. 代表着我们这个项目中的公共资源
  > 3. src则是我们我们存放源代码的地方，这个我们会在下面展开讲解。
  > 4. 代表着我们引入的依赖，我们可以在这安装插件并且使用npm指令来安装或者卸载依赖就相当于我们之前用的pom文件。
  >
  > ![1669021825138](vue%E8%BF%9B%E9%98%B6.assets/1669021825138.png)
  >
  > 然后对于src文件夹我们打开可以看到它有许多的子文件夹，这些子文件夹就是放我们写的代码的地方，
  >
  > 自上而下一共五个文件夹两个文件我们自上而下依次讲解一下。
  >
  > 1. assets：用来存放图片等资源文件的
  > 2. components：组件也就是来存放我们写的页面文件，不过通常在这放的都是一些可以重用的组件而不与router进行绑定
  > 3. plugins：存放插件代码
  > 4. router：用来配置页面间的路由信息这个非常重要我们后面会着重讲解
  > 5. views：这个也是存放页面文件，不过这里放的都是于router进行绑定的页面，也就是路由的跳转页面。
  > 6. App.vue：这个就是主页面相当于index.html，当然主页面也是可以配置的，我们可以进入main.js修改vue绑定的默认页面对象
  > 7. main.js：vue的核心js文件，在这里创建了唯一的vue对象
  >
  > ![1669022274924](vue%E8%BF%9B%E9%98%B6.assets/1669022274924.png)
  >
  > 

### 第二章 使用vue项目搭配springboot实现前后端分离

- 我们上一届学习了如何创建Vue项目并且使用webStrom进行管理，今天我们就会使用vue搭配springboot实现真正的前后端分离技术，首先在这之前我们要先把之前遗漏的一点内容讲解一下，vue页面间的路由功能以及其他页面组件的引入。

#### 1.Vue项目中的页面路由

- 我们下面就浅浅的演示一下vue中的router路由功能。首先我们吧app.vue中那些用不到的去掉先。然后我们创建了三个标签 router-link 用来设置路由请求连接，router-view 用来渲染路由请求内容

  ~~~vue
  <template>
  <div id="app">
  <!--    配置两个路由路径-->
   <router-link to="/home">主页</router-link>|
   <router-link to="/msg">消息</router-link>
  <!--    路由渲染标签，会渲染我们上面两个路由路径请求到的内容-->
   <router-view/>
  </div>
  </template>
  
  <style>
  #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  }
  </style>
  ~~~

  然后我们修改路由文件夹下的index.js代码，将我们上面创建的这两个请求关联上具体的页面

  ~~~js
  import Vue from 'vue'
  import VueRouter from 'vue-router'
  import HomeView from '../views/HomeView.vue'
  
  Vue.use(VueRouter)
  
  const routes = [
   // 路由绑定的方法1在上面使用import导入vue模组，然后在这使用{}配置
  {
   path: '/',// 代表请求路径
   name: 'home',// 代表导入模块的名字
   component: HomeView // 代表我们上面使用import导入的组件
  },
  {
   path: '/about',
   name: 'about',
   // route level code-splitting
   // this generates a separate chunk (about.[hash].js) for this route
   // which is lazy-loaded when the route is visited.
   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
   // 相较于第一种我还是喜欢这种导入，直接写成这样的形式 component: () => import('../views/msg') 括号内写要被导入的路径
  {
   path: '/msg',
   name: 'Msg',
   component: () => import('../views/msg')
  },
  {
   path: '/home',
   name: 'HomeInfo',
   component: () => import('../views/home')
  }
  ]
  
  const router = new VueRouter({
  routes
  })
  
  export default router
  ~~~

  对于msg于home文件就随便创建俩就行了，但是需要注意的是必须将标签写在 template 标签内部并且不能在内部直接写汉字必须使用其他标签包裹在放到template标签中

  ~~~vue
  <template>
  <div>HomeInfo</div>
  </template>
  
  <script>
  export default {
  name: "home"
  }
  </script>
  
  <style scoped>
  
  </style>
  ~~~

  然后我们再次访问项目，就会发现我们分别点击上面的俩按钮下面就会渲染出相应的页面内容。

#### 2.Vue项目中的页面引入

- 我们如果想要在一个页面中引入另外一个页面内容，我们在jsp中可以使用< jsp:include >标签，那么在vue中对页面引入进行了优化拓展，我们可以使用自定义标签的形式来实现页面引入，甚至还可以做到父子页面之间的数据传递。

  > ​	首先是如何在父页面中引入子页面，在vue中实现页面的引入是使用自定义标签的形式。大致可以分为三步。
  >
  > 1. 我们先要在父页面中的js代码中使用 import 导入被引用的组件
  >
  >    ~~~html
  >    <script>
  >    // 使用import将被引入的页面导入进来
  >    import main from './views/Main';
  >    // 然后在 export default {} 内部使用components注册组件
  >    </script>
  >    ~~~
  >
  > 2. 然后继续在js代码中注册自定义标签
  >
  >    ~~~html
  >    <script>
  >    export default {
  >      components: {
  >        // 自定义标签名:被引入的模块名
  >        Main: main
  >      },
  >        }
  >     </script>
  >    ~~~
  >
  > 3. 在父页面上添加我们刚才创建的自定义标签
  >
  >    ~~~html
  >        <Main/>
  >    ~~~
  >
  > 按照上面三部做就能够实现子页面内容引入了，但是若我想在引入子页面的同时给他传递过去数据要怎么办呢？，我们可以使用标签中的  v-bind=“” 属性来将数据传递到子页面中。
  >
  > 1. 首先我们先准备要传递过去的数据，在VueCli种我们定义数据需要使用一种新的语法格式
  >
  >    ~~~html
  >    <script>
  >    // 在cli中我们就不能使用之前的哪个 data：{}方法来定义数据了要使用 下面这种定义格式来定义数据
  >      data() {
  >        return {
  >          msg: {
  >            author: "czy",
  >            age: 18,
  >            address: "hn"
  >          },
  >        }
  >      },
  >    </script>
  >    ~~~
  >
  > 2. 使用v-bind将数据绑定到自定义属性中
  >
  >    ~~~html
  >    <!--    我们可以直接自定义属性并且使用v-bind将他绑定上我们下面刚才定义好的数据-->
  >        <Main :msg="msg"/>
  >    ~~~
  >
  > 3. 在子页面中取出传过来的数据
  >
  >    ~~~html
  >    <!--主页-->
  >    <template>
  >    <!--  然后在上面直接使用插值表达式来取数据-->
  >      <h1>这是主页面，传来的消息为：{{msg}}</h1>
  >    </template>
  >    
  >    <script>
  >    // 首先我们要在这里取出自定义标签属性中的内容 固定格式为 props:['属性名字']，当然这是一个数组我们可以传多个取多个
  >    export default {
  >      name: "Main",
  >      props:['msg']
  >    }
  >    </script>
  >    <style scoped>
  >    </style>
  >    ~~~
  >
  >    其实大多都是固定的语法格式，没有什么具体的业务逻辑用多了自然就熟悉了。

#### 3.在vue中请求调用后端接口

- 我们准备工作已经完全做好了，后端的单表增删改查接口我们也已经写好了，剩下的就是需要使用element组件加上vue实现对接口的请求以及数据展示就🆗了。

  > 首先我们在主页中先引入element的表格组件用来展示数据
  >
  > ~~~html
  > <template>
  >   <div id="app">
  >     <h2>用户信息</h2>
  >     <el-table
  >         :data="userSource"
  >         border
  >         style="width: 100%">
  >       <el-table-column
  >           fixed
  >           prop="id"
  >           label="id"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           prop="username"
  >           label="姓名"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           prop="address"
  >           label="地区"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           prop="age"
  >           label="年龄"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           fixed="right"
  >           label="操作"
  >       >
  >         <template slot-scope="scope">
  >           <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
  >           <el-button type="text" size="small">编辑</el-button>
  >         </template>
  >       </el-table-column>
  >     </el-table>
  >   </div>
  > </template>
  > 
  > <script>
  > export default {
  >   name: "Index",
  >   data() {
  >     return {
  >       // 用户的数据，需要请求才能获取
  >       userSource: []
  >     }
  >   },
  > }
  > </script>
  > <style scoped>
  > </style>
  > ~~~
  >
  > ​	此时我们运行已经能够看到展示数据的表格了但是此时还没有对应填充的数据，这些数据我们是要请求后端接口获取的所以我们还是要使用axios发送请求，但是现在的使用方法是和我们之前略有一点区别，我们要再main.js中的全局vue对象配置axios对象。然后在其他的页面中就可以直接使用this进行调用。具体代码如下
  >
  > main.js
  >
  > ~~~js
  > import Vue from 'vue'
  > import Index from './Index'
  > import router from './router'
  > import './plugins/element.js'
  > // 我们要在前端试试axios就需要main.js中挂载axios，首先是导入axios对应的包
  > import axios from "axios";
  > Vue.config.productionTip = false
  > // 将axios对象挂在到vue中的 http 属性上去，这样我们就可以在其他页面使用 http 作为 axios对象一样使用了,当日这个$后面的http是可以随意替换的
  > Vue.prototype.$http = axios
  > new Vue({
  >     router,
  >     render: h => h(Index)
  > }).$mount('#app')
  > 
  > ~~~
  >
  > index.html
  >
  > ~~~html
  > <script>
  > export default {
  >   name: "Index",
  >   data() {
  >     return {
  >       // 用户的数据，需要请求才能获取
  >       userSource: []
  >     }
  >   },
  >   created() {
  >     this.initPage()
  >   },
  >   methods: {
  >     initPage() {
  >       // 因为我们是挂在到创建的全局vue对象上的所以我们这里使用 this 来获取,然后我们post中的url需要写对应的接口真实访问地址
  >       this.$http.post("http://localhost:8080/user/all").then(resp => {
  >         console.log(resp.data.data)
  >       })
  >     },
  >   }
  > }
  > </script>
  > ~~~
  >
  > ​	然后我们发出一次请求就会发现控制台报错了，因为我们现在的项目并不是运行到同一个服务上的了，因为我们前后端分离了，前端有专门的服务器后端也有专门的服务器，所以就出现了请求的跨域问题，当然解决这个问题也是非常的简单，我们只要在后端代码加上一句注解或者配置类就可以解决跨域请求问题。
  >
  > ![1669104721692](vue%E8%BF%9B%E9%98%B6.assets/1669104721692.png)
  >
  > ​	解决方案1，在controller层上添加注解。@CrossOrigin 这个注解我们只要添加到对应的controller类上就能够解决跨域请求的问题非常的方便，当然这个注解也是可以进行一些配置的。
  >
  > 就比如下面这个，origin代表请求的源头，全部则使用*，第二个请求头全部同样也是*，第三个允许校验true为允许false为拒绝，第四个methods代表允许的请求方式
  >
  > @CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true",methods = RequestMethod.GET)
  >
  > 然后我们添加上去之久发现主页面就可以正常的发出请求了，当然若你认为这种方法比较的不灵活你完全可以使用配置类的形式进行配置，首先我们要把之前配置的注解删掉因为配置类和注解只能同时存在一个。然后再config包下创建配置类，然后粘贴进去下面的代码，这些代码也都是套路代码没啥好说的。
  >
  > ~~~java
  > @Configuration
  > public class RequestConfig {
  >     // 当前跨域请求最大有效时长。这里默认1天
  >     private static final long MAX_AGE = 24 * 60 * 60;
  > 
  >     @Bean
  >     public CorsFilter corsFilter() {
  >         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
  >         CorsConfiguration corsConfiguration = new CorsConfiguration();
  >         // 1 设置访问源地址
  >         corsConfiguration.addAllowedOrigin("*");
  >         // 2 设置访问源请求头
  >         corsConfiguration.addAllowedHeader("*");
  >         // 3 设置访问源请求方法
  >         corsConfiguration.addAllowedMethod("*");
  >         corsConfiguration.setMaxAge(MAX_AGE);
  >         // 4 对接口配置跨域设置
  >         source.registerCorsConfiguration("/**", corsConfiguration);
  >         return new CorsFilter(source);
  >     }
  > }
  > ~~~
  >
  > ​	既然已经解决了其他的所有问题，我们下面就对这个查询全部添加一个分页操作吧。还是使用element中的分页组件以及mp中自带的分页插件进行实现。
  >
  > ​	首先我们再主页面中添加分页的组件。添加完毕之后我们就是老一套了设置页码变化，页面大小变化的监听函数，以及再请求路径上添加参数实现分页查询
  >
  > ~~~html
  > <template>
  >   <div id="app">
  >     <h2>用户信息</h2>
  >     <el-table
  >         :data="userSource"
  >         border
  >         style="width: 100%">
  >       <el-table-column
  >           fixed
  >           prop="id"
  >           label="id"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           prop="username"
  >           label="姓名"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           prop="address"
  >           label="地区"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           prop="age"
  >           label="年龄"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           fixed="right"
  >           label="操作"
  >       >
  >         <template slot-scope="scope">
  >           <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
  >           <el-button type="text" size="small">编辑</el-button>
  >         </template>
  >       </el-table-column>
  >     </el-table>
  > 
  >     <!--  分页组件-->
  >     <div style="text-align: center">
  >       <el-pagination
  >           @size-change="handleSizeChange"
  >           @current-change="handleCurrentChange"
  >           :current-page="indexPage"
  >           :page-sizes="[2,5,7,10]"
  >           :page-size="pageSize"
  >           layout="total, sizes, prev, pager, next, jumper"
  >           :total="total">
  >       </el-pagination>
  >     </div>
  >   </div>
  > </template>
  > ~~~
  >
  > ​	下面就是添加两个页面大小改变以及页码改变的监听函数，以及修改请求路径拼接上参数即可
  >
  > ~~~html
  > <script>
  > export default {
  >   name: "Index",
  >   data() {
  >     return {
  >       // 用户的数据，需要请求才能获取
  >       userSource: [],
  >       // 页面默认大小
  >       pageSize: 5,
  >       // 总条数
  >       total: 0,
  >       // 当前页数
  >       indexPage: 1,
  >     }
  >   },
  >   created() {
  >     this.initPage()
  >   },
  >   methods: {
  >     initPage() {
  >       // 因为我们是挂在到创建的全局vue对象上的所以我们这里使用 this 来获取,然后我们post中的url需要写对应的接口真实访问地址
  >       this.$http.get("http://localhost:8080/user/all?pageSize=" + this.pageSize + "&pageIndex=" + this.indexPage).then(resp => {
  >         // 设置源数据
  >         this.userSource = resp.data.data.records
  >         // 设置总条目
  >         this.total = resp.data.data.total
  >       })
  >     },
  >     handleSizeChange(val) {
  >       // 设置页面大小
  >       this.pageSize = val
  >       // 刷新页面
  >       this.initPage()
  >     },
  >     handleCurrentChange(val) {
  >       // 设置当前页码
  >       this.indexPage = val
  >       // 刷新页码
  >       this.initPage()
  >     }
  >   }
  > }
  > </script>
  > ~~~
  >
  > ​	这样我们查询相关的功能就算是完成了，剩下的就是添加了，按照我们之前的习惯添加是要弹出一个添加框框的，然后我们在里面输入要添加的数据点击提交即可。首先我们要准备一个添加的弹出框，也是直接去element官网去粘贴一个就行。
  >
  > ~~~html
  > <!--弹出的添加框框-->
  >     <el-dialog title="添加用户" :visible.sync="addFlag">
  >       <el-form :model="userMsg">
  > 
  >         <el-form-item label="姓名">
  >           <el-input v-model="userMsg.username"></el-input>
  >         </el-form-item>
  > 
  >         <el-form-item label="地区">
  >           <el-input v-model="userMsg.address"></el-input>
  >         </el-form-item>
  > 
  >         <el-form-item label="年龄">
  >           <el-input v-model="userMsg.age"></el-input>
  >         </el-form-item>
  >       </el-form>
  >       <div slot="footer" class="dialog-footer">
  >         <el-button @click="addFlag = false">取 消</el-button>
  >         <el-button type="primary" @click="submitAdd()">确 定</el-button>
  >       </div>
  >     </el-dialog>
  > ~~~
  >
  > ​	然后我们要在data中为他创建一个用户信息对象，也就是我们上面使用：model绑定的userMsg，然后我们要写一个弹出方法用来控制这个弹出框的弹出，也就是添加按钮。海妖写一个提交的按钮负责发出添加请求并且关闭弹出框。
  >
  > ~~~html
  > <script>
  > export default {
  >   name: "Index",
  >   data() {
  >     return {
  >       // 用户的数据，需要请求才能获取
  >       userSource: [],
  >       // 页面默认大小
  >       pageSize: 5,
  >       // 总条数
  >       total: 0,
  >       // 当前页数
  >       indexPage: 1,
  >       // 添加框框的标记
  >       addFlag: false,
  >       // 用户的信息
  >       userMsg: {}
  >     }
  >   },
  >   created() {
  >     this.initPage()
  >   },
  >   methods: {
  >     initPage() {
  >       // 因为我们是挂在到创建的全局vue对象上的所以我们这里使用 this 来获取,然后我们post中的url需要写对应的接口真实访问地址
  >       this.$http.get("http://localhost:8080/user/all?pageSize=" + this.pageSize + "&pageIndex=" + this.indexPage).then(resp => {
  >         // 设置源数据
  >         this.userSource = resp.data.data.records
  >         // 设置总条目
  >         this.total = resp.data.data.total
  >       })
  >     },
  >     handleSizeChange(val) {
  >       // 设置页面大小
  >       this.pageSize = val
  >       // 刷新页面
  >       this.initPage()
  >     },
  >     handleCurrentChange(val) {
  >       // 设置当前页码
  >       this.indexPage = val
  >       // 刷新页码
  >       this.initPage()
  >     },
  >     // 弹出添加框的方法
  >     popSubmit() {
  >       this.addFlag = true
  >     },
  >     // 提交添加框的方法
  >     submitAdd() {
  >       this.$http.post("http://localhost:8080/user/add" , this.userMsg).then(resp => {
  >         if (resp.data.code === 200){
  >           this.$notify({
  >             title: '成功',
  >             message: '添加成功',
  >             type: 'success'
  >           });
  >         }else {
  >           this.$notify.error({
  >             title: '错误',
  >             message: '添加失败'
  >           });
  >         }
  >       })
  >       this.addFlag = false
  >     },
  >   }
  > }
  > </script>
  > ~~~
  >
  > ​	添加完成了我们要开始着手写修改，其实修改算是最难的操作了，因为我们在修改的同时还要完成原有数据的显示。但是其他的基本上和添加一模一样了，我们大可直接复制一套添加的代码粘贴上去，然后稍作修改即可。
  >
  > ​	首先是html代码没什么特殊的直接粘贴一套就完了
  >
  > ~~~html
  >  <!--修改的弹出框框-->
  >     <el-dialog title="修改用户" :visible.sync="modifyFlag">
  >       <el-form :model="userMsg">
  > 
  >         <el-form-item label="姓名">
  >           <el-input v-model="userMsg.username"></el-input>
  >         </el-form-item>
  > 
  >         <el-form-item label="地区">
  >           <el-input v-model="userMsg.address"></el-input>
  >         </el-form-item>
  > 
  >         <el-form-item label="年龄">
  >           <el-input v-model="userMsg.age"></el-input>
  >         </el-form-item>
  >       </el-form>
  >       <div slot="footer" class="dialog-footer">
  >         <el-button @click="modifyFlag = false">取 消</el-button>
  >         <el-button type="primary" @click="submitModify()">确 定</el-button>
  >       </div>
  >     </el-dialog>
  > ~~~
  >
  > 然后是绑定修改按钮以及数据回显方法，因为我们在上面的显示表格中点击修改的时候会将这一行的数据传递过来并且绑定到回显参数上
  >
  > ~~~js
  > // 弹出添加框的方法
  >     popModify(tempMsg) {
  >       this.userMsg = tempMsg
  >       this.modifyFlag = true
  >     },
  > ~~~
  >
  > 然后就是确定修改提交方法了，我们调用后台的修改接口并且把修改的数据作为参数传递过去
  >
  > ~~~js
  > // 提交添加框的方法
  >     submitModify() {
  >       this.$http.put("http://localhost:8080/user/modify" , this.userMsg).then(resp => {
  >         if (resp.data.code === 200){
  >           this.$notify({
  >             title: '成功',
  >             message: '修改成功',
  >             type: 'success'
  >           });
  >         }else {
  >           this.$notify.error({
  >             title: '错误',
  >             message: '修改失败'
  >           });
  >         }
  >       })
  >       this.modifyFlag = false
  >     },
  > ~~~
  >
  > 这样我们的修改就完成了，最后就剩下一个删除了删除是比较简单的我们只要在删除的地方把id传递过来然后根据id删除就ok了这里就直接粘代码了。
  >
  > ~~~html
  > <template>
  >   <div id="app">
  >     <div style="text-align: center">
  >       <el-button type="primary" @click="popSubmit()">添加一个</el-button>
  >     </div>
  >     <h2>用户信息</h2>
  >     <el-table
  >         :data="userSource"
  >         border
  >         style="width: 100%">
  >       <el-table-column
  >           fixed
  >           prop="id"
  >           label="id"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           prop="username"
  >           label="姓名"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           prop="address"
  >           label="地区"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           prop="age"
  >           label="年龄"
  >       >
  >       </el-table-column>
  >       <el-table-column
  >           fixed="right"
  >           label="操作"
  >       >
  >         <template slot-scope="scope">
  >           <el-button @click="popModify(scope.row)" type="text" size="small">修改</el-button>
  >           <el-button type="text" size="small" @click="remove(scope.row)">删除</el-button>
  >         </template>
  >       </el-table-column>
  >     </el-table>
  >     <!--  分页组件-->
  >     <div style="text-align: center">
  >       <el-pagination
  >           @size-change="handleSizeChange"
  >           @current-change="handleCurrentChange"
  >           :current-page="indexPage"
  >           :page-sizes="[2,5,7,10]"
  >           :page-size="pageSize"
  >           layout="total, sizes, prev, pager, next, jumper"
  >           :total="total">
  >       </el-pagination>
  >     </div>
  >     <!--弹出的添加框框-->
  >     <el-dialog title="添加用户" :visible.sync="addFlag" :before-close="dialogClose">
  >       <el-form :model="userMsg"  ref="addFrom">
  > 
  >         <el-form-item label="姓名">
  >             <el-input v-model="userMsg.username"></el-input>
  >         </el-form-item>
  > 
  >         <el-form-item label="地区">
  >           <el-input v-model="userMsg.address"></el-input>
  >         </el-form-item>
  > 
  >         <el-form-item label="年龄">
  >           <el-input v-model="userMsg.age"></el-input>
  >         </el-form-item>
  >       </el-form>
  >       <div slot="footer" class="dialog-footer">
  >         <el-button @click="addFlag = false">取 消</el-button>
  >         <el-button type="primary" @click="submitAdd()">确 定</el-button>
  >       </div>
  >     </el-dialog>
  > 
  >     <!--修改的弹出框框-->
  >     <el-dialog title="修改用户" :visible.sync="modifyFlag"  :before-close="dialogClose">
  >       <el-form :model="userMsg" ref="modifyFrom">
  > 
  >         <el-form-item label="姓名">
  >           <el-input v-model="userMsg.username"></el-input>
  >         </el-form-item>
  > 
  >         <el-form-item label="地区">
  >           <el-input v-model="userMsg.address"></el-input>
  >         </el-form-item>
  > 
  >         <el-form-item label="年龄">
  >           <el-input v-model="userMsg.age"></el-input>
  >         </el-form-item>
  >       </el-form>
  >       <div slot="footer" class="dialog-footer">
  >         <el-button @click="modifyFlag = false">取 消</el-button>
  >         <el-button type="primary" @click="submitModify()">确 定</el-button>
  >       </div>
  >     </el-dialog>
  >   </div>
  > </template>
  > 
  > <script>
  > export default {
  >   name: "Index",
  >   data() {
  >     return {
  >       // 用户的数据，需要请求才能获取
  >       userSource: [],
  >       // 页面默认大小
  >       pageSize: 5,
  >       // 总条数
  >       total: 0,
  >       // 当前页数
  >       indexPage: 1,
  >       // 添加框框的标记
  >       addFlag: false,
  >       // 修改的标记
  >       modifyFlag: false,
  >       // 用户的信息
  >       userMsg: {}
  >     }
  >   },
  >   created() {
  >     this.initPage()
  >   },
  >   methods: {
  >     initPage() {
  >       // 因为我们是挂在到创建的全局vue对象上的所以我们这里使用 this 来获取,然后我们post中的url需要写对应的接口真实访问地址
  >       this.$http.get("http://localhost:8080/user/all?pageSize=" + this.pageSize + "&pageIndex=" + this.indexPage).then(resp => {
  >         // 设置源数据
  >         this.userSource = resp.data.data.records
  >         // 设置总条目
  >         this.total = resp.data.data.total
  >       })
  >     },
  >     handleSizeChange(val) {
  >       // 设置页面大小
  >       this.pageSize = val
  >       // 刷新页面
  >       this.initPage()
  >     },
  >     handleCurrentChange(val) {
  >       // 设置当前页码
  >       this.indexPage = val
  >       // 刷新页码
  >       this.initPage()
  >     },
  >     // 弹出添加框的方法
  >     popSubmit() {
  >       this.addFlag = true
  >     },
  >     // 关闭清除
  >     dialogClose(){
  >       this.userMsg={}
  >       this.addFlag = false
  >       this.modifyFlag = false
  >     },
  >     // 提交添加框的方法
  >     submitAdd() {
  >       this.$http.post("http://localhost:8080/user/add", this.userMsg).then(resp => {
  >         if (resp.data.code === 200) {
  >           this.$notify({
  >             title: '成功',
  >             message: '添加成功',
  >             type: 'success'
  >           });
  >         } else {
  >           this.$notify.error({
  >             title: '错误',
  >             message: '添加失败'
  >           });
  >         }
  >       })
  >       this.addFlag = false
  >     },
  >     // 弹出添加框的方法
  >     popModify(tempMsg) {
  >       this.userMsg = tempMsg
  >       this.modifyFlag = true
  >     },
  >     // 提交添加框的方法
  >     submitModify() {
  >       this.$http.put("http://localhost:8080/user/modify", this.userMsg).then(resp => {
  >         if (resp.data.code === 200) {
  >           this.$notify({
  >             title: '成功',
  >             message: '修改成功',
  >             type: 'success'
  >           });
  >         } else {
  >           this.$notify.error({
  >             title: '错误',
  >             message: '修改失败'
  >           });
  >         }
  >       })
  >       this.modifyFlag = false
  >     },
  >     remove(row) {
  >       this.$http.delete("http://localhost:8080/user/remove?id=" + row.id).then(resp => {
  >         if (resp.data.code === 200) {
  >           this.$notify({
  >             title: '成功',
  >             message: '用户:'+row.username+'删除成功',
  >             type: 'success'
  >           });
  >           this.initPage()
  >         } else {
  >           this.$notify.error({
  >             title: '错误',
  >             message: '删除失败'
  >           });
  >         }
  >       })
  >     }
  > 
  >   }
  > }
  > </script>
  > <style scoped>
  > 
  > </style>
  > ~~~
  >
  > 至此增删改查就已经写完了，我们回发现其实和之前写的vue项目差别并不是很大只是有一些语法格式发生了改变我们写多了自然就记住了

### 第三章 使用JWT来解决登录验证

- 首先是为什么舍弃传统的session校验，我们在传统的项目中通常是 All In One 全部的内容都放到一个项目中，这种自然是没有任何问题我们放在session中也是方便存取，但是当我们现在使用前后端分离之后cookie，session会在第二次请求的时候失效。而且若我们使用了服务器集群，就算session有效我们也很难做到多台服务器之间的相互共享。这样我们就无法使用传统的session状态跟踪技术了。但是我们必然是要使用会话跟踪技术的不然许多东西是无法实现的。

  那么对于这个情况目前是提出了两个解决方案。第一种是session对象持久化，将用户的session数据存放到数据库中。这样我们每次执行操作的时候去查一下数据库看看持久层中是否有当前用户的数据信息，然后取出信息来实现会话跟踪。这样显然也是一种方案，但是这样无疑会造成后端大量的开销。

  所以现在比较主流的方案就是JWT（JSON WEB TOKEN）验证，当我们登录成功的时候会根据用户信息生成一个token，然后将token返回给前端，然后前端每次发出新的请求都会携带这个token。后端根据传递过来的token实现身份的验证。jwt就是这种解决方案的代表。

  ![1669193509090](vue%E8%BF%9B%E9%98%B6.assets/1669193509090.png)

#### 1.jwt的介绍以及结构

- json web token 是一种新型的跨域认证解决方案，当用户登录的信息校验成功的时候，它可以根据我们的用户信息以及加密手段生成一个token，每次前端发出请求的时候都会携带这个服务器生成的token，然后后端根据这个token后端进行校验若通过则证明用户确实已经登录过了允许访问。

- jwt大致可以分为三段，Header(头部) 固定的token头，Payload(荷载) 携带的用户信息，Signature(签名) 加密的方法。我们进入jwt的官网就能找到具体的示例。

  > 这是生成的token信息使用颜色分为了三部分
  >
  > ![1669194152786](vue%E8%BF%9B%E9%98%B6.assets/1669194152786.png)
  >
  > 其中红色就是Header头部，通常这些都是固定的信息
  >
  > ![1669194187727](vue%E8%BF%9B%E9%98%B6.assets/1669194187727.png)
  >
  > > 首先我们可以看到这里共有两个字段 `alg`代表着加密手段，`typ`则是令牌格式，这个头部信息我们一般都是按照这样写不会发生变化
  >
  > 紫色的是荷载数据，这里是用户给定的信息
  >
  > ![1669194230206](vue%E8%BF%9B%E9%98%B6.assets/1669194230206.png)
  >
  > > 紫色的荷载信息其中包括两部分一部分为系统提供的，jwt创建了七个字段供我们填写，当然我们可以可以自定义字段信息自定义的字段信息需要写成json的格式。
  > >
  > > ​	*系统自带的*
  > >
  > > - iss (issuer)：签发人
  > > - exp (expiration time)：过期时间
  > > - sub (subject)：主题
  > > - aud (audience)：受众
  > > - nbf (Not Before)：生效时间
  > > - iat (Issued At)：签发时间
  > > - jti (JWT ID)：编号
  > >
  > >   *自定义的*
  > >
  > > {	
  > >
  > > ​	"k1"："v1",
  > >
  > > ​	"k2" : "v2"
  > >
  > > }
  >
  > 蓝色的就是设定的加密信息等等
  >
  > ![1669194253217](vue%E8%BF%9B%E9%98%B6.assets/1669194253217.png)
  >
  > 这一段就是签名信息，是对前面的那些内容进行加密处理的防止token被篡改，这里唯一需要我们配置的就是加密的手段以及 密钥 ，这个密钥我们千万要记住我们再后面进行校验的时候是要用到这个密钥的。
  >
  > 当然这些东西我们再Java中都是可以使用方法手动进行配置的。

#### 2.在Java中引入Jwt

- 我们要在后端项目上使用jwt进行校验，其实也非常的简单无非就是引入maven依赖，编写配置类，然后再controller处理请求之前拦截并且执行token校验。

  > 我们在项目中引入任何一个东西首先都是要配置maven依赖。jwt的的依赖具体如下我们只要粘进pom文件即可
  >
  > ~~~xml
  > <!--        jwt-->
  >         <dependency>
  >             <groupId>com.auth0</groupId>
  >             <artifactId>java-jwt</artifactId>
  >             <version>3.11.0</version>
  >         </dependency>
  > ~~~
  >
  > 然后我们要开始写一个生成，解析token的工具类，在这个工具类中要根据传递过来的东西制作token，以及校验token是否合法，还有解析token中的信息
  >
  > ~~~java
  > public class JWTTool {
  >     private static final String KEY = "czy";
  > 
  >     /**
  >      * 根据传递过来的信息制作登录token
  >      *
  >      * @param userInfo 用户的信息
  >      * @return 生成的token
  >      */
  >     public static String generateToken(Map<String, String> userInfo) {
  >         // 固定的头格式
  >         Map<String, Object> headMap = new HashMap<>();
  >         headMap.put("alg", "HS256");
  >         headMap.put("typ", "JWT");
  >         // 创建日历实例，分别获取当前时间以及七天后的时间分别作为颁发日期于过期日期
  >         Calendar calendar = Calendar.getInstance();
  >         Date now = calendar.getTime();
  >         calendar.add(Calendar.DAY_OF_MONTH, 7);
  >         Date expired = calendar.getTime();
  >         // 创建token
  >         // 返回签名
  >         return JWT.create()
  >                 // 设置头信息为固定的
  >                 .withHeader(headMap)
  >                 // 设置主题，随便你
  >                 .withSubject("用户信息")
  >                 // 设置发布日期
  >                 .withIssuedAt(now)
  >                 // 设置过期日期
  >                 .withExpiresAt(expired)
  >                 // 设置自定义的信息也就是要保存的用户信息
  >                 .withClaim("userInfo", userInfo)
  >                 // 设置签名信息,签名密钥为上面定义的key
  >                 .sign(Algorithm.HMAC256(KEY));
  >     }
  > 
  >     /**
  >      * 校验token信息
  >      *
  >      * @param token 前端传递过来的token
  >      * @return 是否校验通过
  >      */
  >     public static boolean verifyToken(String token) {
  >         // tk解析验证器，需要指定加密方法以及签名信息
  >         JWTVerifier build = JWT.require(Algorithm.HMAC256(KEY)).build();
  >         // 调用方法对tk进行验证,若校验通过则返回真否则返回假证明校验不通过
  >         try {
  >             build.verify(token);
  >             return true;
  >         } catch (Exception e) {
  >             return false;
  >         }
  >     }
  > 
  >     /**
  >      * 解析出token中的用户自定义信息
  >      * @param token 传递过来的token
  >      * @return 解析出来的数据
  >      */
  >     public static Map<String, Object> analyzeToken(String token) {
  >         // 解析出token中的自定义信息并且转化为Map的形式
  >         return JWT.decode(token).getClaim("userInfo").asMap();
  >     }
  > }
  > 
  > ~~~
  >
  > 然后我们写一套用户登录的业务，里面需要查询数据库校验数据若通过则生成token并且通过公共的结果集返回给前端，若不通过则显示登录失败。分别我们需要写service，controller，dao。并且还是采用mp的无sql语句的形式编写。
  >
  > dao层
  >
  > ~~~java
  > @Mapper
  > public interface AccountDao extends BaseMapper<Account> {
  > }
  > 
  > ~~~
  >
  > service以及他的实现类
  >
  > ~~~java
  > public interface AccountService {
  >     Account getAccountByIdAndPwd(LoginVo loginVo);
  > }
  > 
  > @Service("accountService")
  > public class AccountServiceImpl implements AccountService {
  >     @Resource(name = "accountDao")
  >     AccountDao accountDao;
  > 
  >     @Override
  >     public Account getAccountByIdAndPwd(LoginVo loginVo) {
  >         return accountDao.selectOne(
  >                 new QueryWrapper<Account>()
  >                         .eq("accountid", loginVo.getAccountId())
  >                         .eq("accountpwd", loginVo.getAccountPwd())
  >         );
  >     }
  > }
  > ~~~
  >
  > controller中的方法调用以及ComResult的返回
  >
  > ~~~java
  > @RestController
  > @RequestMapping("/Account")
  > public class AccountController {
  > 
  >     @Resource(name = "accountService")
  >     private AccountService accountService;
  > 
  >     @RequestMapping("/login")
  >     public ComResult accountLogin(@RequestBody LoginVo loginVo) {
  >         // 调用dao层进行登录验证
  >         Account account = accountService.getAccountByIdAndPwd(loginVo);
  >         // 查看是否有执行结果，也就是按照条件看看是不是有这个人
  >         if (account != null) {
  >             // 若查到了将返回的用户信息封装成token返回
  >             Map<String, String> userInfo = new HashMap<>();
  >             userInfo.put("userInfo", account.toString());
  >             return new ComResult(2000, "成功", JWTTool.generateToken(userInfo));
  >         } else {
  >             // 没查到则直接返回mull
  >             return new ComResult(5001, "登录失败", null);
  >         }
  >     }
  > }
  > ~~~
  >
  > 然后我们开始着手前端的编写，对于vue项目我们所有的页面都需要渲染到主页面上的所以我们先要配置好页面文件。
  >
  > 1. 创建登录页面，登录页面没什么特别的就一个登录表单以及axios请求和返回值验证,若登录成功了我们则需要通过 `this.$router.push("/list")` 这个方法来实现跳转，因为再vue中没法直接使用原生js中的方法实现页面间的跳转所以就只能使用 this.$router.push()方法完成对相应页面的跳转。并且我们跳转的路径都是要再router文件夹下的js文件中进行配置的。
  >
  >    ~~~html
  >    
  >    <template>
  >      <el-form :model="loginMsg" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  >    
  >        <el-form-item label="账号" prop="id">
  >          <el-input type="text" v-model="loginMsg.accountId" autocomplete="off"></el-input>
  >        </el-form-item>
  >    
  >        <el-form-item label="密码" prop="pass">
  >          <el-input type="password" v-model="loginMsg.accountPwd" autocomplete="off"></el-input>
  >        </el-form-item>
  >    
  >        <el-form-item>
  >          <el-button type="primary" @click="submitForm()">提交</el-button>
  >        </el-form-item>
  >    
  >      </el-form>
  >    </template>
  >    
  >    <script>
  >    import axios from "axios";
  >    
  >    export default {
  >      name: "Login",
  >      data() {
  >        return {
  >          loginMsg: {}
  >        }
  >      },
  >      methods: {
  >        submitForm() {
  >          axios.post("http://localhost:8080/Account/login", this.loginMsg).then(resp => {
  >            if (resp.data.code === 2000){
  >              // 保存数九
  >              localStorage.setItem("userInfo", resp.data.data)
  >              // 弹出通知
  >              this.$notify({
  >                title: '成功',
  >                message: '登录成功',
  >                type: 'success'
  >              });
  >              // 成功后路由到index页码
  >              this.$router.push("/list")
  >            }else {
  >              this.$notify.error({
  >                title: '错误',
  >                message: '登录失败'
  >              });
  >            }
  >          })
  >        }
  >      }
  >    }
  >    </script>
  >    
  >    <style scoped>
  >    
  >    </style>
  >    ~~~
  >
  >    并且不仅需要配置跳转的路由还需要配置页面渲染的路由，因为我们页面都是通过主页面进行渲染的，并且我们希望在进入页面的时候直接进入登录页面所以我们就要把 ‘/’ 这个路径的路由配置成登录页面并且渲染到主页面上，首先就是要在主页面上添加标签 <router-view/> 然后再去配置router文件夹下的index.js，这样就分别配置了两个请求路径对应的页面
  >
  >    ~~~js
  >    onst routes = [
  >        // 跳转到登录的路由配置
  >      {
  >        path: '/',// 代表请求路径
  >        name: 'login',// 代表导入模块的名字
  >        component: () => import('../views/Login')
  >      },
  >        // 跳转到用户列表的路由配置
  >      {
  >        path: '/list',
  >        name: 'list',
  >        component:()=>import('../views/Index')
  >      }
  >    ]
  >    ~~~
  >
  >    ​	然后我们这样已经能实现登录成功并且跳转了，但是我们现在并没有做任何的拦截，也就是说我们直接访问list也是可以访问到响应的页面以及数据的，所以首先我们要在后端添加拦截器用来拦截未登录的请求。首先我们要创建一个拦截器类。在项目中创建 MyInterceptor 类让他继承HanderInterceptor，并且重写方法preHandle，在里面获取到请求头中的token信息，然后执行我们写在jwt工具类中的两个方法，校验。当满足的时候证明这个用户确实已经登录了允许访问。否则ruturn false，并且使用PrintWriter对象往前端推送一个json数据，表示用户未登录。
  >
  >    ~~~java
  >    public class MyInterceptor implements HandlerInterceptor {
  >        @Override
  >        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  >            // 拿到用户携带的token信息
  >            String token = request.getHeader("token");
  >            // 校验tk信息,tk不为空并且tk通过校验则允许继续访问
  >            if (!StringUtils.isEmpty(token)) {
  >                if (JWTTool.verifyToken(token)) {
  >                    return true;
  >                }
  >            }
  >            // 修改编码格式
  >            response.setContentType("application/json;charset=utf-8");
  >            // 否则我们使用PrintWriter对象向前端输出一个错误json，并且拒绝继续访问
  >            String json = JSON.toJSONString(new ComResult(5001, "用户未登录"));
  >            response.getWriter().print(json);
  >            response.getWriter().flush();
  >            response.getWriter().close();
  >            return false;
  >        }
  >    }
  >    
  >    ~~~
  >
  >    ​	然后再springboot项目中就和ssm项目不一样了无法使用xml文件进行配置只能使用配置类配置拦截器，所以我们创建一个springmvc配置类，实现对拦截器的配置。
  >
  >    ~~~java
  >    @Configuration
  >    public class MyMvcConfig implements WebMvcConfigurer {
  >    
  >        @Override
  >        public void addInterceptors(InterceptorRegistry registry) {
  >            //注册自己的拦截器,并设置拦截的请求路径
  >            //拦击所有的请求，但是允许登录的请求访问
  >    		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/Account/login");
  >        }
  >    }
  >    ~~~
  >
  >    ​	此时我们再次运行代码会发现，就算我们登录成功了也是无法进行跳转的这就是因为，我们虽然把数据存放到前端中了但是每次请求的时候并没有携带着他发出请求，所以我们还要再前端写一个拦截器用来拦截全部的前端请求，然后再发出请求之前都给他带上token，我们这个token是保存再前端localStorage所以我们也能直接给他取出来。并且这个玩意的失效日期是和我们设置的一致的。
  >
  >    ​	需要注意的是我们这里的拦截器要写在main.js中也就是全局vue那里
  >
  >    ~~~js
  >    // 配置前端拦截器，拦截每一个发出去的请求，都让他携带上token
  >    axios.interceptors.request.use(config=>{
  >        //  首先取出来存放再localStorage中保存的token信息
  >        const token = localStorage.getItem("userInfo");
  >        // 判单取出来的信息是否未空，不为的话就给给axios的headers对象中的token属性设置成我们取出来的token，然后返回修改后的config
  >        if (token){
  >            config.headers.token=token;
  >        }
  >        return config
  >    })
  >    ~~~
  >
  >    最后我们修改用户列表页面，当后端返回200的时候才允许访问否则路由跳转回登录页面。
  >
  >    ~~~html
  >    <template>
  >      <div id="app">
  >        <div style="text-align: center">
  >          <el-button type="primary" @click="popSubmit()">添加一个</el-button>
  >        </div>
  >        <h2>用户信息</h2>
  >        <el-table
  >            :data="userSource"
  >            border
  >            style="width: 100%">
  >          <el-table-column
  >              fixed
  >              prop="id"
  >              label="id"
  >          >
  >          </el-table-column>
  >          <el-table-column
  >              prop="username"
  >              label="姓名"
  >          >
  >          </el-table-column>
  >          <el-table-column
  >              prop="address"
  >              label="地区"
  >          >
  >          </el-table-column>
  >          <el-table-column
  >              prop="age"
  >              label="年龄"
  >          >
  >          </el-table-column>
  >          <el-table-column
  >              fixed="right"
  >              label="操作"
  >          >
  >            <template slot-scope="scope">
  >              <el-button @click="popModify(scope.row)" type="text" size="small">修改</el-button>
  >              <el-button type="text" size="small" @click="remove(scope.row)">删除</el-button>
  >            </template>
  >          </el-table-column>
  >        </el-table>
  >        <!--  分页组件-->
  >        <div style="text-align: center">
  >          <el-pagination
  >              @size-change="handleSizeChange"
  >              @current-change="handleCurrentChange"
  >              :current-page="indexPage"
  >              :page-sizes="[2,5,7,10]"
  >              :page-size="pageSize"
  >              layout="total, sizes, prev, pager, next, jumper"
  >              :total="total">
  >          </el-pagination>
  >        </div>
  >        <!--弹出的添加框框-->
  >        <el-dialog title="添加用户" :visible.sync="addFlag" :before-close="dialogClose">
  >          <el-form :model="userMsg" ref="addFrom">
  >    
  >            <el-form-item label="姓名">
  >              <el-input v-model="userMsg.username"></el-input>
  >            </el-form-item>
  >    
  >            <el-form-item label="地区">
  >              <el-input v-model="userMsg.address"></el-input>
  >            </el-form-item>
  >    
  >            <el-form-item label="年龄">
  >              <el-input v-model="userMsg.age"></el-input>
  >            </el-form-item>
  >          </el-form>
  >          <div slot="footer" class="dialog-footer">
  >            <el-button @click="addFlag = false">取 消</el-button>
  >            <el-button type="primary" @click="submitAdd()">确 定</el-button>
  >          </div>
  >        </el-dialog>
  >    
  >        <!--修改的弹出框框-->
  >        <el-dialog title="修改用户" :visible.sync="modifyFlag" :before-close="dialogClose">
  >          <el-form :model="userMsg" ref="modifyFrom">
  >    
  >            <el-form-item label="姓名">
  >              <el-input v-model="userMsg.username"></el-input>
  >            </el-form-item>
  >    
  >            <el-form-item label="地区">
  >              <el-input v-model="userMsg.address"></el-input>
  >            </el-form-item>
  >    
  >            <el-form-item label="年龄">
  >              <el-input v-model="userMsg.age"></el-input>
  >            </el-form-item>
  >          </el-form>
  >          <div slot="footer" class="dialog-footer">
  >            <el-button @click="modifyFlag = false">取 消</el-button>
  >            <el-button type="primary" @click="submitModify()">确 定</el-button>
  >          </div>
  >        </el-dialog>
  >      </div>
  >    </template>
  >    
  >    <script>
  >    export default {
  >      name: "Index",
  >      data() {
  >        return {
  >          // 用户的数据，需要请求才能获取
  >          userSource: [],
  >          // 页面默认大小
  >          pageSize: 5,
  >          // 总条数
  >          total: 0,
  >          // 当前页数
  >          indexPage: 1,
  >          // 添加框框的标记
  >          addFlag: false,
  >          // 修改的标记
  >          modifyFlag: false,
  >          // 用户的信息
  >          userMsg: {}
  >        }
  >      },
  >      created() {
  >        this.initPage()
  >      },
  >      methods: {
  >        initPage() {
  >          // 因为我们是挂在到创建的全局vue对象上的所以我们这里使用 this 来获取,然后我们post中的url需要写对应的接口真实访问地址
  >          this.$http.get("http://localhost:8080/user/all?pageSize=" + this.pageSize + "&pageIndex=" + this.indexPage).then(resp => {
  >            // 当返回的未200也就是正常登录的时候正常放入数据
  >            if (resp.data.code === 200) {
  >              // 设置源数据
  >              this.userSource = resp.data.data.records
  >              // 设置总条目
  >              this.total = resp.data.data.total
  >              // 否则弹出错误信息并且跳转
  >            }else {
  >              this.$notify.error({
  >                title: '错误',
  >                message: '请检查登录状态'
  >              });
  >              this.$router.push("/")
  >            }
  >          })
  >        },
  >        handleSizeChange(val) {
  >          // 设置页面大小
  >          this.pageSize = val
  >          // 刷新页面
  >          this.initPage()
  >        },
  >        handleCurrentChange(val) {
  >          // 设置当前页码
  >          this.indexPage = val
  >          // 刷新页码
  >          this.initPage()
  >        },
  >        // 弹出添加框的方法
  >        popSubmit() {
  >          this.addFlag = true
  >        },
  >        // 关闭清除
  >        dialogClose() {
  >          this.userMsg = {}
  >          this.addFlag = false
  >          this.modifyFlag = false
  >        },
  >        // 提交添加框的方法
  >        submitAdd() {
  >          this.$http.post("http://localhost:8080/user/add", this.userMsg).then(resp => {
  >            if (resp.data.code === 200) {
  >              this.$notify({
  >                title: '成功',
  >                message: '添加成功',
  >                type: 'success'
  >              });
  >            } else {
  >              this.$notify.error({
  >                title: '错误',
  >                message: '添加失败'
  >              });
  >            }
  >          })
  >          this.addFlag = false
  >        },
  >        // 弹出添加框的方法
  >        popModify(tempMsg) {
  >          this.userMsg = tempMsg
  >          this.modifyFlag = true
  >        },
  >        // 提交添加框的方法
  >        submitModify() {
  >          this.$http.put("http://localhost:8080/user/modify", this.userMsg).then(resp => {
  >            if (resp.data.code === 200) {
  >              this.$notify({
  >                title: '成功',
  >                message: '修改成功',
  >                type: 'success'
  >              });
  >            } else {
  >              this.$notify.error({
  >                title: '错误',
  >                message: '修改失败'
  >              });
  >            }
  >          })
  >          this.modifyFlag = false
  >        },
  >        remove(row) {
  >          this.$http.delete("http://localhost:8080/user/remove?id=" + row.id).then(resp => {
  >            if (resp.data.code === 200) {
  >              this.$notify({
  >                title: '成功',
  >                message: '用户:' + row.username + '删除成功',
  >                type: 'success'
  >              });
  >              this.initPage()
  >            } else {
  >              this.$notify.error({
  >                title: '错误',
  >                message: '删除失败'
  >              });
  >            }
  >          })
  >        }
  >    
  >      }
  >    }
  >    </script>
  >    <style scoped>
  >    
  >    </style>
  >    ~~~
  >
  >    至此我们的jwt就成功的引入到我们的vue+springboot项目中了，我们再写的过程中可以发现确实使用jwt之后就不在受到不同服务器影响了，因为token是保存在我们本地浏览器中的，我们在用的时候无论请求的是哪个服务器只要将请求头携带着token数据，并且服务器集群采用的加密解密方式相同就能识别出用户的登录状态。

#### 3.补充内容

- 我们使用jwt进行校验确实为我们提供了很大的方便，可以实现不同的服务器集群实现相同的登录状态校验，但是我们想能否将校验在前端也添加一份，当用户没有登录的时候直接让他跳转回去不再往后台发送请求。显然这种解决方案还减少了后台服务器的开销。在vue中我们可以使用前端路由守卫的方式来进行初步登录验证。

  > 我们只要在前端路由中进行一点配置就能实现具体的功能，主要的思路就是。从存放token信息的属性中取出token信息进行非空判断若为空则一定为未登录，让他跳转到登录页面。若不为空则让这个请求继续发送在后端进一步进行校验。
  >
  > 其中有一点需要注意的是，我们不能拦截掉所有的请求，就比如说有一些请求是允许不登陆访问的比如说登录请求，主页请求等等等。所以我们在拦截的同时还要放行一些内容。
  >
  > 具体代码就入下所示
  >
  > ~~~js
  > router.beforeEach(((to, from, next) => {
  >     // 获取到当前的路径信息
  >     const path = to.path;
  >     // 若请求为 / 也就是根路径请求，我们就直接放行
  >     if (path === '/'){
  >         return next();
  >     }
  >     // 否则我们要判断一波token是否为空，若为空则一定未登录让他返回登录页面
  >     if (localStorage.getItem("userInfo")){
  >         return next();
  >     }
  >     // 否则让他跳转为登录页面
  >     return next("/")
  > }))
  > ~~~
  >
  > 我们添加上之后回发现，确实我们在请求信息的时候若未登录则直接跳转回了登录页面没有发出任何请求。

### 番外 对VueCli项目的具体说明

- 因为这部分的内容学的也是很赶，第一天安装第二天就直接结束了。学的时候并没有太了解这个vuecli的具体结构，到今天重新看了一遍文档以及项目结构才算是大体了解了，具体的项目内容，所以在下面我们就来分享一下我的心得。并不一定准确仅作参考因为也没有系统的进行学习。

  > 首先还是创建一个新的项目来作为演示说明。对于项目的目录结构我不做具体的说明了，因为我在第一章节中准确的说明了具体文件夹的作用。
  >
  > 在这我们直接进入package.json文件，若你确实是使用WebStrom管理的vue项目那么我们就在这可以直接运行该项目，若你是其他软件我们则可以在控制台中输入相关指令才可以运行，首先若是在webStrom管理的项目我们即可直接点击package.json左侧的绿色箭头来运行。若没有这个箭头亦或是使用的其他软件我们可以执行下命令 `npm run serve`也可以运行该项目，但是 serve 这个单词回随着下图片中第刘行的配置而随之改变。
  >
  > 
  >
  > ![1669284670413](vue%E8%BF%9B%E9%98%B6.assets/1669284670413.png)
  >
  > 然后这是运行起来了我们进入输出的地址可以看到一个默认的网页，那么这个网页是如何默认显示并且渲染的呢？
  >
  > 首先我们要来看一下src包下的`main.js`文件，我们在上面当然也是说了这个文件是来定义全局的vue对象的，整个项目只创建了这一个vue对象，所以我们来看一下他创建的对象是绑定到哪个页面上的就知道默认打开的页面是谁了。
  >
  > ~~~js
  > import Vue from 'vue'
  > import App from './App.vue'
  > import router from './router'
  > import './plugins/element.js'
  > 
  > Vue.config.productionTip = false
  > 
  > new Vue({
  >   router,
  >   // 虽然我们不懂js 但是很显然这句话的意思就是将vue对象绑定到了上面导入的App.Vue文件上，也就是说所有页面的父页面都是App.vue，并其他的子页面都是被渲染到App.vue上面的
  >   render: h => h(App)
  > }).$mount('#app')
  > 
  > ~~~
  >
  > 根据上面的代码我们很显然的知道App.vue就是哪个真正的主页面，其他所有的页面都是渲染到主页面上的，然后我们打开App.vue继续从头到尾审视这个页面的内容，我把所有的内容都写在了下面读者可以自行阅读。
  >
  > ~~~html
  > <!--我们来简单的分析一下这个页面的具体信息-->
  > <!--
  >   首先第一点，所有的内容都是要写在<template>中的否则是不会起效的
  >   第二点，我们可以在<template>标签内部直接写html代码，这些常规的html回无条件的渲染到该页面上面
  > -->
  > <template>
  >   <div id="app">
  >     <img src="./assets/logo.png">
  >     <div>
  >       <p>
  >         If Element is successfully added to this project, you'll see an
  >         <code v-text="'<el-button>'"></code>
  >         below
  >       </p>
  >       <el-button>el-button</el-button>
  >     </div>
  > <!--    然后我们在这发现了一个不然是的标签，这个表明显然是自定义的，并且这个标签可以通过msg这个属性来设定一个信息，但是我们
  >     现在还不清楚这个msg可以干啥-->
  >     <HelloWorld msg="Welcome to Your Vue.js App"/>
  >   </div>
  > </template>
  > 
  > <script>
  > // 待到 发现js代码，显然我们在这调入了一个名为HelloWorld.vue的组件
  > import HelloWorld from './components/HelloWorld.vue'
  > // 并且我们在这使用Vue的模板中的一个属性 components 注册成了一个标签，并且这个标签的名字为HelloWorld，显然这就已经能对上号了，
  > // 我们在上面导入了HelloWorld.vue组件并且在这将他注册成了一个标签，然后我们在上面使用这个标签就可以吧这个页面渲染到当前的页面，很合理
  > export default {
  >   name: 'app',
  >   components: {
  >     HelloWorld
  >   }
  > }
  > </script>
  > 
  > <style>
  > #app {
  >   font-family: 'Avenir', Helvetica, Arial, sans-serif;
  >   -webkit-font-smoothing: antialiased;
  >   -moz-osx-font-smoothing: grayscale;
  >   text-align: center;
  >   color: #2c3e50;
  >   margin-top: 60px;
  > }
  > </style>
  > 
  > ~~~
  >
  > 然后我们不妨来继续看一下HelloWorld这个vue组件，目的就是想看一下msg这个标签属性到底可以干什么。我把中间那些没用的代码直接给去掉了这样看的更加的清晰。
  >
  > ~~~html
  > 首先同样的template标签，内容必须写在标签中
  > <template>
  >   <div class="hello">
  >       // 在这里他是使用了插值表达式来取到msg的值那么他在vue对象中比必定定义或者引用了了这个属性值
  >     <h1>{{ msg }}</h1>
  > </template>
  > 
  > <script>
  > export default {
  >   name: 'HelloWorld',
  >     // 然后在这里我发现，他是使用props:的形式引用了标签中缓缓传递过来的msg属性，当然还有一种更加便捷的引用方法
  >   props: {
  >     msg: String
  >   }
  >     // 这样也同样能实现从父页面中传递过来的信息
  >  //   props:['msg'],
  > }
  > </script>
  > ~~~
  >
  > 除去这种在主页面中引入其他页面的方式还有另外一种，就是通过路由进行引入，大家不妨可以试一下我们在不进行任何路由改动的情况下在App.vue这个文件的<div id="app">中添加一个
  >
  > <router-view/>标签回发生什么呢？我们在加入之后会发现，他在原本有内容的页面上直接又添加了许多东西，但是当我们在浏览器的地址栏输入其他内容这个添加进去的东西又会直接消失这是为什么呢？这就要扯到vue中的router文件夹下的index.js了。
  >
  > 这个文件是进行路由配置功能的，我们可以在里面对当前vue项目中的所有vue组件进行路由配置，通俗的说就是实现根据请求的地址从而选择出不同的页面，具体的配置方法以及注释可以详见下代码。
  >
  > ~~~JS
  > 
  > import Vue from 'vue'
  > import VueRouter from 'vue-router'
  > import HomeView from '../views/HomeView.vue'
  > 
  > Vue.use(VueRouter)
  > // 这里就是进行路由配置的地方了，我们可以在这配置浏览器的请求以及对应的页面内容
  > const routes = [
  >     // 首先创建路由关系有两种方式，这是第一种，我们需要在上面使用import把需要的页面先导入进来，然后以json的格式来关联请求路径与导入
  >     // 组件的关系
  >   {
  >     // 这个属性代表着请求路径
  >     path: '/',
  >     // 这个属性代表着名字可以随便设置
  >     name: 'home',
  >     // 这个属性代表上面的导入组件
  >     component: HomeView
  >   },
  >     // 这是第二种配置路由的方式，也是我喜欢的一种。
  >   {
  >     // 前两项和第一种没任何区别
  >     path: '/about',
  >     name: 'about',
  >     // 第三项使用下面格式进行导入，前面的代码是固定套路 component:()=>import('/被导入组件地址')
  >     component: () => import('../views/AboutView.vue')
  >   }
  > ]
  > 
  > const router = new VueRouter({
  >   routes
  > })
  > 
  > export default router
  > ~~~
  >
  > 这样配置我们就能将vue组件与浏览器的请求绑定要一起了，所以我们现在知道了如何将定义的vue组件绑定到请求上，那么我们下面就做一个小小的实验吧，将页面A,B绑定到请求ab上。
  >
  > 首先我们要创建AB这两个页面，并且让他随便显示点内容
  >
  > ~~~html
  > <template>
  >   {{ msg }}
  > </template>
  > 
  > <script>
  > export default {
  >   name: "A",
  >   // 在新版的vue项目中定义属性以及方法略有不同，定义属性需要按照下格式
  >   data() {
  >     return {
  >       mgs: "hello A"
  >     }
  >   },
  >   created() {
  >     alert("你好吗？")
  >   },
  >   // 方法还是原来的套路
  >   methods: {
  > 
  >   },
  > }
  > </script>
  > 
  > <style scoped>
  > 
  > </style>
  > ~~~
  >
  > ~~~html
  > <template>
  >   {{ msg }}
  > </template>
  > 
  > <script>
  > export default {
  >   name: "B",
  >   // 在新版的vue项目中定义属性以及方法略有不同，定义属性需要按照下格式
  >   data() {
  >     return {
  >       mgs: "hello B"
  >     }
  >   },
  >   // 方法还是原来的套路
  >   methods: {},
  > }
  > </script>
  > 
  > <style scoped>
  > 
  > </style>
  > ~~~
  >
  > 然后我们在路由js中绑定这两个页面与请求路径的绑定关系
  >
  > ~~~JS
  > 
  > import Vue from 'vue'
  > import VueRouter from 'vue-router'
  > import HomeView from '../views/HomeView.vue'
  > 
  > Vue.use(VueRouter)
  > // 这里就是进行路由配置的地方了，我们可以在这配置浏览器的请求以及对应的页面内容
  > const routes = [
  >     // 首先创建路由关系有两种方式，这是第一种，我们需要在上面使用import把需要的页面先导入进来，然后以json的格式来关联请求路径与导入
  >     // 组件的关系
  >     {
  >         // 这个属性代表着请求路径
  >         path: '/',
  >         // 这个属性代表着名字可以随便设置
  >         name: 'home',
  >         // 这个属性代表上面的导入组件
  >         component: HomeView
  >     },
  >     // 这是第二种配置路由的方式，也是我喜欢的一种。
  >     {
  >         // 前两项和第一种没任何区别
  >         path: '/about',
  >         name: 'about',
  >         // 第三项使用下面格式进行导入，前面的代码是固定套路 component:()=>import('/被导入组件地址')
  >         component: () => import('../views/AboutView.vue')
  >     },
  >     {
  >         path: '/A',
  >         name: 'A',
  >         component: () => import("../views/A")
  >     },
  >     {
  >         path: '/B',
  >         name: 'B',
  >         component: () => import("../views/B")
  >     }
  > ]
  > 
  > const router = new VueRouter({
  >     routes
  > })
  > 
  > export default router
  > 
  > ~~~
  >
  > 然后我们现在在进行请求就发现确实，实现了对这两个请求的不同页面渲染。其实综上我们vuecli中的新内容就这么多。
  >
  > 1. 单vue对象绑定主页面
  > 2. 子页面都需要渲染到主页面上
  > 3. 使用路由管理子页面与请求地址的关系

  

