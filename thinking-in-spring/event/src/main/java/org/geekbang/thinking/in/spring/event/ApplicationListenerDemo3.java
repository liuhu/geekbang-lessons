package org.geekbang.thinking.in.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @description:
 * @author: LiuHu
 * @create: 2020/9/25
 **/
public class ApplicationListenerDemo3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 将引导类 ApplicationListenerDemo 作为 Configuration Class
        context.register(ApplicationListenerDemo3.class);

        // 启动 Spring 应用上下文
        context.refresh(); // ContextRefreshedEvent
        // 启动 Spring 上下文
        context.start();  // ContextStartedEvent
        // 停止 Spring 上下文
        context.stop();  // ContextStoppedEvent
        // 关闭 Spring 应用上下文
        context.close(); // ContextClosedEvent
    }

    @EventListener
    @Order(2)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        println("@EventListener(onApplicationEvent) - 接收到 Spring ContextRefreshedEvent");
    }

    @EventListener
    @Order(1)
    public void onApplicationEvent1(ContextRefreshedEvent event) {
        println("@EventListener(onApplicationEvent1) - 接收到 Spring ContextRefreshedEvent");
    }

    @EventListener
    @Async
    public void onApplicationEventAsync(ContextRefreshedEvent event) {
        println("@EventListener（异步） - 接收到 Spring ContextRefreshedEvent");
    }

    @EventListener
    public void onApplicationEvent(ContextStartedEvent event) {
        println("@EventListener - 接收到 Spring ContextStartedEvent");
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        println("@EventListener - 接收到 Spring ContextClosedEvent");
    }

    private static void println(Object printable) {
        System.out.printf("[线程：%s] : %s\n", Thread.currentThread().getName(), printable);
    }
}
