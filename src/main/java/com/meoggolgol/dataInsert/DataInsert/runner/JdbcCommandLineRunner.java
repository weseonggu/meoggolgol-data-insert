package com.meoggolgol.dataInsert.DataInsert.runner;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.meoggolgol.dataInsert.DataInsert.convertCSV.Meoggolgol;
import com.meoggolgol.dataInsert.DataInsert.convertCSV.ReadCSVService;
import com.meoggolgol.dataInsert.DataInsert.convertCSV.SiDoGun;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class JdbcCommandLineRunner implements CommandLineRunner {
	
	private final ReadCSVService rcs;
	@Override
	public void run(String... args) throws Exception {
		ArrayList<Meoggolgol> list = rcs.readMeoggolgolcsv();
		for (Meoggolgol meoggolgol : list) {
			System.out.println(meoggolgol);
		}

	}
}
