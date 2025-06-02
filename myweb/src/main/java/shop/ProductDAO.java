package shop;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sqlmap.MybatisManager;

public class ProductDAO {
    public List<ProductDTO> listProduct() {
        SqlSession session = MybatisManager.getInstance().openSession();
        List<ProductDTO> list = session.selectList("product.list_product");
        session.close();
        return list;
    }

    public ProductDTO detailProduct(int product_code) {
        SqlSession session = MybatisManager.getInstance().openSession();
        ProductDTO dto = session.selectOne("product.detail_product", product_code);
        session.close();
        return dto;
    }
    
    public void updateProduct(ProductDTO dto) {
        SqlSession session = MybatisManager.getInstance().openSession();
        session.update("product.update_product", dto);
        session.commit();
        session.close();
    }

    public void deleteProduct(int product_code) {
        SqlSession session = MybatisManager.getInstance().openSession();
        session.delete("product.delete_product", product_code);
        session.commit();
        session.close();
    }

    public void insertProduct(ProductDTO dto) {
        SqlSession session = MybatisManager.getInstance().openSession();
        session.insert("product.insert_product", dto);
        session.commit();
        session.close();
    }

    public String fileInfo(int product_code) {
        SqlSession session = MybatisManager.getInstance().openSession();
        String result = session.selectOne("product.file_info", product_code);
        session.close();
        return result;
    }
}

