public class Soldier{

    public enum valueGrade{
        gradeOne(1, "Szeregowy"),
        gradeTwo(2, "Kapral"),
        gradeThree(3, "Kapitan"),
        gradeFour(4, "Major");

        private final int rank;
        private final String grade;

        valueGrade(int rank, String grade) {
            this.rank = rank;
            this.grade = grade;
        }
        public int getRank() {
            return rank;}

        public String getGrade(){
            return grade;}
    }
    Integer experience;
    Integer value;
    Integer power;

    public Soldier(Integer value) {
        this.experience = 1;
        this.value = value;
        this.power = value * experience;

    }

        public String getGrade() {
            String actualGrade="Unknow";
            for (valueGrade rank : valueGrade.values()) {
                if (rank.getRank() == value) {
                    actualGrade=rank.getGrade();
                }
            }
            return actualGrade;
        }

        public Integer getExperience() {
        return experience;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getPower() {
        return power;
    }

    public void experienceGain() {
        experience += 1;

        if (experience == 5 * value) {
            experience = 1;
            value += 1;
        }
    }

    public void experienceLoss() {
        experience -= 1;
    }

//    @Override
//    public void update(String string) {
//        WriteToFile write = new WriteToFile();
//        write.writeToFile("Current exp: " + experience + ", current value: " + value + ".");
    }







