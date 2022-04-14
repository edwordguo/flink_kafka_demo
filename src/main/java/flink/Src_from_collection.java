package flink;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import pojo.WaterSensor;

import java.util.Arrays;
import java.util.List;

//从集合创建数据源
public class Src_from_collection {


        public static void main(String[] args) throws Exception {
            List<WaterSensor> waterSensors = Arrays.asList(
                    new WaterSensor("ws_001", 1577844001L, 45),
                    new WaterSensor("ws_002", 1577844015L, 43),
                    new WaterSensor("ws_003", 1577844020L, 42));

            // 1. 创建执行环境
            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
            //从集合创建数据源
            env.fromCollection(waterSensors)
               .print();
            env.execute();
        }
    }

