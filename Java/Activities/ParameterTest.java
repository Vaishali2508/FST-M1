package examples;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;

public class ParameterTest {
    @ParameterizedTest
    @ValueSource(strings = {"Test1", "Test2"})
    public void addTest(String str){
        System.out.println(str);

    }
    @ParameterizedTest
    @CsvFileSource (files="C:\\Users\\0036K0744\\IdeaProjects\\M1-Jul23-01-Java\\src\\test\\resources\\input.csv", numLinesToSkip = 1)
    public void csvTest(ArgumentsAccessor args){
        System.out.println(args.getString(0) + "," + args.get(1, Date.class)
                + "," + args.getDouble(2) + "," + args.getInteger(3));


    }
}
