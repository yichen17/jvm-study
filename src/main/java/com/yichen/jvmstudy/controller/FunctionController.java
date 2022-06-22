package com.yichen.jvmstudy.controller;

import com.yichen.jvmstudy.JvmStudyApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/6/22 9:33
 * @describe 功能性工具类
 */
@RestController
public class FunctionController {


    /**
     * 主要逻辑，通过 调用  refresh() 方法刷新
     * 参考  =>   https://stackoverflow.com/questions/39386168/programmatically-restart-spring-boot-application-refresh-spring-context
     */
    @RequestMapping("/reRun")
    public void reRun(){
        Thread restartThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                JvmStudyApplication.restart();
            } catch (InterruptedException ignored) {
            }
        });
        restartThread.setDaemon(false);
        restartThread.start();
    }

}
