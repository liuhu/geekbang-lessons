package org.geekbang.thinking.in.spring.event;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @description:
 * @author: LiuHu
 * @create: 2020/9/25
 **/
public class ApplicationListenerDemo2 {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        context.addApplicationListener(event -> {
            System.out.println("收到事件 " +  event);
        });

        context.refresh();
        context.close();
    }
}
