package com.example.exam_module5.User;

import com.example.exam_module5.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public class User {
        private Long  id;
        private String username;
        private String password;
        private String email;
        private String role= Role.USER.name();
    }

