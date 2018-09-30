package com.jinxing.chatroom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.Callable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatroomApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(248));
        Random random = new Random(47);
        int s = random.nextInt(33);
    }

    private class Abc implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }

    }

}
