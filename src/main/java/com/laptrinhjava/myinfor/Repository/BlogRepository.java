package com.laptrinhjava.myinfor.Repository;

import com.laptrinhjava.myinfor.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository  extends JpaRepository<BlogEntity, Integer> {
}
