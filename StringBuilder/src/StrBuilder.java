import java.util.Scanner;

public class StrBuilder {
    private static int result = 0;

    public static void method1() {
        //variables for left and right parts of expression
        //after first calculation:
        //variable 'result' - left part of expression,
        //variable 'lPartEx' - operand store('+' / '-' / '*' / '/').
        StringBuilder lPartEx = new StringBuilder();
        StringBuilder rPartEx = new StringBuilder();

        Scanner input = new Scanner(System.in);
        StringBuilder expression;   //variable 'expression' expression store

        int startFromIndex = 0;

        //repeat while 'expression' is empty and 'lPartEx' store less 2 of chars
        //first symbol in variable 'lPartEx' always '+' or '-' depending on expression
        do {
            do {
                System.out.print("Enter your expression: ");
                expression = new StringBuilder(input.nextLine());

                if(expression.length() == 0) {
                    System.out.println("String with expression is empty.");
                }
            } while(expression.length() == 0);

            //find operand('+'/'-') before number
            lPartEx.append(plusOrMinus(expression));

            for(int i = 0; i < expression.length(); i++) {
                //find number or digit and add them to variable 'lPartEx'
                //also we find index(last occurrence of a digit or number) which be start next cycle
                if(isInRange(i, expression, '0', '9')) {    //
                    if(((i + 1) < expression.length()) && (isOperator(i + 1, expression))) {
                        lPartEx.append(expression.charAt(i));
                        startFromIndex = i + 1;
                        break;
                    }

                    lPartEx.append(expression.charAt(i));
                    startFromIndex = i;
                }
            }

            if(lPartEx.length() < 2) {
                System.out.println("Error! Incorrect string. Please enter string which have to digits or numbers using operators.");
                lPartEx.delete(0, lPartEx.length());
            }
        } while(lPartEx.length() < 2);

        input.close(); //close scanner

        result = Integer.parseInt(lPartEx.toString());  //string to int conversion
        lPartEx.delete(0, lPartEx.length());  //clear left part of expression

        for(int i = startFromIndex; i < expression.length(); i++) {
            //variable 'lPartEx' - operand store('+' / '-' / '*' / '/').
            //add current(i) chars to left part of expression
            lPartEx.append(expression.charAt(i));

            //find number or digit and add them to variable 'lPartEx'
            //after this, we calculate variable 'lPart' and 'rPart' use one of operator()
            if(isOperator(i, expression)) {
                int index = i;

                while (index < expression.length() && (isOperator(index, expression))) {
                        index++;
                }

                while (index < expression.length() && isInRange(index, expression, '0', '9')) {
                    rPartEx.append(expression.charAt(index++));
                }

                i = --index;

                //if right part of expression is empty
                if(rPartEx.length() == 0) {
                    continue;
                }

                toOperate(lPartEx.charAt(lPartEx.length() - 1), rPartEx);
            }

            //clear left and right parts of expression
            lPartEx.delete(0, lPartEx.length());
            rPartEx.delete(0, rPartEx.length());

//                System.out.println("Local result: " + result);
        }

        System.out.println("Result of expression: " + result);
    }

    public static void method2(int [] array)
    {
        if(array.length % 2 == 0) {
            for(int i = array.length/2, start = 0; i < array.length; i++, start++) {
                array[i] = start;
                array[array.length - i - 1] = start;
            }
        } else {
            int middleIndex = array.length/2;
            array[middleIndex] = 0;
            for(int i = array.length/2 + 1; i < array.length; i++) {
                array[i] = i - middleIndex;
                array[array.length - i - 1] = i - middleIndex;
            }
        }
    }

    public static void method3()
    {
        StringBuilder string = new StringBuilder();

        Scanner ch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("==========");
            System.out.println("1 - Add/Delete substring");
            System.out.println("2 - Show main string");
            System.out.println("3 - Exit");
            System.out.println("==========");

            System.out.print("Your choice: ");

            if(ch.hasNextInt())
                switch (ch.nextInt()) {
                    case 1: {

                        StringBuilder substring = null;

                        do {
                            do {
                                System.out.println("==========");
                                System.out.println("Enter \"+your_substring\" for add or \"-your_substring\" for delete this substring from main string");
                                System.out.print("Your substring: ");

                                substring = new StringBuilder(input.nextLine());

                                if(substring.length() < 1) {
                                    System.out.println("==========");
                                    System.out.println("String haven't to empty and have to start with '+' or '-'");
                                }
                            } while(substring.length() < 1);



                            if(substring.charAt(0) != 43 && substring.charAt(0) != 45) {
                                System.out.println("==========");
                                System.out.println("The operator is entered incorrectly. Use \"+your_substring\" or \"-your_substring\"");
                            }
                        } while (substring.charAt(0) != 43 && substring.charAt(0) != 45);

                        if(substring.charAt(0) == 43) {
                            substring.deleteCharAt(0);  //delete "+" from first char in substring
                            string.append(substring).append(" ");
                        } else if(substring.charAt(0) == 45) {
                            substring.deleteCharAt(0);  //delete "-" from first char in substring

                            if (string.lastIndexOf(substring.toString()) != -1)
                                string.delete(string.lastIndexOf(substring.toString()), string.lastIndexOf(substring.toString()) + substring.length() + 1);
                            else {
                                System.out.println("==========");
                                System.out.println("Substring not found. Check if substring is entered correctly");
                            }
                        }

                    }
                    case 2: {
                        System.out.println("==========");
                        System.out.println("Your main string: " + string);
                    }
                    case 3 : {
                        System.out.println("==========");
                        System.out.println("Bye");
                        System.out.println("==========");
                        return;
                    }
                    default: {
                        System.out.println("==========");
                        System.out.println("Value have to 1 - 3");
                    }
                }
            else {
                ch.nextLine();
                System.out.println("==========");
                System.out.println("Enter integer value(value have to 1 - 3)");
            }
        }
    }

    private static char plusOrMinus(StringBuilder string) {
        int countMinus = 0;

        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == 45) {
                countMinus++;
                if((i + 1) < string.length() && string.charAt(i + 1) != 45) {
                    break;
                }
            } else break;
        }

        if(countMinus == 0)
            return '+';

        if(countMinus > 0 && countMinus % 2 == 0) {
            return '+';
        } else {
            return '-';
        }
    }

    private static boolean isInRange(int index, StringBuilder sting, char from, char to) {
        return sting.charAt(index) >= from && sting.charAt(index) <= to;
    }

    private static boolean isOperator(int index, StringBuilder sting) {
        // 42 == '*', 43 == '+', 44 == ',', 45 == '-', 46 == '.', 47 == '/'
        return sting.charAt(index) >= 42 && sting.charAt(index) <= 47;
    }

    private static void toOperate(char operator, StringBuilder secondPartExpression) {
        switch (operator) {
            case 42 : result *= Integer.parseInt(secondPartExpression.toString());
            case 43 : result += Integer.parseInt(secondPartExpression.toString());
            case 45 : result -= Integer.parseInt(secondPartExpression.toString());
            case 47 : result /= Integer.parseInt(secondPartExpression.toString());
        }
    }

    public static void showArray(int[] array)
    {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
