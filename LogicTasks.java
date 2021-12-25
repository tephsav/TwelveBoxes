import java.util.Arrays;

public class LogicTasks {
    public static void main(String[] args) {
        GeneratedData generatedBoxesInfo = getTwelveBoxesWithOneNonNormalBox();
        int position = getNonNormalBox(generatedBoxesInfo.getRandomBoxes());
        System.out.println(position == generatedBoxesInfo.getCorrectBoxPosition());
    }

    /* Входные параметры для примера теста
    * тут всегда отличается 7 коробка */
    private static GeneratedData getTwelveBoxesWithOneNonNormalBox() {
        Box[] randomBoxes = new Box[12];
        for (int i = 0; i < 12; i++) {
            randomBoxes[i] = new Box(5);
        }
        randomBoxes[7] = new Box(3);
        return new GeneratedData(randomBoxes, 7);
    }

    /* Ваша задача - реализовать этот метод.
       getNonNormalBox должен вернуть позицию коробки в массиве, отличающейся по value от остальных одинаковых коробок.
     */
    private static int getNonNormalBox(Box[] boxes) {
        Box[] fourBoxes1 = Arrays.copyOfRange(boxes, 0, 4);
        Box[] fourBoxes2 = Arrays.copyOfRange(boxes, 4, 8);
        Box[] fourBoxes3 = Arrays.copyOfRange(boxes, 8, 12);
        Box[] fiveBoxesLeft = new Box[5];   // индексы из исходного массива : 0 1 2 4 5
        Box[] fiveBoxesRight = new Box[5];  // индексы из исходного массива : 3 8 9 10 11
        System.arraycopy(fourBoxes1, 0, fiveBoxesLeft, 0, 3);
        System.arraycopy(fourBoxes2, 0, fiveBoxesLeft, 3, 2);
        System.arraycopy(fourBoxes1, 3, fiveBoxesRight, 0, 1);
        System.arraycopy(fourBoxes3, 0, fiveBoxesRight, 1, 4);

        int comparing1 = Box.comparing(fourBoxes1, fourBoxes2);

        if (comparing1 == 0) {  // 0 1 2 3 == 4 5 6 7
            int comparing2 = Box.comparing(boxes[9], boxes[10]);

            if (comparing2 == 0) {  // 9 == 10
                int comparing3 = Box.comparing(boxes[0], boxes[8]);

                if (comparing3 == 0) {  // 0 == 8
                    return 11;
                } else {
                    return 8;
                }
            } else {
                int comparing3 = Box.comparing(boxes[0], boxes[9]);

                if (comparing3 == 0) {  // 0 == 9
                    return 10;
                } else {
                    return 9;
                }
            }
        } else if (comparing1 == 1) {   // 0 1 2 3 > 4 5 6 7
            int comparing2 = Box.comparing(fiveBoxesLeft, fiveBoxesRight);

            if (comparing2 == 0) {  // 0 1 2 4 5 == 3 8 9 10 11
                int comparing3 = Box.comparing(boxes[6], boxes[7]);

                if (comparing3 == 1) {  // 6 > 7
                    return 7;
                } else if (comparing3 == -1) { // 6 < 7
                    return 6;
                }
            } else if (comparing2 == 1) {   // 0 1 2 4 5 > 3 8 9 10 11
                int comparing3 = Box.comparing(boxes[0], boxes[1]);

                if (comparing3 == 0) {  // 0 == 1
                    return 2;
                } else if (comparing3 == 1) {   // 0 > 1
                    return 0;
                } else if (comparing3 == -1) {  // 0 < 1
                    return 1;
                }
            } else if (comparing2 == -1) {  // 0 1 2 4 5 < 3 8 9 10 11
                int comparing3 = Box.comparing(boxes[4], boxes[5]);

                if (comparing3 == 0) {  // 4 == 5
                    return 3;
                } else if (comparing3 == 1) {   // 4 > 5
                    return 5;
                } else if (comparing3 == -1) {  // 4 < 5
                    return 4;
                }
            }
        } else if (comparing1 == -1) {  // 0 1 2 3 < 4 5 6 7
            int comparing2 = Box.comparing(fiveBoxesLeft, fiveBoxesRight);

            if (comparing2 == 0) {  // 0 1 2 4 5 == 3 8 9 10 11
                int comparing3 = Box.comparing(boxes[6], boxes[7]);

                if (comparing3 == 1) {  // 6 > 7
                    return 6;
                } else if (comparing3 == -1) { // 6 < 7
                    return 7;
                }
            } else if (comparing2 == 1) {   // 0 1 2 4 5 > 3 8 9 10 11
                int comparing3 = Box.comparing(boxes[4], boxes[5]);

                if (comparing3 == 0) {  // 4 == 5
                    return 3;
                } else if (comparing3 == 1) {   // 4 > 5
                    return 4;
                } else if (comparing3 == -1) {  // 4 < 5
                    return 5;
                }
            } else if (comparing2 == -1) {  // 0 1 2 4 5 < 3 8 9 10 11
                int comparing3 = Box.comparing(boxes[0], boxes[1]);

                if (comparing3 == 0) {
                    return 2;
                } else if (comparing3 == 1) {
                    return 1;
                } else if (comparing3 == -1) {
                    return 0;
                }
            }
        }

        return 0;
    }
}

