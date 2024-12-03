package REST_controller.demo.reposotorie;

import REST_controller.demo.entetie.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
