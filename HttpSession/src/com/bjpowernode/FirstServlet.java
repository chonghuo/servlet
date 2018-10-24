package com.bjpowernode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 1.获得用户选中的[商品名称]
		String goodsName = req.getParameter("goods");
		// 2.向Tomcat申请获得当前用户的[私人储物柜]
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		// 设置session的最大空闲时间
		// session.setMaxInactiveInterval(60);
		// 3.判断当前用户的[私人储物柜]是否拥有一辆[购物车]
		Object shoppingCar = session.getAttribute("shoppingCar");
		if (shoppingCar == null) {// 新用户,储物柜没有购物车
			System.out.println("用户没有私人储物柜");
			// 为新用户创建一个购物车
			Map<String,Object> car = new HashMap<>();
			// 将[商品]存入[购物车]
			car.put(goodsName, 1);
			// [购物车]保存到当前用户的[私人储物柜]
			session.setAttribute("shoppingCar", car);
		} else {// 老用户,储物柜有购物车

			// 判断本次选择商品,在购物车是否已经存在
			Map<String,Object> car = (Map<String,Object>) shoppingCar;
			Object goodsNum = car.get(goodsName);// null or 数字
			if (goodsNum == null) {// 说明用户之前没有选择这种商品
				System.out.println("用户有私人储物柜,但是没有该商品");
				car.put(goodsName, 1);
			} else {// 说明用户之前有选择这种商品
				int num = (Integer) goodsNum;
				car.put(goodsName, ++num);
				System.out.println("用户有私人储物柜,有"+num+"个该商品");
			}
		}
	}
}
