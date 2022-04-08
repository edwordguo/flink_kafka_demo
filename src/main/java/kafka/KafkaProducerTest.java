package kafka;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 *
 * Title: KafkaProducerTest
 * Description:
 * kafka 生产者demo
 * Version:1.0.0
 * @author pancm
 * @date 2022年3月30日
 */
public class KafkaProducerTest{

    public static void main(String[] args) throws InterruptedException {
    //    Properties props = new Properties();
    //    props.put("bootstrap.servers", "47.96.152.4:9092");
    //    props.put("acks", "all");
    //    props.put("retries", 1);
    //    props.put("batch.size", 16384);
    //    props.put("key.serializer", StringSerializer.class.getName());
    //    props.put("value.serializer", StringSerializer.class.getName());
    //    KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
    //    for (int i = 0; i < 10; i++) {
    //    ProducerRecord<String, String> sp =
    //            new ProducerRecord<>("demo2", Math.random() * 10+"", "1" + Math.random() * 10);
//
    //        producer.send(sp);
     //       System.out.println("发送第"+i+"次是key="+sp.key()+"value="+sp.value());
     //       Thread.sleep(1000);
     //   }
     //   producer.flush();
     //   producer.close();
        //配置信息
        Properties props = new Properties();
        //kafka服务器地址
        props.put("bootstrap.servers", "47.96.152.4:9092,47.97.120.25:9092,118.31.36.228:9092");
        //设置数据key和value的序列化处理类
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);
        //创建生产者实例
        KafkaProducer<String,String> producer = new KafkaProducer<>(props);
        for (int i= 0;  i< 10; i++) {

        ProducerRecord record = new ProducerRecord<String, String>("second", i*2+"", "lc"+i);
            //发送记录
            System.out.println("发送：name="+record.key()+"value="+record.value()+"分区信息:"+record.partition());
            producer.send(record);
        }
        producer.close();
    }
}
