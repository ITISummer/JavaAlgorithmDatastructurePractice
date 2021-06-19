package practice.leetcode.easy;

/**
 * @ClassName DesignParkingSystem_1603
 * @Author LCX
 * @Date 2021 2021-06-19 2:11 p.m.
 * @Version 1.0
 **/
public class DesignParkingSystem_1603 {
    private int big;
    private int medium;
    private int small;

    public DesignParkingSystem_1603(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1: // big
                if (this.big > 0) {
                    this.big--;
                    return true;
                }
                return false;
            case 2: // medium
                if (this.medium > 0) {
                    this.medium--;
                    return true;
                }
                return false;
            case 3: // small
                if (this.small > 0) {
                    this.small--;
                    return true;
                }
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        DesignParkingSystem_1603 obj = new DesignParkingSystem_1603(1, 1, 0);
        System.out.println(obj.addCar(1));
        System.out.println(obj.addCar(2));
        System.out.println(obj.addCar(3));
        System.out.println(obj.addCar(1));
    }
}
