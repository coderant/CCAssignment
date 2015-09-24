package ch10;

public class Solution105 {

    public static int find(String[] strings, String target) {

        int start = 0;
        int end = strings.length - 1;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            if (strings[mid].equals("")) {

                int left = mid - 1;
                int right = mid + 1;

                while (true) {
                    if (left < start && right > end) {
                        return -1;
                    } else if (right <= end && !strings[right].equals("")) {
                        mid = right;
                        break;
                    } else if (left >= start && !strings[left].equals("")) {
                        mid = left;
                        break;
                    }
                    right++;
                    left--;
                }
            }

            int compare = compare(target, strings[mid]);

            if (compare > 0) {
                start = mid;
            } else if (compare == 0) {
                return mid;
            } else {
                end = mid;
            }
        }

        if (strings[start].equals(target)) {
            return start;
        } else if (strings[end].equals(target)) {
            return end;
        } else {
            return -1;
        }

    }


    private static int compare(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return 0;
        } else if (s2.length() == 0) {
            return 1;
        } else if (s1.length() == 0) {
            return -1;
        }

        if (s1.charAt(0) != s2.charAt(0)) {
            return s1.charAt(0) - s2.charAt(0);
        } else {
            return compare(s1.substring(1), s2.substring(1));
        }

    }

    // Test Method Below

    public static void main(String[] args) {
        String[] strings = new String[]{"at", "", "", "", "", "", "ball", "bbb", "", "", "", "", "car", "", "", "dad", "", "", "", "hah"};

        System.out.println(find(strings, "bbb"));
    }


}
