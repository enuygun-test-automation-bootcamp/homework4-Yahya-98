public class Pet {

    public int id,petid,quantity;
    public String shipDate,status;
    public boolean complete;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getPetid(){
        return petid;
    }
    public void setPetid(int petid){
        this.petid = petid;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getShipDate(){
        return shipDate;
    }
    public void setShipDate(String shipDate){
        this.shipDate = shipDate;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public boolean getComplete(){
        return complete;
    }

    public void setComplete(boolean complete){
        this.complete = complete;
    }
}
