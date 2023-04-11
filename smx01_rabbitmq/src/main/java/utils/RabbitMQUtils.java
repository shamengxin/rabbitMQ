package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.sql.Statement;

public class RabbitMQUtils {

    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.108.129");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123");
    }

    //定义提供连接对象的方法
    public static Connection getConnection(){
        try{
            return connectionFactory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectionAndChanel(Channel channel, Connection connection){
        try{
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
