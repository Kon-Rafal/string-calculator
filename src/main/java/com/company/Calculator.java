package com.company;

class Calculator {
  private static final String DEFAULT_SEPARATOR = ",";


  int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains(DEFAULT_SEPARATOR)) {
      String[] arrayNumbers = numbers.split(DEFAULT_SEPARATOR);
      return Integer.parseInt(arrayNumbers[0]) + Integer.parseInt(arrayNumbers[1]);
    } else {
      return Integer.parseInt(numbers);
    }
   }
}
