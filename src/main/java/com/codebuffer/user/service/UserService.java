package com.codebuffer.user.service;

import com.codebuffer.user.VO.Department;
import com.codebuffer.user.VO.ResponseTemplateVO;
import com.codebuffer.user.entity.User;
import com.codebuffer.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(int userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findById(userId).orElseThrow(null);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId() ,Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
