/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author gal sajja
 */
public class inventoryCon {
    
    private String itemNo;
    private String itemName;
    private String type;
   // private String supId;
    private float weight;
    private float price;

    public inventoryCon(String itemNo, String itemName, String type, float weight, float price) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.type = type;
      //  this.supId = supId;
        this.weight = weight;
        this.price = price;
    }

    public inventoryCon(String iNum) {
    this.itemNo=iNum;
        }
    
    

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//   public String getSupId() {
//        return supId;
//    }
//
//    public void setSupId(String supId) {
//        this.supId = supId;
//    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
