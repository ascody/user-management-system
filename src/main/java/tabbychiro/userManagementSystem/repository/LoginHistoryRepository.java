package tabbychiro.userManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tabbychiro.userManagementSystem.entity.LoginHistory;

import java.util.List;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    List<LoginHistory> findByUserId(Long userId);
    List<LoginHistory> findBySuccess(boolean success);
}
