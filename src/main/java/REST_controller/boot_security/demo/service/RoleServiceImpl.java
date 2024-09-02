package REST_controller.boot_security.demo.service;

import REST_controller.boot_security.demo.entetie.Role;
import REST_controller.boot_security.demo.reposotorie.RoleRepository;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class RoleServiceImpl implements RoleService {

    final private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }


}
