### 动态代理 JDK版本

1.动态代理机制中，有两个重要的类和接口，一个是`InvocationHandler`接口，一个是`Proxy`类，他们是动态代理所必须的！

1.每个动态代理都要实现`InvocationHandler`

2.每个代理都有一个handler

3.我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用

**解析**

1.public Object invoke(Object object, Method method, Object[] args)  invoke有三个参数

proxy:指代我们所代理的那个真实对象

method:指代的是我们所要调用真实对象的某个方法的Method对象

args:指代的是调用真实对象某个方法时接受的参数

**Proxy作用** 

Proxy这个类的作用就是用来动态创建一个代理对象的类 他的newProxyInstance 这个方法：

public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException

`loader`:一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载 一般都是系统加载器！

`interfaces`:代理对象需要实现的接口，可以同时指定多个接口

`h`:方法调用的实际处理者，代理对象的方法都会转发到这

`newProxyInstance()会返回一个实现了指定接口的代理对象，对该对象的所有方法调用都会转发给InvocationHandler.invoke()方法。理解上述代码需要对Java反射机制有一定了解
`
**神奇的地方**

1.代理对象是在程序运行时产生的，而不是编译期

2.对代理对象的所有接口方法调用都会转发到InvocationHandler.invoke()方法，在invoke()方法里我们可以加入任何逻辑，
比如修改方法参数，加入日志功能、安全检查功能等；之后我们通过某种方式执行真正的方法体，示例中通过反射调用了Hello对象的相应方法，还可以通过RPC调用远程方法。

        Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，它并不是我们的InvocationHandler类型，
        也不是我们定义的那组接口的类型，而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号
        
        ----------------------注意
        
        注意1：对于从Object中继承的方法，JDK Proxy会把hashCode()、equals()、toString()这三个非接口方法转发给InvocationHandler，
        其余的Object方法则不会转发。
        
**代码解析**

![整体流程](https://raw.githubusercontent.com/qiurunze123/imageall/master/proxy.png)


**输出结果分析**

![整体流程](https://raw.githubusercontent.com/qiurunze123/imageall/master/proxy1.png)

    proxy.getClass().getClassLoader(): sun.misc.Launcher$AppClassLoader@18b4aac2
    realSub.getClass().getClassLoader(): sun.misc.Launcher$AppClassLoader@18b4aac2
    
    都为系统加载器 无所谓那个加载
    
    com.sun.proxy.$Proxy0 说明动态的生成了一个新的对象 
