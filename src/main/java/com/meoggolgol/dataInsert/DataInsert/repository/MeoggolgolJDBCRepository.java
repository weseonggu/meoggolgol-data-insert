package com.meoggolgol.dataInsert.DataInsert.repository;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.meoggolgol.dataInsert.DataInsert.convertCSV.Meoggolgol;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MeoggolgolJDBCRepository {
	
	private final JdbcTemplate jdbc;
	
	private static String insert_MeoggolgolInfo=
			"""
			insert into Alley_information(FCLTY_NM, RDNMADR_NM, SIGNGU_CD, FCLTY_LO, FCLTY_LA, NEARBY_PBTRNSP_NM, PARKNG_POSBL_AT)
			VALUES(?,?,?,?,?,?,?);
			""";
	
	public void insert(ArrayList<Meoggolgol> list) {
		for (Meoggolgol mgg : list) {
			jdbc.update(insert_MeoggolgolInfo,
					mgg.getFCLTY_NM(),
					mgg.getRDNMADR_NM(),
					mgg.getSIGNGU_CD(),
					mgg.getFCLTY_LO(),
					mgg.getFCLTY_LA(),
					mgg.getNEARBY_PBTRNSP_NM(),
					mgg.getPARKNG_POSBL_AT()
					);
		}
	}
}
