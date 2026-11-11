package problemas;

public class BestEquipment {

    private EquipmentNode root;

    public BestEquipment() {
        this.root = null;
    }

    public void insert(int code) {
        this.root = insert(this.root, code);
    }

    private EquipmentNode insert(EquipmentNode current, int code) {
        if (current == null) {
            return new EquipmentNode(code);
        }
        if (code < current.getCode()) {
            current.setLeft(insert(current.getLeft(), code));
        } else if (code > current.getCode()) {
            current.setRight(insert(current.getRight(), code));
        }
        return current;
    }


    public int countEquipmentInRange(EquipmentNode current, int minBound, int maxBound){

        if(current == null || minBound > maxBound){
            return 0;
        }

        int count = 0;

        if(current.getCode() >= minBound && current.getCode() <= maxBound){
            count = 1;
        }

        if (current.getCode() > minBound) {
            count += countEquipmentInRange(current.getLeft(), minBound, maxBound);
        }

        if (current.getCode() < maxBound) {
            count += countEquipmentInRange(current.getRight(), minBound, maxBound);
        }

        return count;

    }

    public EquipmentNode getRoot() {
        return root;
    }

}
