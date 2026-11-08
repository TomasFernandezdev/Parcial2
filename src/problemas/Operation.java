package problemas;

public class Operation {
    private String code;
    private boolean isConfirmed;

    public Operation(String code, boolean isConfirmed) {
        this.code = code;
        this.isConfirmed = isConfirmed;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
