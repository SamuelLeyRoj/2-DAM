package com.safa.testspringboot.Repository;

import com.safa.testspringboot.Models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat,Integer> {

}
