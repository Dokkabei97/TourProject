package com.t4er.point.mapper;

import java.util.List;

import com.t4er.point.model.Product_PagingVO;
import com.t4er.point.model.ProductVO;
import com.t4er.point.model.Product_CategoryVO;

public interface ProductMapper {

    List<ProductVO> selectByPspec(String pspec);

    ProductVO selectByPnum(Integer pnum);

    List<ProductVO> selectByCategory(Product_PagingVO pvo);

    List<Product_CategoryVO> getCategory();

    List<ProductVO> getProdList(Product_PagingVO paging);

    int getProductTotalCount(Product_PagingVO paging);

    int getProductTotalCount();

    int getProductByCateTotalCount(Product_PagingVO paging);

}
