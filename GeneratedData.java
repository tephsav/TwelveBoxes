public class GeneratedData {
    /**
     * массив со сгенерированными коробками
     */
    private Box[] randomBoxes;

    /**
     * индекс коробки, которая отличается по весу
     */
    private Integer correctBoxPosition;

    public GeneratedData(Box[] randomBoxes, Integer position) {
        this.randomBoxes = randomBoxes;
        this.correctBoxPosition = position;
    }

    public Box[] getRandomBoxes() {
        return randomBoxes;
    }

    public Integer getCorrectBoxPosition() {
        return correctBoxPosition;
    }
}