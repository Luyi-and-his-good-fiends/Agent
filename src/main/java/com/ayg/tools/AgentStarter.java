package com.ayg.tools;

import com.ayg.tools.exec.timer.ExeCmdBuilder;
import com.ayg.tools.exec.timer.ExecTimerTransformer;
import com.ayg.tools.exec.timer.cmds.IExeCmd;

import java.lang.instrument.Instrumentation;


/**
 *  代理程序入口类
 */
public class AgentStarter {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(AgentStarter.class);

    public static void premain(String args, Instrumentation instrumentation) {
        LOG.info("执行时长计数器开启,参数{}", args);
        try {
            IExeCmd exeCmd = ExeCmdBuilder.buildExeCmd(args);
            //没解析到命令不执行
            if(exeCmd == null) {
                return;
            }
            //添加字节码转换器
            instrumentation.addTransformer(new ExecTimerTransformer(exeCmd));
        } catch (Exception e) {
            LOG.warn("执行时长计数器代理程序执行启动失败错误信息如下，但不影响程序正常:");
            LOG.error(e.getMessage());
        }
    }
}
