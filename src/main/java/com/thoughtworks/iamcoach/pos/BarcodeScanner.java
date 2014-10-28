package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.CartItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BarcodeScanner implements Scanner{
    public Product getProduct(String barcode) throws IOException {

        DataProvider dataProvider = new DataProvider();
        List<Product> list = dataProvider.getProductList();

        for(Product product : list){
            if(product.getBarcode().equals(barcode)){
                return product;
            }
        }
        return null;
    }

    @Override
    public List scan(List<String> barcodes) throws IOException {
        List<CartItem> cartitemList = new ArrayList<CartItem>();

        for(String str : barcodes){
            cartitemList = this.addCount(str,cartitemList);
        }
        return cartitemList;
    }

    private int getIndex(String barcode,List<CartItem> cartitemList){

        for(int i = 0; i < cartitemList.size(); i++){
            if(cartitemList.get(i).getProduct().getBarcode().equals(barcode)){
                return i;
            }
        }
        return -1;
    }

    private List<CartItem> addCount(String str, List<CartItem> cartitemList) throws IOException {

        String []fields = str.split("-");
        String barcode = fields[0];
        double count = this.getCount(fields);

        Product product = this.getProduct(barcode);
        int index = this.getIndex(barcode,cartitemList);

        if( index == -1){
            CartItem cartitem = new CartItem(product,count);
            cartitemList.add(cartitem);
        }else{
            CartItem cartitem = cartitemList.get(index);
            cartitem.setCount(cartitem.getCount()+1);
            cartitemList.set(index,cartitem);
        }
        return cartitemList;
    }
    
    private double getCount(String []fields){

        double count = 1;

        if(fields.length>1){
            count = Double.parseDouble(fields[1]);
        }
        return count;
    }
}
