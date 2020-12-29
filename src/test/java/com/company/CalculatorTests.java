package com.company;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTests {

  private Calculator calculator;

  @Before
  public void before() {
    calculator = new Calculator();
  }

  @Test
  public void shouldReturnZeroForEmptyString() {
    assertEquals(0, calculator.add(""));
  }

  @Test
  public void shouldReturnTheSameNumberForOneNumberInString() {
    assertEquals(1, calculator.add("1"));
    assertEquals(2, calculator.add("2"));
  }

  @Test
  public void shouldReturnCalculateResultForTwoNumbersInString() {
    assertEquals(3, calculator.add("1,2"));
  }

  @Test
  public void shouldReturnCalculateResultForMultipleNumbersInString() {
    assertEquals(6, calculator.add("1,2,3"));
    assertEquals(10, calculator.add("1,2,3,4"));
  }

  @Test
  public void shouldReturnCalculateResultForNewLinesBetweenNumbers() {
    assertEquals(6, calculator.add("1\n2,3"));
  }
}
