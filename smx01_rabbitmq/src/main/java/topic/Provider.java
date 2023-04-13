package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics","topic");

        //指定route key
        String routeKey = "user.save.findAll";

        //发布消息
        channel.basicPublish("topics",routeKey,null,("这里是topic动态路由模型，routekey：["+routeKey+"]").getBytes());

        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }
}
