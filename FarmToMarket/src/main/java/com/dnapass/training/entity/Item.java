package com.dnapass.training.entity;

import jakarta.persistence.*;

@Entity
@Table
//(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
    private String itemName;
    private Integer itemQuantity;
    @ManyToOne
    @JoinColumn(name="id")
    private User user;
    private String itemDescription;
//    private Integer id;

    public Item(String itemname, String itemdescription, Integer quantity, User user)
    {
        this.itemName = itemname;
        this.itemDescription = itemdescription;
        this.itemQuantity = quantity;
        this.user = user;
    }
    public Item(Integer itemId, String itemName, Integer itemQuantity, User user, String itemType) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.user = user;
        this.itemDescription = itemType;
    }
    public Item()
    {

    }

    public Item(int itemId, String potato, String vegetable, int i, User user) {
        this.itemId = itemId;
        this.itemName = potato;
        this.itemDescription = vegetable;
        this.itemQuantity = i;
        this.user = user;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemType(String itemType) {
        this.itemDescription = itemType;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
}
