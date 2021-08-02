package ernesto.alvarez.portafolio.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJDA, Integer> {
    public List<UserJDA> findAllByOrderByScoreDesc();

}
