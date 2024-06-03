package cluster;

import culster.ClusterService;
import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Classname cluster.ClusterServiceImpl
 * @Description 实例2
 * @Date 2024/6/3 下午2:00
 * @Created by 憧憬
 */
@DubboService
//        (cluster = ClusterRules.BROADCAST, weight = 10)
public class ClusterServiceImpl implements ClusterService {
    @Override
    public String clusterService(String name) {
        try {
            System.out.println("服务二开始时间："+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("服务二启动");
        return "我是服务二:" + name;
    }
}
