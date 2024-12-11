public class HomeWork14 {
    public static boolean myContains(char[] arr, char[] text, int fromIndex) {
        if (text.length + fromIndex > arr.length) {
            return false;
        }
        int i = 0;
        while (i < text.length) {
            if (arr[i + fromIndex] != text[i]) {
                return false;
            }
            i++;
        }
        return true;
    }


    public static int myIndexOf(char[] arr, char[] text, int fromIndex) {
        int i = fromIndex;
        while (i <= arr.length - text.length) {
            if (myContains(arr, text, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int myCountContains(char[] arr, char[] text) {
        int count = 0;
        int i = 0;
        while (i <= arr.length - text.length) {
            if (myContains(arr, text, i)) {
                i += text.length;
                count++;
                i++;
            }
        }
        return count;
    }

    public static char[] myReplaceAll(char[] original, char[] old, char[] newStr) {
        int countEnter = myCountContains(original, old);
        if (countEnter == 0) {
            return original;
        }

        int newSize = original.length - (old.length * countEnter) + (newStr.length * countEnter);

        char[] result = new char[newSize];

        int startIndex = 0; // po starimy massivu
        int findIndex = 0; //index vhojdenia
        int resultIndex = 0; // po novomu massivu

        while ((findIndex = myIndexOf(original, old, startIndex)) != -1) {

            result = arrayCopy(original, startIndex, result, resultIndex, findIndex - startIndex);
            resultIndex += findIndex - startIndex;

            result = arrayCopy(newStr, 0, result, resultIndex, newStr.length);
            resultIndex += newStr.length;

            startIndex = findIndex + old.length;

        }
        result = arrayCopy(original, startIndex, result, resultIndex, original.length - startIndex);

        return result;
    }

    public static char[] arrayCopy(char[] original, int index, char[] dest, int destIndex, int leng) {
        int i = 0;
        while (i < leng) {
            dest[destIndex + i] = original[index + i];
            i++;
        }
        return dest;
    }

    public static void main(String[] args) {
        // public static char[] replaceAll(char[] original,char[] oldStr,char[] newStr)
        //реализовать этот метод используя ( либо while ) (либо   do while)
        String str = "Aria";
        String old = "Aria";
        String replacing = "Kipelov";
        System.out.println(str);

        char[] search = str.toCharArray();
        char[] oldChar = old.toCharArray();
        char[] replacingChar = replacing.toCharArray();

        char[] result = myReplaceAll(search, oldChar, replacingChar);

        int i = 0;
        while (i < result.length) {
            System.out.print(result[i]);
            i++;
        }
    }
}
