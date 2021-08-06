package pers.pan.springHW.Order;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "orderId")
    private long orderId;

    @Column(name = "SKUId")
    private long SKUId;

    @Column(name = "nums")
    private int nums;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getSKUId() {
        return SKUId;
    }

    public void setSKUId(long SKUId) {
        this.SKUId = SKUId;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }
}
