package flink;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Transform_filter {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    // 保留偶数, 舍弃奇数
env
        .fromElements(10, 3, 5, 9, 20, 8)
        .filter(new FilterFunction<Integer>() {
        @Override
        public boolean filter(Integer value) throws Exception {
            return value % 2 == 0;
        }
    })
            .print();
env.execute();
    }
}
