//请不要修改本文件名
package serviceImpl;

import java.io.DataInputStream;
import java.io.IOException;
import java.rmi.RemoteException;

import service.ExecuteService;
import service.UserService;

public class ExecuteServiceImpl implements ExecuteService {

	/**
	 * 请实现该方法
	 */
	private int tempOrder;
	private int tempObject;
	private StringBuffer stringBuffer=new StringBuffer();
	private String output;
	private String deal(char[] input1,char[]object){
		int i=0;
		//System.out.println("字母是"+(char)(object[i]));
		int m=0;
		do{
			//System.out.println("in circle");
			assert object[i]>0;
			switch(input1[m]){
				case'+':
					object[i]=(char) (object[i]+1);

					break;
				case'-':
					object[i]=(char) (object[i]-1);
					break;
				case'>':
					i++;
					break;
				case'<':
					i--;
					break;
				case'[':
					tempObject=i;
					tempOrder=m;
					break;
				case']':
					if(object[tempObject]==0){
						break;
					}
					else{
						//i=tempObject;
						m=tempOrder;
						break;
					}
				case'.':
					stringBuffer.append((char)(object[i]));
					output=stringBuffer.toString();
				case',':
					DataInputStream in = new DataInputStream(System.in);
					try {
						char ch = (char)in.read();
						object[i]=ch;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:
					break;
			}
			m++;
		}while(m<input1.length);
		return output;
	}
	public String execute(String code, String param) throws RemoteException {
		// TODO Auto-generated method stub

			char[] object=new char[15];
			for(int i=0;i<object.length;i++){
				object[i]=0;
			}
		char[] input=code.toCharArray();
			String output="";
		output=deal(input,object);
		return output;
	}

}
