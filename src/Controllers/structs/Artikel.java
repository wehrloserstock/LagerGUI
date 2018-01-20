package Controllers.structs;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Artikel {
    private IntegerProperty id;
    private StringProperty name;
    private IntegerProperty stock;
    private FloatProperty price; //will be converted to and from BigInt when calcing.

    public static final int ID_MIN = 0;
    public static final int ID_MAX = 9999;

    public Artikel(){
        this.id = new SimpleIntegerProperty(0000);
        this.name = new SimpleStringProperty("sample");
        this.stock = new SimpleIntegerProperty(0);
        this.price = new SimpleFloatProperty(0F);
    }

    public Artikel(int id, String name, int stack, BigDecimal price){
        this(id, name, stack);
        if(price.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Price is below Zero!");
        }
        this.price = new SimpleFloatProperty(price.floatValue());

    }

    public Artikel(int id, String name, int stack){
        this(id, name);
        if(stack < 0 ){
            throw new IllegalArgumentException("Stack is below 0!");
        }
        this.stock = new SimpleIntegerProperty(stack);
    }

    public Artikel(int id, String name){
        if(id < ID_MIN || id > ID_MAX){
            throw new IllegalArgumentException("ID below 0 or above 9999!");
        }else if (name.isEmpty()){
            throw new IllegalArgumentException("Name is empty!");
        }
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);

    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getStock() {
        return stock.get();
    }

    public IntegerProperty stackProperty() {
        return stock;
    }

    public void setStack(int stack) {
        this.stock.set(stack);
    }

    public float getPrice() {
        return price.get();
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }
}
