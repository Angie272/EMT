package com.example.emtlab.repository;
import com.example.emtlab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book,Long> {
}
