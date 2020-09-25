package org.geekbang.thinking.in.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: LiuHu
 * @create: 2020/9/25
 **/
public class ApplicationEventMulticasterDemo {

    @Autowired
    private ApplicationEventMulticaster applicationEventMulticaster;

    @PostConstruct
    private void init() {
        applicationEventMulticaster.multicastEvent(new ApplicationEvent("Hello!") {
        });
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationEventMulticasterDemo.class);

        // 1.添加自定义 Spring 事件监听器
        context.addApplicationListener(new MySpringEventListener());

        // 2.启动 Spring 应用上下文
        context.refresh();
        context.close();;
    }
}
