package flink;


import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
public class Transform_map {

        public static void main(String[] args) throws Exception {
            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

            env
                    .fromElements(1, 2, 3, 4, 5)
                    //匿名内部类对象 ???也可用静态内部类，自定义类实现MapFunction接口重写map方法
                    .map(new MapFunction<Integer, Integer>() {
                        @Override
                        public Integer map(Integer value) throws Exception {
                            return value * value;
                        }
                    })
                    .print();

            env.execute();
        }
    }

