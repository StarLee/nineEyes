package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

public class Weibo
{
	public static void main(String[] args)
	{
		try
		{
			URL url=new URL("http://v.youku.com/v_playlist/f17034686o1p0.html");
			
			char[] buffer=new char[1024];
			
				InputStreamReader stream=new InputStreamReader(url.openStream(),"utf-8");
				while(stream.read(buffer)>-1)
				{
					System.out.println(buffer);
				}
			
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
