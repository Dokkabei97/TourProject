package com.t4er.point.service;

import com.t4er.point.model.Product_PagingVO;
import com.t4er.point.model.ProductVO;
import com.t4er.point.model.Product_CategoryVO;

import java.util.List;

public interface PointService {
    /* Pspec 별로 상품 정보 가져오기 */
    List<ProductVO> selectByPspec(String pspec);
    /* 카테고리별 상품정보 가져오기 */
    List<ProductVO> selectByCategory(Product_PagingVO pvo);
    /** 상품번호로 특정 상품 정보 가져오기 */
    ProductVO selectByPnum(Integer pnum);

    List<Product_CategoryVO> getCategory();

    int getProductTotalCount();
    int getProductTotalCount(Product_PagingVO paging);

    List<ProductVO> getProdList(Product_PagingVO paging);
    int getProductByCateTotalCount(Product_PagingVO paging);

}
