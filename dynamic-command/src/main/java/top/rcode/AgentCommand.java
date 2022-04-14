package top.rcode;


import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author ：河神
 * @date ：Created in 2022/3/17 17:30
 */
public class AgentCommand {

    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        //目标VM线程ID
        VirtualMachine target = VirtualMachine.attach("10312");

        String agentOps = "top.rcode.controller.HelloController" +
                "," +
                "/Code/originLearn/JDK/Agent/Time/java-agent-project-/mvc-project/target/classes/top/rcode/controller/HelloController.class";

        target.loadAgent("/Code/originLearn/JDK/Agent/Time/java-agent-project-/agent/dynamic-agent/target/dynamic-agent-1.0-SNAPSHOT.jar",
                agentOps);

        target.detach();
    }
}
