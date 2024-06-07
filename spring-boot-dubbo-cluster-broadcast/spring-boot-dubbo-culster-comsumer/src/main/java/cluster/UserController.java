package cluster;

import culster.ClusterService;
import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname cluster.UserController
 * @Description 测试控制器
 * @Date 2024/6/3 下午1:57
 * @Created by 憧憬
 */
@RestController
public class UserController {
    @DubboReference
            (cluster = ClusterRules.BROADCAST
            , parameters = {"broadcast.fail.percent", "50"}, timeout = 5000)
    private ClusterService cs;

    @RequestMapping("/hello")
    public String broadcastTest() {
        String result = null;
        try {
            result = cs.clusterService("广播");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(result);
        return result;
    }

    @RequestMapping("/hello2")
    public String normalTest(){
        String result = null;
        try {
            result = cs.clusterService("普通测试");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(result);
        return result;
    }
}
