package REST_controller.demo.reposotorie;

import REST_controller.demo.entetie.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNameRole(String nameRole);
}




