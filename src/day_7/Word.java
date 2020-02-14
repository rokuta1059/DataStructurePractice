package day_7;

class Word {

    int index;
    int count;

    public Word(int index) {
        this.index = index;
        count = 1;
    }

    public Word(int index, Word next) {
        this.index = index;
        count = 1;
    }

    public int index() {
        return index;
    }

    public int count() {
        return count;
    }

    public String toString() {
        return index + ": " + count + " ";
    }

    public boolean equals(Word another) {
        return another.index == index;
    }

    public void countup() {
        count++;
    }
}
