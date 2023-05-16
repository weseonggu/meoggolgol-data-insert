package com.meoggolgol.dataInsert.DataInsert.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MeoggolgolJDBCRepository {
	private final JdbcTemplate jdbc;
}
