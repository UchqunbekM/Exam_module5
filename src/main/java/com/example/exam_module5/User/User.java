package com.example.exam_module5.User;

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
    }

