package org.geekbang.thinking.in.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @description:
 * @author: LiuHu
 * @create: 2020/9/25
 **/
public class ApplicationListenerDemo4 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 将引导类 ApplicationListenerDemo 作为 Configuration Class
        context.register(MyApplicationListener.class);

        // 启动 Spring 应用上下文
        context.refresh(); // ContextRefreshedEvent
        // 启动 Spring 上下文
        context.start();  // ContextStartedEvent
        // 停止 Spring 上下文
        context.stop();  // ContextStoppedEvent
        // 关闭 Spring 应用上下文
        context.close(); // ContextClosedEvent
    }

    static class MyApplicationListener implements ApplicationListener<ApplicationContextEvent> {

        @Override
        public void onApplicationEvent(ApplicationContextEvent event) {
            println("MyApplicationListener - 接收到 Spring 事件：" + event);
        }
    }


    private static void println(Object printable) {
        System.out.printf("[线程：%s] : %s\n", Thread.currentThread().getName(), printable);
    }
}
