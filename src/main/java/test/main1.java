package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;


@Slf4j
public class main1 {




    public static void main(String[] args) throws InterruptedException {

//        new ThreadPoolExecutor(10,100,60,TimeUnit.MILLISECONDS,new SynchronousQueue(),new ThreadPoolExecutor.AbortPolicy());

        System.out.println(Runtime.getRuntime().availableProcessors());

    }

}
