package org.example.hello1.Repository;

import org.example.hello1.Entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findByChatId(String chatId);
}
