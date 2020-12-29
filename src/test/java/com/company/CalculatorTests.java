package com.company;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTests {

  private Calculator calculator;

  @Before
  public void before() {
    calculator = new Calculator();
  }

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

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

  @Test
  public void shouldReturnCalculateResultForChangeDelimiters() {
    assertEquals(3, calculator.add("//;\n1;2"));
    assertEquals(6, calculator.add("//;-\n1;-2;-3"));
    assertEquals(6, calculator.add("// *** \n1 *** 2 *** 3"));
    assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
  }

  @Test
  public void shouldThrowExceptionForStringWithNegativeNumbers() {
    exceptionRule.expect(NegativeNumbersException.class);
    exceptionRule.expectMessage("negatives not allowed: [-1, -2]");
    calculator.add("-1,-2");
  }

  @Test
  public void shouldIgnoreNumbersBiggerThan1000() {
    assertEquals(2, calculator.add("2,1001"));
    assertEquals(1002, calculator.add("2,1000"));
  }
}
