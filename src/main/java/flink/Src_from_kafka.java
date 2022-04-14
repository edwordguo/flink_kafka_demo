package flink;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import java.util.Properties;

public class Src_from_kafka {

        public static void main(String[] args) throws Exception {

            // 0.Kafka相关配置
            Properties properties = new Properties();
            properties.setProperty("bootstrap.servers", "47.96.152.4:9092,47.97.120.25:9092,118.31.36.228:9092");
            properties.setProperty("group.id", "test1");
            properties.setProperty("auto.offset.reset", "latest");

            // 1. 创建执行环境
            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
            env
                    .addSource(new FlinkKafkaConsumer<>("second", new SimpleStringSchema(), properties))
                    .print("kafka source");

            env.execute();
        }
    }

