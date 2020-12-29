package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Calculator {
  private static final String DEFAULT_SEPARATOR = "[,\n]";


  int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else {
      return fromStringToNumber(numbers).stream().reduce(0, Integer::sum);
    }
  }

  private List<Integer> fromStringToNumber(String numbers) {

    if (numbers.startsWith("//")) {
      String[] result = numbers.split("\n", 2);
      String customDelimiter = result[0].substring(2, numbers.indexOf("\n"));
      String delimiters = "(" + customDelimiter + ")|(\n)";

      numbers = numbers.substring(2).replaceAll(customDelimiter+"\n","");
      return Arrays.stream(numbers.split(delimiters)).map(Integer::parseInt).collect(Collectors.toList());
    }
    return Arrays.stream(numbers.split(DEFAULT_SEPARATOR)).map(Integer::parseInt).collect(Collectors.toList());
  }
}
