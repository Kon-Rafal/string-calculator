package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Calculator {
  private static final String DEFAULT_SEPARATOR = ",|\n";


  int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else {
      return fromStringToNumber(numbers).stream().reduce(0, Integer::sum);
    }
   }

  private List<Integer> fromStringToNumber(String numbers) {
    return Arrays.stream(numbers.split(DEFAULT_SEPARATOR)).map(Integer::parseInt).collect(Collectors.toList());
  }
}
