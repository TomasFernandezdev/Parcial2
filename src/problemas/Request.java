package problemas;

public class Request {

    private String code;
    private String priority;
    private int duration;

    public Request(String code, String priority, int duration) {
        this.code = code;
        this.priority = priority;
        this.duration = duration;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return this.code;
    }

}
