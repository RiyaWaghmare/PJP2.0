package com.sapient.data;

public interface QueryMapper {
	public static final String INSERT_PRODUCT 
							="insert into product values(?,?,?,?)";
	public static final String ALL_PRODUCTS="select * from product";
	public static final String GET_PRODUCT_PRICE="{? = CALL get_product_price(?)}";
	public static final String DELETE_PRODUCT="delete from product where product_id=?";
}
