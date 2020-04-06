package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Member100;

public interface MemberDao extends JpaRepository<Member100, String> {
}
