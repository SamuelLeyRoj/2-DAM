package com.safa.testspringboot.Repository;

import com.safa.testspringboot.Models.ChatParticipantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatParticipantesRepository extends JpaRepository<ChatParticipantes,Integer> {
}
