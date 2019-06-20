package com.lovo.controller;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***************************************************************************
 *  *
 * 
 * <pre>
 * 生成二维码
 * </pre>
 * 
 *  * @文件名称:  QRCodeController.java  * @包   路   径：   * @版权所有：  *  * @类描述:  
 *  * @版本: V2.0  * @创建人：   * @创建时间：2017年8月16日 下午4:23:45  
 ***************************************************************************/
@Controller
public class QRCodeController {

	/**
	 *  *
	 * <p>
	 * 二维码内容
	 * </p>
	 *  * @Description:  * @param request  * @param response  * @throws Exception
	 */
	@RequestMapping("getQRCode.lovo")
	public void getQRCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content = "你是傻逼吗";
		encode(content, response);
	}

	/**
	 *  *
	 * <p>
	 * 生成二维码输出页面
	 * </p>
	 *  * @Description:  * @param content  * @param response  * @throws Exception
	 */
	public static void encode(String content, HttpServletResponse response) throws Exception {
		BufferedImage image = QRCodeTool.createImage(content);
		ImageIO.write(image, QRCodeTool.FORMAT_NAME, response.getOutputStream());
	}
}
