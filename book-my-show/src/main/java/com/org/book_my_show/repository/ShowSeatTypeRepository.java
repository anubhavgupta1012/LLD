package com.org.book_my_show.repository;

import com.org.book_my_show.models.Show;
import com.org.book_my_show.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Integer> {

    List<ShowSeatType> findAllByShow(Show show);
}
