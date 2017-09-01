package leetcode412;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
Write a program that outputs the string representation of numbers 
from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the 
multiples of five output “Buzz”. For numbers which are multiples of both three and 
five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

 * @author liyuncong
 *
 */
public class FizzBuzz {
    int size;
    List<String> answer = new AbstractList<String>() {
    	@Override
    	public String get(int i) {
           i++;
           return i % 15 == 0 ? "FizzBuzz" :
                   i % 5 == 0 ? "Buzz" :
                           i % 3 == 0 ? "Fizz" :
                                   Integer.toString(i);
       }

       public int size() {
           return size;
       }
   };

   public List<String> fizzBuzz(int n) {
       size = n;
       return answer.subList(0, n);
   }
}
