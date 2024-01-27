public class Soldier{

    Integer experience;
    Integer value;
    Integer power;

    public Soldier(Integer experience, Integer value) {
        this.experience = experience;
        this.value = value;
        this.power = value * experience;
    }

    public Integer getExperience() {
        return experience;
    }

//    public String getGrade() {
//
//        String grade;
//
//        if(value==1){ String grade="Szeregowy";}
//        else if (value==2){ String grade="Kapral";}
//        else if (value==3){ String grade="Kapitan";}
//        else{{ String grade="Major";}}
//
//        return grade;
//    }

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
//
//    @Override
//    public void update(String string) {
//        WriteToFile write = new WriteToFile();
//        write.writeToFile("Current exp: " + experience + ", current value: " + value + ".");
    }
}






