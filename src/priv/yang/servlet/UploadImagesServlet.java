package priv.yang.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//@WebServlet("/UploadImagesServlet")
public class UploadImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UploadImagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取上传的文件
		Part part=request.getPart("img");
		String tempname=part.getSubmittedFileName();
		System.out.println(tempname);
		//2.把上传的图片保存在本地的服务器中的位置
		String path=getServletContext().getRealPath("/upload");
		System.out.println(path);
		String newname=System.currentTimeMillis()+tempname.substring(tempname.lastIndexOf("."));
		String final_path = path+"/"+newname;
		//3.写入文件 返回上传后的文件路径
		part.write(final_path);
		//4.转换为网络图片
		String url=request.getScheme()+"://"+request.getHeader("Host")+request.getContextPath()+request.getServerPort()+path+"/";
		System.out.println(url);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
