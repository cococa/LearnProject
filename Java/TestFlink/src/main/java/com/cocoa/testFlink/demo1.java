package com.cocoa.testFlink;


import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class demo1 {

    public static void main(String[] args) throws Exception {

        ExecutionEnvironment executionEnvironment = ExecutionEnvironment.getExecutionEnvironment();

        DataSource<String> stringDataSource = executionEnvironment.readTextFile("D:\\cocoa\\LearnProject\\Java\\TestFlink\\src\\main\\resources\\words.txt");

        AggregateOperator<Tuple2<String, Integer>> sum = stringDataSource.flatMap(new LineFlatMap()).groupBy(0).sum(1);

        sum.print();

    }

    static class LineFlatMap implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            String[] array = value.split(" ");
            for (String item : array) {
                out.collect(new Tuple2<>(item, 1));
            }
        }
    }

}
