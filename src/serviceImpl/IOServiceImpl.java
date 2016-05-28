package serviceImpl;

import java.io.*;
import java.util.ArrayList;

import service.IOService;

public class IOServiceImpl implements IOService{

	public ArrayList<String> readFileFullName()  {
		ArrayList<String>   list = new ArrayList<>();
        try {
            String s;
            String[] s2 = {};
            String[] s3 = {};
            /**
             * s4是储存所有文件全名的字符串数组
             */
            Process process = Runtime.getRuntime().exec("cmd /c dir ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((s = bufferedReader.readLine()) != null) {
                s2 = s.split("/n");
                for (String a : s2) {
                    s3 = a.split(" ");
                    if (s3[s3.length - 1].endsWith(".txt")) {
                        list.add(s3[s3.length - 1]);
                    }
                }
                process.waitFor();
return  list;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
		/**
         for(int i=0;i<list.size();i++){
         System.out.println(list.get(i));
         }
         */
		return  list;
	}
	@Override
	public boolean writeFile(String file, String userId, String fileName,String time) {

		File f = new File(userId + "_" + fileName+"_"+time);
		try {
			FileWriter fw = new FileWriter(f, false);
			fw.write(file);
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String readFile(String userId, String fileName) {
		// TODO Auto-generated method stub
		return "OK";
	}

	@Override
	public String readFileList(String userId) {
		// TODO Auto-generated method stub
		return "OK";
	}
	
}
