package test.ch1;

import ch1.Solution11;

public class Test11 {
    public static void main(String[] args) {
        test("Unique wr˜˚∆¨ˆ\"09876œ∑ßåΩ",
                "Uni df123",
                "Unique wr˜˚∆¨ˆ\"09876œ∑ßåΩ",
                "NotUnique˜˜",
                "  ",
                "", null);
    }

    public static void test(String... strs) {
        for (String str : strs) {
            Solution11.isUnique(str);
        }
    }
}
