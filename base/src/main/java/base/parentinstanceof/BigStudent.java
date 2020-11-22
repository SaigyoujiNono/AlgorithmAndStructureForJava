package base.parentinstanceof;

public class BigStudent extends Student {
    private String schoolCity;
    private Integer entranceExamScore;

    public BigStudent() {
    }

    public void doLove() {
        System.out.println("BigStudent做爱");
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
    }

    public Integer getEntranceExamScore() {
        return entranceExamScore;
    }

    public void setEntranceExamScore(Integer entranceExamScore) {
        this.entranceExamScore = entranceExamScore;
    }

    @Override
    public String toString() {
        return "BigStudent{" +
                super.toString()+
                "schoolCity='" + schoolCity + '\'' +
                ", entranceExamScore='" + entranceExamScore + '\'' +
                '}';
    }
}
