package cluster;

import culster.ClusterService;
import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Classname cluster.ClusterServiceImpl
 * @Description 实例1
 * @Date 2024/6/3 下午2:00
 * @Created by 憧憬
 */
@DubboService
//        (cluster = ClusterRules.BROADCAST, weight = 10)   // 在注册端设置
public class ClusterServiceImpl implements ClusterService {
    @Override
    public String clusterService(String name) {
        try {
            System.out.println("服务一开始时间："+System.currentTimeMillis());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("服务一结束时间:" + System.currentTimeMillis());
        return "我是服务一：" + name;
    }
}
