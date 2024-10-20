package calculator.domain;

import calculator.domain.vo.CustomValues;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class StringCalculator {

    private static final String DISTINGUISHED = "[,;]";

    public static final String BEGIN_DATA = "//";

    public CustomValues extractCustomValue(String value) {
        if (value.startsWith(BEGIN_DATA)) {
            return new CustomValues(value.substring(2,3));
        }
        return new CustomValues(DISTINGUISHED);
    }

    public String removeValue(String value) {
        if (value.startsWith(BEGIN_DATA)) {
            return value.substring(value.indexOf("n") + 1);
        }
        return value;
    }

    public String[] createNewValue(String removeAfterValue, String separatorValue) {
        return removeAfterValue.split(separatorValue);
    }

    public List<Integer> saveValue(String[] newValue) {
        return Arrays.stream(newValue)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int calculateSum(List<Integer> calculationValue) {
        return calculationValue.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
