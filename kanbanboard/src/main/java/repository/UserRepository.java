package repository;

import com.example.kanbanboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<repository.User, Long> {
    Optional<User> findByUsername(String username);
}
