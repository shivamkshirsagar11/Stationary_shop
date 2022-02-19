
public class prods {
public String id,name;public int items;public double price,tot;
public prods() {}
public prods(String id,String name,int items,double price) {
	this.id = id;
	this.items = items;
	this.price = price;
	this.name = name;
}
public void reduceItems(int i) {
	this.items -= i;
}
public void calculateTotal() {
	this.tot = items*price;
}
}
