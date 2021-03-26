package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Location {

	public static void main(String[] args) {
		
	
		Path text = Paths.get("d:\\경기도.txt");  	// 읽기용 파일 이름과 경로
		Path text2 = Paths.get("d:\\location2.txt");	// 쓰기용 파일 이름과 경로
				
				try {
					BufferedReader reader = Files.newBufferedReader(text); // 파일 엵기용
					BufferedWriter writer = Files.newBufferedWriter(text2);// 파일 쓰기용
					
					String s = reader.readLine();  // 첫줄 읽기
					String sql = "insert into tblLocation values(seqLocation.nextVal, '";
					String sqlEnd = "');";
					
					
					while(s != null) {   // 읽은 내용이 있으면...
						
							System.out.println(s);	
							writer.write( sql + s + sqlEnd + "\n"); // new line 추가해서 출력 				
							s = reader.readLine();  // 다음 줄 읽기
						
						
					}
					
					writer.flush(); // 쓰기 버퍼 비움 --> 파일에 저장 
					writer.close();	// 파일 닫기
					reader.close();	// 파일 닫기 
				} catch (IOException e) {
					System.out.println("File Error!!!");			
				}
			}
		
		
	}
