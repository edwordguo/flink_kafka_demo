package flink;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Transform_keyby {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 奇数分一组, 偶数分一组
        env
                .fromElements(10, 3, 5, 9, 20, 8)
                //keyBy按key分组后输出到不同task，相当于按key分区，shuffle是打乱输出到下游的组合
                .keyBy(new KeySelector<Integer, String>() {
                    @Override
                    public String getKey(Integer value) throws Exception {
                        return value % 2 == 0 ? "偶数" : "奇数";
                    }
                })
                .print();
        env.execute();
    }
}
