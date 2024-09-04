package REST_controller.demo.service;

import REST_controller.demo.entetie.Role;
import REST_controller.demo.reposotorie.RoleRepository;
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
