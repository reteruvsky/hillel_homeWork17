public class ArraysMethods {

    public int[] pullElementsAfterLastFour(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("Array is empty");
        }

        int lastFourIndex = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                lastFourIndex = i;
                break;
            }
        }

        if (lastFourIndex == -1) {
            return new int[0];
        }

        int[] newArr = new int[arr.length - lastFourIndex - 1];
        for (int i = lastFourIndex + 1; i < arr.length; i++) {
            newArr[i - lastFourIndex - 1] = arr[i];
        }
        return newArr;
    }

    public boolean checkOneAndFour(int[] arr) {
        if (arr.length == 0) {
            return false;
        }

        boolean oneFound = false;
        boolean fourFound = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                oneFound = true;
            } else if (arr[i] == 4) {
                fourFound = true;
            }
            if (oneFound && fourFound) {
                return true;
            }
        }

        return false;
    }
}
