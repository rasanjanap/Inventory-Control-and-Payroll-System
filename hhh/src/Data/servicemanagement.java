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
public class servicemanagement {
    
     private String ServiceId;
    private String Type;
    private String CusId;
    private String EmpdId;


    public servicemanagement(String ServiceId, String Type, String CusId, String EmpdId) {
        this.ServiceId = ServiceId;
        this.Type = Type;
        this.CusId = CusId;
        this.EmpdId = EmpdId;
    }

    public servicemanagement(String ServiceId) {
        this.ServiceId = ServiceId;
    }
    

    public servicemanagement(String ServiceId , String type) {
        this.ServiceId = ServiceId;
        this.Type = type;
    }
    
    
    public String getServiceId() {
        return ServiceId;
    }

    public void setServiceId(String ServiceId) {
        this.ServiceId = ServiceId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getCusId() {
        return CusId;
    }

    public void setCusId(String CusId) {
        this.CusId = CusId;
    }

    public String getEmpdId() {
        return EmpdId;
    }

    public void setEmpdId(String EmpdId) {
        this.EmpdId = EmpdId;
    }
    
}
