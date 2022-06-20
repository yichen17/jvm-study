package com.yichen.jvmstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/6/20 8:52
 * @describe jvm测试 controller
 * 相关文章  =>   https://sematext.com/blog/java-lang-outofmemoryerror/
 *
 */
@RestController
@Slf4j
public class JvmController {

    /**
     * 栈溢出场景以  对空间溢出
     * -Xms50m -Xmx50m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./heapdump.dump
     * @return
     */
    @GetMapping("/sof1")
    public String stackOverFlow(){
        log.info("sof1");
        Map<Long, Long> map = new HashMap<>();
        for (long i = 0l; i < Long.MAX_VALUE; i++) {
            map.put(i, i);
        }
        return "ok";
    }

    /**
     * 创建很多线程，   java.lang.OutOfMemoryError: unable to create native thread
     * hs_err_pid22055.log  此时不会生成 dump文件
     * 可以通过  -XX:ErrorFile=/var/log/java/java_error%p.log   指定
     * -Xms50m -Xmx50m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./heapdump.dump
     */
    @GetMapping("/tl")
    public void threadLimits(){
        log.info("tl");
        while (true) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000 * 60 * 60 * 24);
                            } catch (Exception ex) {}
                        }
                    }
            ).start();
        }
    }

}
