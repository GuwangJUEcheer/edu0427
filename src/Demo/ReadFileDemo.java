package Demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/*import java.nio.file.Files;
//import io.*代表引用io下的所有包，缺点：代码冗杂
import java.nio.file.Path;
import java.nio.file.Paths;
*/
import java.util.List;
import java.util.ArrayList;

public class ReadFileDemo {
	private static String email_filepath = "E:\\edu0427\\src\\u-email-gbk.txt";
	private static String phone_filepath = "E:\\edu0427\\src\\u-phone-gbk.txt";
	private static String on_filepath = "E:\\edu0427\\src\\u-combine.txt";

	public static void main(String[] args) {
		try {
			readFile1(email_filepath);
			//readFile2(phone_filepath);
			writeFile(on_filepath);
			CombineFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readFile1(String filepath) throws IOException {
		FileInputStream fin = new FileInputStream(filepath);// throw向上抛，谁调用谁抛出异常
		InputStreamReader reader = new InputStreamReader(fin, "GBK");
		BufferedReader buffer = new BufferedReader(reader);

		// 内容读取，使用while函数
		String strTmp = "";
		while ((strTmp = buffer.readLine()) != null) {
			// buffer.readline每调用一次就会读取一行的代码
			String[] str = strTmp.split("\\s");
			System.out.println(str[0] + "," + str[1] + "," + str[2]);
		}

		// 最重要的几行
		buffer.close();
		reader.close();
		fin.close();
	}

/*读写文件的第二种方法
	private static void readFile2(String filepath) throws IOException {
		// 使用NIO的方式读文件
		Path path = Paths.get(filepath);
		List<String> lines = Files.readAllLines(path);
		for (String line : lines) {
			System.out.println(line);
		}
		*/
	
	private static void writeFile(String filepath) throws IOException {
		File writeName =new File(filepath);
		//创建新文件，如果有同名文件直接覆盖
		writeName.createNewFile();
		
		FileWriter writer =new FileWriter(writeName);
		BufferedWriter out =new BufferedWriter(writer);
		out.write("Hello World \r\n");
		out.write("会当凌绝顶，一览众山小 \r\n");
		out.flush();
		out.close();
	}
	public static void CombineFile() throws IOException {
		List<String> f1_id =new ArrayList<String>();
		List<String> f1_name =new ArrayList<String>();
		List<String> f1_email =new ArrayList<String>();
		List<String> f2_id =new ArrayList<String>();
		List<String> f2_name =new ArrayList<String>();
		List<String> f2_phone =new ArrayList<String>();
	
		FileInputStream fin = new FileInputStream(filepath);
		InputStreamReader reader = new InputStreamReader(fin, "GBK");
		BufferedReader buffer = new BufferedReader(reader);
		
		String strTmp = "";
		buffer.readLine();
		while ((strTmp = buffer.readLine()) != null) {
			// buffer.readline每调用一次就会读取一行的代码
			String[] str = strTmp.split("\\s");
			f1_id.add(str[0]);
			f1_name.add(str[1]);
			f1_email.add(str[2]);
		}
		String strTmp = "";
		buffer.readLine();
		while ((strTmp = buffer.readLine()) != null) {
			// buffer.readline每调用一次就会读取一行的代码
			String[] str = strTmp.split("\\s");
			f2_id.add(str[0]);
			f2_name.add(str[1]);
			f2_phone.add(str[2]);
		}
	
		buffer.close();
		reader.close();
		fin.close();
		for(int i=0;i<f1_id.size();i++) {
			if(f1_id.contains(f2_id)) {
				System.out.println(f1_id.get(i)+f1_name.get(i)+f1_email.get(i)+"\t"+f2_phone.get(i));
			}else {
				System.out.println(f2_id.get(i)+f2_name.get(i)+"\t"+"---"+f2_phone.get(i));
			}
		}
		
		
		
		
		
		fin.close();
		
}