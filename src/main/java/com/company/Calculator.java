package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Calculator {

  int add(String numbers) {
    if (numbers.isEmpty()) return 0;
    return adding(numbers);

  }

  private int adding(String numbers) {
    List<Integer> numbersList = fromStringToNumber(numbers);
    checkNegativeNumbersExistInString(numbersList);
    return numbersList.stream().filter(number -> number <=1000).reduce(0, Integer::sum);
  }

  private void checkNegativeNumbersExistInString(List<Integer> numbersList) {
    ArrayList<Integer> negativeNumbers = new ArrayList<>();
    for (Integer number : numbersList) {
      if (number < 0) negativeNumbers.add(number);
    }
    if (negativeNumbers.size() > 0)
      throw new NegativeNumbersException("negatives not allowed: " + negativeNumbers.toString());
  }

  private String createCustomDelimiters(String inputString){
    final String[] metaCharacters = {"\\","^","$","{","}","[","]","(",")",".","*","+","?","|","<",">","-","&","%"};

    inputString = inputString.replaceAll("]\\[", "S");
    inputString = inputString.replaceAll("\\[", "");
    inputString = inputString.replaceAll("]", "");

    for (String metaCharacter : metaCharacters) {
      if (inputString.contains(metaCharacter)) {
        inputString = inputString.replace(metaCharacter, "\\" + metaCharacter);
      }
    }
    inputString = inputString.replaceAll("S", "|");
    return inputString + "|\n";
  }

  private List<Integer> fromStringToNumber(String numbers) {
    if (numbers.startsWith("//")) {
      String[] result = numbers.split("\n", 1);
      String customDelimiter = createCustomDelimiters(result[0].substring(2, numbers.indexOf("\n")));

      numbers = numbers.substring(numbers.indexOf("\n")+1);
      return Arrays.stream(numbers.split(customDelimiter)).map(Integer::parseInt).collect(Collectors.toList());
    }
    String defaultSeparator = "[,\n]";
    return Arrays.stream(numbers.split(defaultSeparator)).map(Integer::parseInt).collect(Collectors.toList());
  }
}
