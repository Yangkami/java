package priv.yang.servlet;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.Color;
/**
 * Servlet implementation class loginValidatacodeservleet
 */
@WebServlet("/loginValidatacodeservleet")
public class loginValidatacodeservleet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random random;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginValidatacodeservleet() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置响应类型为文件
		response.setContentType("image/jpg");
		//2.获取输出流
		ServletOutputStream out = response.getOutputStream();
		//3.创建一个临时存储画布
		int width=80;
		int height=25;
		BufferedImage bufferdimg =new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		//4.创建一个2d图片对象
		Graphics2D g=bufferdimg.createGraphics();
		g.setColor(getRadomColor());
		g.fillRect(0, 0, width, height);
		//Random random=new Random(); ///??????
		//5.绘制干扰线
		for(int i=0;i<5;i++){
			
			g.setColor(getRadomColor());
			int x1=random.nextInt(height);
			int y1=random.nextInt(width);
			int x2=random.nextInt(width);
			int y2=random.nextInt(height);
			g.drawLine(20, 20, width, height);
		}
		//6.绘制干扰点
		for(int j=0;j<5;j++){
			g.setColor(getRadomColor());
			int x1=random.nextInt(width);
			int y1=random.nextInt(height);
			g.drawOval(x1, y1, 5, 5);
			g.fillOval(x1, y1, 5, 5);
		}
		//7.添加随机数字
		String str="";
		int tempy=20;
		for(int m=0;m<4;m++){
			int rt=random.nextInt(10);
			Font font=new Font(rt+"",Font.BOLD,24);
			
			//str+=rt+"";
			
			g.drawString(font.toString(), Font.ITALIC, 40);
			str+=rt+"";
			
			tempy+=40;
		}
		//HttpServletRequest request = null; //?????
		//8.将数字添加到session
		HttpSession session = request.getSession();
		session.setAttribute("SESSIONVALIDATECODE", str);
		//9.输出图片
		ImageIO.write(bufferdimg, "jpg", out);
		out.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private Color getRadomColor(){
		Random random=new Random();
		int r= random.nextInt(255);
		int g= random.nextInt(255);
		int b= random.nextInt(255);
		return new Color(r,g,b);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
