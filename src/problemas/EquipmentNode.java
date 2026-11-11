package problemas;

public class EquipmentNode {
    private int code;
    private EquipmentNode left;
    private EquipmentNode right;

    public EquipmentNode(int code) {
        this.code = code;
        this.left = null;
        this.right = null;
    }

    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }

    public EquipmentNode getLeft() { return left; }

    public void setLeft(EquipmentNode left) { this.left = left; }

    public EquipmentNode getRight() { return right; }

    public void setRight(EquipmentNode right) { this.right = right; }


}