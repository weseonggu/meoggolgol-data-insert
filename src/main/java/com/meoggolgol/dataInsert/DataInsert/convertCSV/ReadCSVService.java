package com.meoggolgol.dataInsert.DataInsert.convertCSV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service

public class ReadCSVService {
	
	public ArrayList<Meoggolgol> readMeoggolgolcsv() {
		BufferedReader br = null;
		ArrayList<SiDoGun> sidogun = readsidoguncsv();
		try {
			FileInputStream fis = new FileInputStream("C:/Users/fkskd/OneDrive/문서/0cc26c206b569b25.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String line = null;
			String data[] = null;
			Meoggolgol meoggolgol=null;
			ArrayList<Meoggolgol> meoggolgolList = new ArrayList<>();
			String convertsidoguncode=null;
			// 파일 읽어서 리스트 생성
			while ((line = br.readLine()) != null) {
				data = line.split(",");
				
				
				
				// 시도군 코드 한긓이름으로 변경
				for (SiDoGun sdg : sidogun) {
					if(sdg.getCode().equals(data[2])) {
						convertsidoguncode = sdg.getLocation();
						break;
					}
				}
				
				
				
				
				
				
				
				meoggolgol=  new Meoggolgol(data[0], data[1], convertsidoguncode, Double.parseDouble(data[3]), Double.parseDouble(data[4]), data[5], data[6]);
				meoggolgolList.add(meoggolgol);
			}
			return meoggolgolList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	private ArrayList<SiDoGun> readsidoguncsv() {
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:/Users/fkskd/OneDrive/문서/행정동_코드_김홍시.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

            String line = null;
            String[] data = null;
            String chagedData = null;
            Set<String> set = new TreeSet<>();
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                chagedData = data[0].substring(0, 5)+ "," + data[1] + " " + data[2];
                set.add(chagedData);
            }
            
            String readline[]=null;
            ArrayList<SiDoGun> sidogun = new ArrayList<>();
            
            for (String dataSet : set) {
            	readline = dataSet.split(",");
            	try {
            		String code = Integer.parseInt(readline[0])+"";
            		sidogun.add(new SiDoGun(code, readline[1]));
            		
            	}catch (Exception e) {
					continue;
				}
            }
            
            return sidogun;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
		return null;
	}
}
