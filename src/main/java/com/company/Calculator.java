package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Calculator {
  private static final String DEFAULT_SEPARATOR = ",";


  int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains(DEFAULT_SEPARATOR)) {
      return fromStringToNumber(numbers).stream().reduce(0, Integer::sum);
    } else {
      return Integer.parseInt(numbers);
    }
   }

  private List<Integer> fromStringToNumber(String numbers) {
    return Arrays.stream(numbers.split(DEFAULT_SEPARATOR)).map(Integer::parseInt).collect(Collectors.toList());
  }
}
