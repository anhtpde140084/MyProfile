package com.laptrinhjava.myinfor.Repository;

import com.laptrinhjava.myinfor.model.BlogEntity;
import com.laptrinhjava.myinfor.model.InforAccEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InforAccRepository extends JpaRepository<InforAccEntity, Integer> {
}
