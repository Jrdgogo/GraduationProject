package com.mmt.tourism.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mmt.tourism.dao.PhotoMapper;
import com.mmt.tourism.pojo.po.Photo;
import com.mmt.tourism.pojo.po.PhotoExample;

@WebServlet(urlPatterns = "/view/photo")
public class ViewPhotoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());
		
		PhotoMapper mapper = context.getBean(PhotoMapper.class);
		Photo photo = null;
		String id = request.getParameter("id");
		if (id != null && !"".equals(id.trim()))
			photo = mapper.selectByPrimaryKey(id);
		if (photo == null) {
			String code = request.getParameter("code");
			if (code != null) {
				PhotoExample example = new PhotoExample();
				example.createCriteria().andCodeEqualTo(request.getParameter("code"));
				List<Photo> photos = mapper.selectByExampleWithBLOBs(example);
				if (photos != null && !photos.isEmpty()) {
					int index=new Random().nextInt(photos.size());
					photo = photos.get(index);
				}
			}
		}
		BufferedImage bufImg = null;

		if (photo != null) {
			InputStream inputStream = new ByteArrayInputStream(photo.getPhoto());
			bufImg = ImageIO.read(inputStream);
		} else {
			InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("default.jpg");
			bufImg = ImageIO.read(in);
		}
		ImageIO.write(bufImg, "JPEG", response.getOutputStream());
	}

}
