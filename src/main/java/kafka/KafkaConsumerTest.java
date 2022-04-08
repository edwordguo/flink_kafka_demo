package kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


/**
 *
 * Title: KafkaConsumerTest
 * Description:
 *  kafka消费者 demo
 * Version:1.0.0
 * @author pancm
 * @date 2022年3月30日
 */
public class KafkaConsumerTest {
    //默认 test-consumer-group
    private static final String GROUPID = "test1";



            public static void main(String[] args) {
                //配置信息
                Properties props = new Properties();
                //kafka服务器地址
                props.put("bootstrap.servers", "47.96.152.4:9092,47.97.120.25:9092,118.31.36.228:9092");
                //必须指定消费者组
                props.put("group.id", GROUPID);
                //设置数据key和value的序列化处理类
                props.put("key.deserializer", StringDeserializer.class);
                props.put("value.deserializer", StringDeserializer.class);
                //创建消息者实例
                KafkaConsumer<String,String> consumer = new KafkaConsumer<>(props);
                //订阅topic1的消息
                consumer.subscribe(Arrays.asList("second"));
                //到服务器中读取记录
                while (true){
                    ConsumerRecords<String,String> records = consumer.poll(100);
                    for(ConsumerRecord<String,String> record : records){
                        System.out.println("消费到到：key:" + record.key() + "" + ",value:" + record.value()
                        +" 记录到偏移量"+record.offset()+" 记录到分区"+record.partition()+" 主题"+record.topic()

                        );
                    }
                }
            }
        }

