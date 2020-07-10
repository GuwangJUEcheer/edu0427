package edu0427.spring.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu0427.spring.service.DeptService;
import edu0427.spring.service.impl.DeptServiceImpl;
import edu0427.spring.vo.DeptInfo;

@SuppressWarnings("serial")
public class DeptServlet extends HttpServlet {
	/* 实现Servlet接口 */
	/* 继承geneicServlet实现service方法 */
	/* 继承HTTPSERVLET重写 */
	private DeptService deptservice;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		deptservice = new DeptServiceImpl();
		List<DeptInfo> list = deptservice.getDeptList();
		req.setAttribute("list", list);
		req.setAttribute("cnt", deptservice.getDeptCount());
		req.getRequestDispatcher("/dept.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
