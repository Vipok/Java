package List2;

import lombok.Getter;

//класс с параметрами
@Getter
class Products {
    private String nameOfProduct;
    private int counts;

    Products(String nameOfProduct, int counts) {
        this.nameOfProduct = nameOfProduct;
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "Name of item: " + getNameOfProduct()
                + "; Count: " + getCounts();
    }
}