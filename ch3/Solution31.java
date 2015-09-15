package ch3;

public class Solution31 {

    // stack 1: index 0 3 6 ...
    // stack 2: index 1 4 7 ...
    // stack 3: index 2 5 8 ...
    // auto double the length of the array when full

    // initial size = 30;

    private char[] array;

    private int[] currentIndex;
    private int biggest;

    public Solution31() {
        array = new char[6];

        currentIndex = new int[]{0,1,2};
        biggest = 2;
    }

    private void check() {
        if (biggest >= array.length) {
            char[] newArray = new char[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public void push0(char c) {
        array[currentIndex[0]] = c;
        currentIndex[0] += 3;
        if (currentIndex[0] >= biggest) {
            biggest = currentIndex[0];
        }

        check();
    }

    public char pop0() {
        if (currentIndex[0] > 2) {
            currentIndex[0] -= 3;
            return array[currentIndex[0] + 3];
        } else {
            System.out.println("Stack 0 is empty");
            return ' ';
        }
    }

    public void push1(char c) {
        array[currentIndex[1]] = c;
        currentIndex[1] += 3;
        if (currentIndex[1] >= biggest) {
            biggest = currentIndex[1];
        }

        check();

    }

    public char pop1() {
        if (currentIndex[1] > 2) {
            currentIndex[1] -= 3;
            return array[currentIndex[1] + 3];
        } else {
            System.out.println("Stack 1 is empty");
            return ' ';
        }
    }

    public void push2(char c) {
        array[currentIndex[2]] = c;
        currentIndex[2] += 3;
        if (currentIndex[2] >= biggest) {
            biggest = currentIndex[2];
        }

        check();
    }

    public char pop2() {
        if (currentIndex[2] > 2) {
            currentIndex[2] -= 3;
            return array[currentIndex[2] + 3];
        } else {
            System.out.println("Stack 2 is empty");
            return ' ';
        }
    }

    // Test Method Below

    public static void main(String[] args) {
        Solution31 threeStack = new Solution31();
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push0('1');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.push1('2');
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();
        threeStack.pop0();


        System.out.println(threeStack);

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 2; i++) {
            sb.append("Stack " + i + " is : (buttom -> top) ");

            for (int j = i; j < currentIndex[i]; j += 3){
                sb.append(array[j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
