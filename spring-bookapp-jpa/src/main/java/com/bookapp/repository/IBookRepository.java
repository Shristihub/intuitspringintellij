package com.bookapp.repository;

import com.bookapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {

    //derived query
    //readBy.findBy,queryBy,getBy
     List<Book> findByPriceLessThanEqual(double price);
     List<Book> findByCategory(String category);

    //custom query
     // JPQL
     @Query(value = "from Book b where b.category =?1 and b.price <=?2")
    List<Book> findByCatLessPrice(String category,double price);

     @Query(value="select * from book where category=?1 and cost<?2",nativeQuery = true)
    List<Book> findByCatPrice(String category,double price);

    //native query
    @Query(value = "select * from book where title like %?1%",nativeQuery = true)
    List<Book> findByTitleContains(String choice);

}
