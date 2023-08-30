class Subject {
    private String name;
    private int marksObtained;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        if (marksObtained >= 0 && marksObtained <= 100) {
            this.marksObtained = marksObtained;
        } else {
            System.out.println("Invalid marks entered for " + name);
        }
    }
}
