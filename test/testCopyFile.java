package com.demo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class testCopyFile 
{
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try
		{
			fis = new FileInputStream("testfile.txt");
			fos = new FileOutputStream("copy.txt");
			int x = fis.read();
			while(x != -1)
			{
				fos.write(x);
				x = fis.read();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		catch (IOException e) {
			System.out.println("IOException");
		}
		finally
		{
			try
			{
				fis.close();
				fos.close();
				System.out.println("Copied Successfully");
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
