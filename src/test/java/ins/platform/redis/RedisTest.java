package ins.platform.redis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisTest {
	public static void main(String[] args) throws IOException {
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		// Jedis集群将自动发现集群中的所有节点，理论上配置集群中任意一个节点即可，
		// 但当该节点down时，初次启动将无法进行，建议配置为集群中规划的几个必备主节点地址
		 jedisClusterNodes.add(new HostAndPort("10.10.68.43", 6379));
		 jedisClusterNodes.add(new HostAndPort("10.10.68.145", 6379));
		 jedisClusterNodes.add(new HostAndPort("10.10.68.146", 6379));

//		jedisClusterNodes.add(new HostAndPort("10.10.1.233", 6379));
//		jedisClusterNodes.add(new HostAndPort("10.10.1.233", 6381));
//		jedisClusterNodes.add(new HostAndPort("10.10.1.234", 6379));
//		jedisClusterNodes.add(new HostAndPort("10.10.1.234", 6381));
		JedisCluster jc = new JedisCluster(jedisClusterNodes);

		for (int i = 0; i < 1000000; i++) {
			String key = "foo" + i;
			String val = "bar=" + i;
			jc.set(key, "bar=" + i);
			String value = jc.get(key);
			if(!val.equals(value)){
				System.err.println("取值不对");
			} 
			if(i%100==0){
				System.out.println();
			}
			System.out.print(".");
			jc.pexpire(key, 10000);
		}
		jc.close();
	}
}
